/*
 * Copyright (C) 2019 The Turms Project
 * https://github.com/turms-im/turms
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package im.turms.turms.workflow.service.impl.message;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.SetMultimap;
import im.turms.common.constant.DeviceType;
import im.turms.common.model.dto.notification.TurmsNotification;
import im.turms.common.model.dto.request.TurmsRequest;
import im.turms.server.common.cluster.node.Node;
import im.turms.server.common.log4j.ClientApiLogging;
import im.turms.server.common.property.TurmsPropertiesManager;
import im.turms.server.common.property.env.common.ClientApiLoggingProperties;
import im.turms.server.common.property.env.service.env.clientapi.property.LoggingRequestProperties;
import im.turms.server.common.rpc.request.SendNotificationRequest;
import im.turms.server.common.service.session.UserStatusService;
import im.turms.server.common.util.LoggingRequestUtil;
import im.turms.server.common.util.ProtoUtil;
import im.turms.server.common.util.ReactorUtil;
import io.netty.buffer.ByteBuf;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.constraints.NotNull;
import java.util.*;

/**
 * @author James Chen
 */
@Service
@Log4j2
public class OutboundMessageService {

    private final Node node;
    private final UserStatusService userStatusService;
    private final Map<TurmsRequest.KindCase, LoggingRequestProperties> supportedLoggingNotificationProperties;

    public OutboundMessageService(Node node, TurmsPropertiesManager propertiesManager, UserStatusService userStatusService) {
        this.node = node;
        this.userStatusService = userStatusService;
        ClientApiLoggingProperties loggingProperties = propertiesManager.getLocalProperties().getGateway().getClientApi().getLogging();
        supportedLoggingNotificationProperties = LoggingRequestUtil.getSupportedLoggingRequestProperties(
                loggingProperties.getIncludedNotificationCategories(),
                loggingProperties.getIncludedNotifications(),
                loggingProperties.getExcludedNotificationCategories(),
                loggingProperties.getExcludedNotificationTypes());
    }

    /**
     * @return true if recipientIds is empty, or at least one recipient has received the notification
     */
    public Mono<Boolean> forwardNotification(
            @NotNull TurmsNotification notification,
            @NotNull Set<Long> recipientIds) {
        return forwardNotification(notification, ProtoUtil.getDirectByteBuffer(notification), recipientIds);
    }

    /**
     * @return true if recipientIds is empty, or at least one recipient has received the notification
     */
    public Mono<Boolean> forwardNotification(
            @NotNull TurmsNotification notificationForLogging,
            @NotNull ByteBuf notificationData,
            @NotNull Set<Long> recipientIds) {
        if (recipientIds.isEmpty()) {
            return Mono.just(true);
        } else {
            Mono<Boolean> mono = recipientIds.size() == 1
                    ? forwardClientMessageByRecipientId(notificationData, recipientIds.iterator().next())
                    : forwardClientMessageByRecipientIds(notificationData, recipientIds);
            return tryLogNotification(mono, notificationForLogging);
        }
    }

    /**
     * @return true if recipientIds is empty, or at least one recipient has received the notification
     */
    public Mono<Boolean> forwardNotification(
            @NotNull TurmsNotification notificationForLogging,
            @NotNull ByteBuf notificationData,
            @NotNull Long recipientId,
            @NotNull DeviceType excludedDeviceType) {
        return userStatusService.getDeviceAndNodeIdMapByUserId(recipientId)
                .flatMap(deviceTypeAndNodeIdMap -> {
                    List<String> nodeIds = new ArrayList<>(deviceTypeAndNodeIdMap.size());
                    for (Map.Entry<DeviceType, String> entry : deviceTypeAndNodeIdMap.entrySet()) {
                        DeviceType deviceType = entry.getKey();
                        if (deviceType != excludedDeviceType) {
                            nodeIds.add(entry.getValue());
                        }
                    }
                    if (nodeIds.isEmpty()) {
                        return Mono.just(false);
                    }
                    int size = nodeIds.size();
                    Mono<Boolean> mono;
                    if (size == 1) {
                        mono = forwardClientMessageToNode(notificationData, nodeIds.iterator().next(), recipientId);
                    } else {
                        List<Mono<Boolean>> monos = new ArrayList<>(size);
                        for (String nodeId : nodeIds) {
                            monos.add(forwardClientMessageToNode(notificationData, nodeId, recipientId));
                        }
                        mono = ReactorUtil.atLeastOneTrue(monos);
                    }
                    return tryLogNotification(mono, notificationForLogging);
                })
                .defaultIfEmpty(false);
    }

