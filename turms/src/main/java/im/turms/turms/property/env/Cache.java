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

package im.turms.turms.property.env;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.IdentifiedDataSerializable;
import im.turms.common.constant.DeviceType;
import im.turms.turms.config.hazelcast.IdentifiedDataFactory;
import jdk.jfr.Description;
import lombok.Data;

import java.io.IOException;
import java.util.Set;

@Data
public class Cache implements IdentifiedDataSerializable {

    @Description("The maximum size of the cache for the disconnection reasons")
    private int disconnectionReasonCacheMaxSize = 1024;

    @Description("The maximum size of the cache for the login-failed reasons")
    private int loginFailedReasonCacheMaxSize = 1024;

    @Description("The life duration of each disconnection reason")
    private int disconnectionReasonExpireAfter = 60;

    @Description("The life duration of each login-failed reason")
    private int loginFailedReasonExpireAfter = 60;

    @JsonIgnore
    @Override
    public int getFactoryId() {
        return IdentifiedDataFactory.FACTORY_ID;
    }

    @JsonIgnore
    @Override
    public int getClassId() {
        return IdentifiedDataFactory.Type.PROPERTY_CACHE.getValue();
    }

    @Override
    public void writeData(ObjectDataOutput out) throws IOException {
    }

    @Override
    public void readData(ObjectDataInput in) throws IOException {
    }
}