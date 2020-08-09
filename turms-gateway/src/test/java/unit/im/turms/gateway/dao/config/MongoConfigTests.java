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

package unit.im.turms.gateway.dao.config;

import im.turms.gateway.dao.config.MongoConfig;
import im.turms.server.common.property.TurmsProperties;
import im.turms.server.common.property.TurmsPropertiesManager;
import im.turms.server.common.property.env.gateway.DatabaseProperties;
import im.turms.server.common.property.env.gateway.GatewayProperties;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author James Chen
 */
class MongoConfigTests {

    @Test
    void userMongoTemplate_shouldReturnNotNullInstance() {
        MongoConfig mongoConfig = new MongoConfig();
        TurmsProperties turmsProperties = new TurmsProperties();
        GatewayProperties gateway = new GatewayProperties();
        DatabaseProperties database = new DatabaseProperties();
        DatabaseProperties.Properties mongoProperties = new DatabaseProperties.Properties();
        mongoProperties.setUser(new MongoProperties());
        database.setMongoProperties(mongoProperties);
        gateway.setDatabase(database);
        turmsProperties.setGateway(gateway);
        TurmsPropertiesManager propertiesManager = mock(TurmsPropertiesManager.class);
        when(propertiesManager.getLocalProperties())
                .thenReturn(turmsProperties);
        ReactiveMongoTemplate template = mongoConfig.userMongoTemplate(propertiesManager);

        assertNotNull(template);
    }

}
