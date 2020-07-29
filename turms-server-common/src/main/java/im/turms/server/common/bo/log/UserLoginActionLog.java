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

package im.turms.server.common.bo.log;

import im.turms.common.constant.DeviceType;
import im.turms.common.constant.UserStatus;
import lombok.Data;
import org.springframework.data.geo.Point;

import java.util.Date;
import java.util.Map;

/**
 * @author James Chen
 */
@Data
public final class UserLoginActionLog {

    private final long id;

    private final Long userId;

    private final Date loginDate;

    private final Point location;

    private final String ip;

    private final UserStatus userStatus;

    private final DeviceType deviceType;

    private final Map<String, String> deviceDetails;

    @Override
    public String toString() {
        return "UserLoginActionLog{" +
                "id=" + id +
                ", userId=" + userId +
                ", loginDate=" + loginDate +
                ", location=" + location +
                ", ip='" + ip + '\'' +
                ", userStatus=" + userStatus +
                ", deviceType=" + deviceType +
                ", deviceDetails=" + deviceDetails +
                '}';
    }

}