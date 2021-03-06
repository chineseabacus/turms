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

package im.turms.server.common.property.env.service.business.activity;

import lombok.Data;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * @author James Chen
 * @implNote To make it clearer for developers to configure the logging behaviors of client requests and the responses
 * we put the properties together in ClientApiProperties instead of ActivityLoggingProperties
 */
@Data
public class ActivityLoggingProperties {

    @NestedConfigurationProperty
    private StatisticsProperties statistics = new StatisticsProperties();

}