    /**
     * @return true if recipientIds is empty, or at least one recipient has received the notification
     */
    private Mono<Boolean> forwardClientMessageByRecipientIds(
            @NotNull ByteBuf messageData,
            @NotNull Set<Long> recipientIds) {
        if (recipientIds.isEmpty()) {
            return Mono.just(true);
        }
        int recipientIdsSize = recipientIds.size();
        if (recipientIdsSize == 1) {
            return forwardClientMessageByRecipientId(messageData, recipientIds.iterator().next());
        } else {
            int expectedMembersCount = Math.min(node.getDiscoveryService().getAllKnownMembers().size(), recipientIdsSize);
            int expectedRecipientCountPerMember = Math.min(1, recipientIdsSize / expectedMembersCount);
            SetMultimap<String, Long> userIdsByNodeId = HashMultimap.create(expectedMembersCount, expectedRecipientCountPerMember);
            List<Mono<RecipientAndNodeIds>> monos = new ArrayList<>(recipientIdsSize);
            for (Long recipientId : recipientIds) {
                monos.add(userStatusService.getDeviceAndNodeIdMapByUserId(recipientId)
                        .map(map -> new RecipientAndNodeIds(recipientId, map.values())));
            }
            return Flux.merge(monos)
                    .doOnNext(pair -> {
                        for (String nodeId : pair.getNodeIds()) {
                            userIdsByNodeId.put(nodeId, pair.getRecipientId());
                        }
                    })
                    .then(Mono.defer(() -> {
                        Multiset<String> nodeIds = userIdsByNodeId.keys();
                        List<Mono<Boolean>> monoList = new ArrayList<>(nodeIds.size());
                        for (String nodeId : nodeIds) {
                            monoList.add(forwardClientMessageByRecipientIds(messageData, userIdsByNodeId.get(nodeId)));
                        }
                        return ReactorUtil.atLeastOneTrue(monoList);
                    }));
        }
    }

    /**
     * @return true if at least one recipient has received the notification
     */
    private Mono<Boolean> forwardClientMessageByRecipientId(
            @NotNull ByteBuf notificationData,
            @NotNull Long recipientId) {
        return userStatusService.getDeviceAndNodeIdMapByUserId(recipientId)
                .flatMap(deviceTypeAndNodeIdMap -> {
                    Collection<String> nodeIds = deviceTypeAndNodeIdMap.values();
                    if (nodeIds.isEmpty()) {
                        return Mono.just(false);
                    }
                    int size = nodeIds.size();
                    if (size == 1) {
                        return forwardClientMessageToNode(notificationData, nodeIds.iterator().next(), recipientId);
                    } else {
                        List<Mono<Boolean>> monos = new ArrayList<>(size);
                        for (String nodeId : nodeIds) {
                            monos.add(forwardClientMessageToNode(notificationData, nodeId, recipientId));
                        }
                        return ReactorUtil.atLeastOneTrue(monos);
                    }
                })
                .defaultIfEmpty(false);
    }

    private Mono<Boolean> forwardClientMessageToNode(
            @NotNull ByteBuf messageData,
            @NotNull String nodeId,
            @NotNull Long recipient) {
        SendNotificationRequest request = new SendNotificationRequest(
                messageData,
                Set.of(recipient));
        return node.getRpcService()
                .requestResponse(nodeId, request);
    }

    private Mono<Boolean> tryLogNotification(Mono<Boolean> mono, TurmsNotification notification) {
        if (LoggingRequestUtil.shouldLog(notification.getRelayedRequest().getKindCase(), supportedLoggingNotificationProperties)) {
            return mono
                    .doOnSuccess(sent -> {
                        String message = sent ? "Sent: " : "Unsent: ";
                        ClientApiLogging.log(message + notification);
                    });
        } else {
            return mono;
        }
    }

    @Data
    private static class RecipientAndNodeIds {
        private final Long recipientId;
        private final Collection<String> nodeIds;
    }

}
