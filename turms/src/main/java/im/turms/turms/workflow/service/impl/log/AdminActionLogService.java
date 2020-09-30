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

package im.turms.turms.workflow.service.impl.log;

import com.mongodb.DBObject;
import im.turms.server.common.cluster.node.Node;
import im.turms.server.common.constraint.NoWhitespace;
import im.turms.server.common.constraint.ValidIpAddress;
import im.turms.turms.bo.AdminActionLog;
import im.turms.turms.plugin.extension.handler.AdminActionLogHandler;
import im.turms.turms.plugin.manager.TurmsPluginManager;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

/**
 * @author James Chen
 */
@Service
@Log4j2
public class AdminActionLogService {

    private final Node node;
    private final TurmsPluginManager turmsPluginManager;

    public AdminActionLogService(
            Node node,
            TurmsPluginManager turmsPluginManager) {
        this.node = node;
        this.turmsPluginManager = turmsPluginManager;
    }

    public void tryLogAndTriggerHandlers(
            @NotNull @NoWhitespace String account,
            @NotNull @PastOrPresent Date timestamp,
            @NotNull @ValidIpAddress String ip,
            @NotNull @NoWhitespace String action,
            @Nullable DBObject params,
            @Nullable DBObject body) {
        boolean logAdminAction = node.getSharedProperties().getService().getLog().isLogAdminAction();
        boolean triggerHandlers = turmsPluginManager.isEnabled() && !turmsPluginManager.getAdminActionHandlerList().isEmpty();
        if (logAdminAction || triggerHandlers) {
            AdminActionLog adminActionLog = new AdminActionLog(
                    account,
                    timestamp,
                    ip,
                    action,
                    params,
                    body);
            if (logAdminAction) {
                log.info(adminActionLog);
            }
            if (triggerHandlers) {
                for (AdminActionLogHandler handler : turmsPluginManager.getAdminActionHandlerList()) {
                    handler.handleAdminActionLog(adminActionLog);
                }
            }
        }
    }

}
