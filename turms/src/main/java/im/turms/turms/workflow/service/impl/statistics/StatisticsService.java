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

package im.turms.turms.workflow.service.impl.statistics;

import im.turms.server.common.cluster.exception.RpcException;
import im.turms.server.common.cluster.node.Node;
import im.turms.server.common.cluster.service.rpc.RpcErrorCode;
import im.turms.server.common.manager.TrivialTaskManager;
import im.turms.server.common.property.TurmsPropertiesManager;
import im.turms.server.common.rpc.request.CountOnlineUsersRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.math.MathFlux;

import java.util.Collections;
import java.util.Map;

/**
 * @author James Chen
 */

@Service
@Log4j2
public class StatisticsService {

    private final Node node;

    private static final String ONLINE_USERS_NUMBER_LOGGING_FORMAT = "The current online users number is: {}";

    public StatisticsService(
            Node node,
            TurmsPropertiesManager turmsPropertiesManager,
            TrivialTaskManager taskManager) {
        this.node = node;
        taskManager.reschedule(
                "onlineUsersNumberLogging",
                turmsPropertiesManager.getLocalProperties().getService().getActivityLogging().getStatistics().getOnlineUsersNumberLoggingCron(),
                () -> {
                    if (node.isLocalNodeMaster() && node.getSharedProperties().getService().getActivityLogging().getStatistics().isLogOnlineUsersNumber()) {
                        countOnlineUsers()
                                .doOnNext(integer -> log.info(ONLINE_USERS_NUMBER_LOGGING_FORMAT, integer))
                                .subscribe();
                    }
                });
    }

    /**
     * @implNote Note that the count requests are sent by turms but all responses should come from turms-gateway
     * so that we don't need to count the local online users like ".map(count -> count + countLocalOnlineUsers())"
     */
    public Mono<Map<String, Integer>> countOnlineUsersByNodes() {
        CountOnlineUsersRequest request = new CountOnlineUsersRequest();
        return node.getRpcService().requestResponsesAsMapFromOtherGateways(request, false)
                .onErrorResume(throwable -> RpcException.isErrorCode(throwable, RpcErrorCode.SERVICE_NOT_FOUND),
                        throwable -> Mono.just(Collections.emptyMap()));
    }

    public Mono<Integer> countOnlineUsers() {
        CountOnlineUsersRequest request = new CountOnlineUsersRequest();
        Flux<Integer> responses = node.getRpcService().requestResponsesFromOtherGateways(request, true)
                .onErrorResume(throwable -> RpcException.isErrorCode(throwable, RpcErrorCode.SERVICE_NOT_FOUND),
                        throwable -> Mono.just(0));
        return MathFlux.sumInt(responses);
    }

}