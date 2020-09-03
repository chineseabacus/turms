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

package unit.im.turms.turms;

import im.turms.turms.TurmsApplication;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * @author James Chen
 */

class TurmsApplicationTests {

    @Test
    void contextLoads() {
        String[] args = {};
        MockedStatic<SpringApplication> application = Mockito.mockStatic(SpringApplication.class);
        application.when(() -> SpringApplication.run(TurmsApplication.class, args)).thenReturn(null);

        assertDoesNotThrow(() -> TurmsApplication.main(args));
    }

}