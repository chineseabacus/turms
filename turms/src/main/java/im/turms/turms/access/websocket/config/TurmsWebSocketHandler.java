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

package im.turms.turms.access.websocket.config;

import com.github.davidmoten.rtree2.geometry.internal.PointFloat;
import com.google.common.net.InetAddresses;
import im.turms.common.TurmsCloseStatus;
import im.turms.common.TurmsStatusCode;
import im.turms.common.constant.DeviceType;
import im.turms.common.constant.UserStatus;
import im.turms.common.model.bo.signal.Session;
import im.turms.common.model.dto.notification.TurmsNotification;
import im.turms.turms.access.websocket.dispatcher.InboundMessageDispatcher;
import im.turms.turms.cluster.TurmsClusterManager;
import im.turms.turms.common.SessionUtil;
import im.turms.turms.common.UserAgentUtil;
import im.turms.turms.constant.CloseStatusFactory;
import im.turms.turms.service.user.onlineuser.OnlineUserService;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SignalType;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.net.InetSocketAddress;
import java.time.Duration;
import java.util.Collections;
import java.util.Map;

@Component
public class TurmsWebSocketHandler implements WebSocketHandler, CorsConfigurationSource {
    private final TurmsClusterManager turmsClusterManager;
    private final InboundMessageDispatcher inboundMessageDispatcher;
    private final OnlineUserService onlineUserService;
    private final boolean locationEnabled;

    public TurmsWebSocketHandler(InboundMessageDispatcher inboundMessageDispatcher, OnlineUserService onlineUserService, TurmsClusterManager turmsClusterManager) {
        this.inboundMessageDispatcher = inboundMessageDispatcher;
        this.onlineUserService = onlineUserService;
        this.turmsClusterManager = turmsClusterManager;
        this.locationEnabled = turmsClusterManager.getTurmsProperties().getUser().getLocation().isEnabled();
    }

    @PostConstruct
    public void warmUp() {
        UserAgentUtil.parse("User-Agent,Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.90 Safari/537.36");
    }

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        Map<String, String> cookies = SessionUtil.getCookiesFromSession(session);
        HttpHeaders headers = session.getHandshakeInfo().getHeaders();
        Long userId = SessionUtil.getUserIdFromCookiesOrHeaders(cookies, headers);
        DeviceType deviceType = SessionUtil.getDeviceTypeFromCookies(cookies, headers);
        UserStatus userStatus = SessionUtil.getUserStatusFromCookies(cookies, headers);
        PointFloat userLocation;
        if (locationEnabled) {
            userLocation = SessionUtil.getLocationFromCookies(cookies, headers);
        } else {
            userLocation = null;
        }
        String agent = session.getHandshakeInfo().getHeaders().getFirst("User-Agent");
        Map<String, String> deviceDetails = UserAgentUtil.parse(agent);
        deviceType = UserAgentUtil.detectDeviceTypeIfUnset(
                deviceType,
                deviceDetails,
                turmsClusterManager.getTurmsProperties().getUser().isShouldUseOsAsDefaultDeviceType());
        InetSocketAddress ip = session.getHandshakeInfo().getRemoteAddress();
        if (userId != null && ip != null) {
            Integer ipInNumber;
            try {
                ipInNumber = InetAddresses.coerceToInteger(InetAddresses.forString(ip.getHostString()));
                SessionUtil.putIp(session.getAttributes(), ipInNumber);
            } catch (Exception e) {
                ipInNumber = null;
            }
            SessionUtil.putOnlineUserInfoToSession(session, userId, userStatus, deviceType, userLocation);
            Integer finalIpInNumber = ipInNumber;
            DeviceType finalDeviceType = deviceType;
            Flux<WebSocketMessage> notificationOutput = Flux.create(notificationSink ->
                    onlineUserService.addOnlineUser(
                            userId,
                            userStatus,
                            finalDeviceType,
                            deviceDetails,
                            finalIpInNumber,
                            userLocation,
                            session,
                            notificationSink)
                            .doOnError(throwable -> {
                                notificationSink.error(throwable);
                                onlineUserService.setLocalUserDevicesOffline(
                                        userId,
                                        Collections.singleton(finalDeviceType),
                                        CloseStatusFactory.get(TurmsCloseStatus.SERVER_ERROR, throwable.getMessage()));
                            })
                            .doOnSuccess(code -> {
                                if (code != TurmsStatusCode.OK) {
                                    onlineUserService.setLocalUserDevicesOffline(
                                            userId,
                                            Collections.singleton(finalDeviceType),
                                            CloseStatusFactory.get(TurmsCloseStatus.SERVER_ERROR, String.valueOf(code.getBusinessCode())));
                                } else if (turmsClusterManager.getTurmsProperties().getSession()
                                        .isShouldNotifyClientsOfSessionInfoAfterConnected()) {
                                    String address = turmsClusterManager.getLocalTurmsServerAddress();
                                    WebSocketMessage message = generateSessionNotification(session, address);
                                    notificationSink.next(message);
                                }
                            })
                            .subscribe());
            Flux<WebSocketMessage> responseOutput = session.receive();
            int requestInterval = turmsClusterManager.getTurmsProperties().getSecurity().getMinClientRequestsIntervalMillis();
            if (requestInterval != 0) {
                responseOutput = responseOutput
                        .doOnNext(WebSocketMessage::retain)
                        .sample(Duration.ofMillis(requestInterval));
            }
            responseOutput = responseOutput
                    .doFinally(signalType -> {
                        TurmsCloseStatus status = signalType == SignalType.ON_COMPLETE ?
                                TurmsCloseStatus.DISCONNECTED_BY_CLIENT :
                                TurmsCloseStatus.UNKNOWN_ERROR;
                        onlineUserService.setLocalUserDeviceOffline(userId, finalDeviceType, CloseStatusFactory.get(status));
                    })
                    .flatMap(inboundMessage -> inboundMessageDispatcher.dispatch(session, inboundMessage));
            return session.send(notificationOutput.mergeWith(responseOutput));
        } else {
            return session.close(CloseStatusFactory.get(TurmsCloseStatus.SERVER_ERROR, "The user ID or IP is missing"));
        }
    }

    //TODO: check whether this is necessary while there has been a WebConfig
    @Override
    public CorsConfiguration getCorsConfiguration(ServerWebExchange exchange) {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.setAllowCredentials(true);
        return corsConfiguration;
    }

    private WebSocketMessage generateSessionNotification(
            @NotNull WebSocketSession session,
            @NotNull String serverAddress) {
        return session.binaryMessage(factory -> {
            Session result = Session.newBuilder()
                    .setSessionId(session.getId())
                    .setAddress(serverAddress)
                    .build();
            TurmsNotification response = TurmsNotification.newBuilder()
                    .setData(TurmsNotification.Data.newBuilder().setSession(result))
                    .buildPartial();
            return factory.wrap(response.toByteArray());
        });
    }
}
