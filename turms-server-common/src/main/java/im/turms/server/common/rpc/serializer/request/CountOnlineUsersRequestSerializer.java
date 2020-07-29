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

package im.turms.server.common.rpc.serializer.request;

import im.turms.server.common.cluster.service.serialization.serializer.Serializer;
import im.turms.server.common.cluster.service.serialization.serializer.SerializerId;
import im.turms.server.common.rpc.request.CountOnlineUsersRequest;
import io.netty.buffer.ByteBuf;

/**
 * @author James Chen
 */
public class CountOnlineUsersRequestSerializer implements Serializer<CountOnlineUsersRequest> {

    @Override
    public void write(ByteBuf output, CountOnlineUsersRequest data) {
    }

    @Override
    public CountOnlineUsersRequest read(ByteBuf input) {
        return new CountOnlineUsersRequest();
    }

    @Override
    public int initialCapacity(CountOnlineUsersRequest data) {
        return 0;
    }

    @Override
    public SerializerId getSerializerId() {
        return SerializerId.RPC_COUNT_ONLINE_USERS;
    }

}
