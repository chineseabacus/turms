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

import im.turms.turms.common.TurmsPasswordUtil;
import im.turms.turms.constant.ProfileAccessStrategy;
import im.turms.turms.pojo.domain.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.socket.HandshakeInfo;
import org.springframework.web.reactive.socket.WebSocketSession;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;

import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Date;

import static helper.util.LoginUtil.getLoginParams;
import static helper.util.LoginUtil.getServerUrl;
import static im.turms.turms.common.Constants.DEFAULT_USER_PERMISSION_GROUP_ID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TurmsHandshakeWebSocketServiceIT {

    @LocalServerPort
    Integer port;

    @BeforeAll
    public static void initUser(@Autowired MongoTemplate mongoTemplate, @Autowired TurmsPasswordUtil passwordUtil) {
        Date now = new Date();
        User user = new User(1L, passwordUtil.encodeUserPassword("123"), "", "",
                "", ProfileAccessStrategy.ALL, DEFAULT_USER_PERMISSION_GROUP_ID, now, null, true, now);
        mongoTemplate.save(user);
    }

    @AfterAll
    public static void tearDown(@Autowired MongoTemplate mongoTemplate) {
        mongoTemplate.remove(new Query(), User.class);
    }

    @Test
    public void handleRequest_shouldLogin_withCorrectCredential() throws URISyntaxException {
        ReactorNettyWebSocketClient client = new ReactorNettyWebSocketClient();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.COOKIE, getLoginParams(1L, "123"));
        final HandshakeInfo[] handshakeInfo = new HandshakeInfo[1];
        client.execute(getServerUrl(port),
                headers,
                session -> {
                    handshakeInfo[0] = session.getHandshakeInfo();
                    return session.close();
                })
                .block(Duration.ofSeconds(5));
        assertEquals(handshakeInfo[0].getHeaders().getFirst("upgrade"),
                "websocket");
    }

    @Test
    public void handleRequest_shouldNotLogin_withIncorrectCredential() {
        ReactorNettyWebSocketClient client = new ReactorNettyWebSocketClient();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.COOKIE, getLoginParams(1L, "123456"));
        Exception exception = null;
        try {
            client.execute(getServerUrl(port),
                    headers,
                    WebSocketSession::close)
                    .block(Duration.ofSeconds(5));
        } catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
    }
}
