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

package im.turms.server.common.context;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Hooks;

import java.io.IOException;
import java.util.List;

/**
 * @author James Chen
 */
@Component
@Getter
@Log4j2
public class ApplicationContext {

    private final boolean isProduction;
    private final String activeProfile;

    public ApplicationContext(Environment environment) {
        // Prefer isProduction to be true to avoid getting trouble in production environment
        List<String> nonProdEnvs = List.of(
                "dev", "qa", "stg", "uat",
                "development", "quality", "staging",
                "demo", "test", "local");
        String activeProfile = null;
        boolean isProduction = true;
        for (String profile : environment.getActiveProfiles()) {
            if (!profile.endsWith("-latest")) {
                activeProfile = profile;
            }
            if (isProduction) {
                for (String nonProdEnv : nonProdEnvs) {
                    if (profile.equalsIgnoreCase(nonProdEnv)) {
                        isProduction = false;
                        break;
                    }
                }
            }
        }
        this.activeProfile = activeProfile;
        this.isProduction = isProduction;

        setupErrorHandlerContext();
    }

    private void setupErrorHandlerContext() {
        Hooks.onErrorDropped(throwable -> {
            // throwable is always the instance of ErrorCallbackNotImplemented
            Throwable cause = throwable.getCause();
            if (isReadFromForciblyClosedConnectionException(cause)) {
                // Ignore the exception in production env because it should not have side effects
                // and we cannot avoid the exception completely because of its root cause.
                // Log the exception only in non-production env so we can try to optimize the code of
                // client to close the connection with a 4-way handshake on the client sides
                if (!this.isProduction) {
                    log.warn(throwable);
                }
            } else {
                log.error("Unhandled exception", throwable);
            }
        });
    }

    /**
     * The exception occurs when a socket tries to read from a closed connection without a 4-way handshake
     */
    private boolean isReadFromForciblyClosedConnectionException(Throwable throwable) {
        if (throwable instanceof IOException) {
            StackTraceElement[] stackTrace = throwable.getStackTrace();
            if (stackTrace.length > 0) {
                StackTraceElement traceElement = stackTrace[0];
                return traceElement.getClassName().endsWith("SocketDispatcher") && traceElement.getMethodName().startsWith("read");
            }
        }
        return false;
    }

}