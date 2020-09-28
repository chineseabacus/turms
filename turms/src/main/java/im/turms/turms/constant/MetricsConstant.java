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

package im.turms.turms.constant;

/**
 * @author James Chen
 */
public class MetricsConstant {

    private MetricsConstant() {
    }

    // Client requests

    public static final String CLIENT_REQUEST_NAME = "client.request";
    public static final String CLIENT_REQUEST_TAG_TYPE = "type";

    // User

    public static final String REGISTERED_USERS_COUNTER_NAME = "user.registered";
    public static final String DELETED_USERS_COUNTER_NAME = "user.deleted";

    // Group

    public static final String CREATED_GROUPS_COUNTER_NAME = "group.created";
    public static final String DELETED_GROUPS_COUNTER_NAME = "group.deleted";

    // Message

    public static final String ACKNOWLEDGED_MESSAGES_COUNTER_NAME = "msg.acknowledged";
    public static final String SENT_MESSAGES_COUNTER_NAME = "msg.sent";

}
