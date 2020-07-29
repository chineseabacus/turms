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

package im.turms.gateway.manager;

import im.turms.common.constant.DeviceType;
import im.turms.common.constant.UserStatus;
import im.turms.common.constant.statuscode.SessionCloseStatus;
import im.turms.common.model.bo.signal.Session;
import im.turms.common.model.dto.notification.TurmsNotification;
import im.turms.gateway.access.websocket.dto.CloseStatusFactory;
import im.turms.gateway.pojo.bo.session.UserSession;
import im.turms.server.common.constraint.DeviceTypeConstraint;
import im.turms.server.common.util.DeviceTypeUtil;
import im.turms.server.common.util.MapUtil;
import im.turms.server.common.util.ProtoUtil;
import io.netty.buffer.ByteBuf;
import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import lombok.Data;
import org.springframework.data.geo.Point;
import org.springframework.web.reactive.socket.CloseStatus;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Sinks;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author James Chen
 */
@Data
public final class UserSessionsManager {

    private static final HashedWheelTimer HEARTBEAT_TIMER = new HashedWheelTimer();

    private final Long userId;
    private UserStatus userStatus;
    private final Map<DeviceType, UserSession> sessionMap;

    public UserSessionsManager(
            @NotNull Long userId,
            @NotNull UserStatus userStatus,
            @NotNull DeviceType loggingInDeviceType,
            @Nullable Point userLocation,
            @Nullable WebSocketSession webSocketSession,
            int heartbeatTimeoutInSeconds,
            @Nullable Long logId) {
        UserSession session = new UserSession(
                ThreadLocalRandom.current().nextInt(),
                loggingInDeviceType,
                new Date(),
                userLocation,
                webSocketSession,
                Sinks.unicast(),
                null,
                logId,
                System.currentTimeMillis(),
                0);
        if (heartbeatTimeoutInSeconds > 0) {
            Timeout heartbeatTimeout = newHeartbeatTimeout(loggingInDeviceType, session, heartbeatTimeoutInSeconds);
            session.setHeartbeatTimeout(heartbeatTimeout);
        }
        ConcurrentHashMap<DeviceType, UserSession> sessionMap = new ConcurrentHashMap<>(MapUtil.getCapability(DeviceTypeUtil.ALL_DEVICE_TYPES.length));
        sessionMap.putIfAbsent(loggingInDeviceType, session);
        this.userId = userId;
        this.userStatus = userStatus;
        this.sessionMap = sessionMap;
    }

    public void setDeviceOffline(
            @NotNull DeviceType deviceType,
            @NotNull CloseStatus closeStatus) {
        sessionMap.computeIfPresent(deviceType, (key, session) -> {
            session.getNotificationSink().complete();
            Timeout timeout = session.getHeartbeatTimeout();
            if (timeout != null) {
                timeout.cancel();
            }
            session.getWebSocketSession().close(closeStatus).subscribe();
            return null;
        });
    }

    public boolean pushSessionNotification(DeviceType deviceType) {
        UserSession userSession = sessionMap.get(deviceType);
        if (userSession != null) {
            Session session = Session.newBuilder()
                    .setSessionId(Integer.toString(userSession.getId()))
                    .build();
            TurmsNotification notification = TurmsNotification.newBuilder()
                    .setData(TurmsNotification.Data.newBuilder().setSession(session))
                    .build();
            ByteBuf byteBuffer = ProtoUtil.getByteBuffer(notification);
            userSession.getNotificationSink().next(byteBuffer);
            return true;
        } else {
            return false;
        }
    }

    public UserSession getSession(@NotNull DeviceType deviceType) {
        return sessionMap.get(deviceType);
    }

    public int getSessionsNumber() {
        return sessionMap.size();
    }

    public Set<DeviceType> getLoggedInDeviceTypes() {
        return sessionMap != null ? sessionMap.keySet() : Collections.emptySet();
    }

    /**
     * @param session Don't remove this parameter to use "getSession(deviceType)"
     *                because it needs to invoke hashcode to find session every time
     */
    private Timeout newHeartbeatTimeout(@NotNull @DeviceTypeConstraint DeviceType deviceType, @NotNull UserSession session, int heartbeatTimeoutSeconds) {
        return HEARTBEAT_TIMER.newTimeout(timeout -> {
                    long now = System.currentTimeMillis();
                    int elapsedTime = (int) ((now - session.getLastHeartbeatTimestampMillis()) / 1000);
                    if (elapsedTime > heartbeatTimeoutSeconds) {
                        setDeviceOffline(deviceType, CloseStatusFactory.get(SessionCloseStatus.HEARTBEAT_TIMEOUT));
                    }
                },
                Math.max(heartbeatTimeoutSeconds / 3, 1),
                TimeUnit.SECONDS);
    }

}