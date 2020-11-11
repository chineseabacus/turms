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

package im.turms.server.common.property.env.gateway;


import im.turms.server.common.property.metadata.annotation.Description;
import lombok.Data;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.boot.web.server.Ssl;

/**
 * @author James Chen
 */
@Data
public class TcpProperties {

    /**
     * We disable TCP currently until clients support TCP
     */
    private boolean enabled = false;
    private String host = "0.0.0.0";
    private int port = 11510;

    @Description("A TCP connection will be closed on the server side if a client hasn't established a user session in a specified time. " +
            "Note that the developers on the client side should take the responsibility to close the TCP connection according to their business requirements")
    private int closeIdleConnectionAfterSeconds = 60 * 5;

    @NestedConfigurationProperty
    Ssl ssl = new Ssl();

}