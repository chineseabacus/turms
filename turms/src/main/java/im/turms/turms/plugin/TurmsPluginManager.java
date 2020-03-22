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

package im.turms.turms.plugin;

import im.turms.turms.property.TurmsProperties;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.pf4j.DefaultPluginManager;
import org.pf4j.PluginManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

@Component
@Data
@DependsOn("turmsProperties")
@Log4j2
public class TurmsPluginManager {
    private final ApplicationContext context;
    private final TurmsProperties turmsProperties;
    private PluginManager pluginManager;

    private List<ClientRequestHandler> clientRequestHandlerList;
    private List<ExpiredMessageAutoDeletionNotificationHandler> expiredMessageAutoDeletionNotificationHandlerList;
    private List<LogHandler> logHandlerList;
    private List<UserAuthenticator> userAuthenticatorList;
    private List<UserOnlineStatusChangeHandler> userOnlineStatusChangeHandlerList;
    private StorageServiceProvider storageServiceProvider;

    public TurmsPluginManager(ApplicationContext context, TurmsProperties turmsProperties) {
        this.context = context;
        this.turmsProperties = turmsProperties;
        if (turmsProperties.getPlugin().isEnabled()) {
            clientRequestHandlerList = Collections.emptyList();
            expiredMessageAutoDeletionNotificationHandlerList = Collections.emptyList();
            logHandlerList = Collections.emptyList();
            userAuthenticatorList = Collections.emptyList();
            userOnlineStatusChangeHandlerList = Collections.emptyList();
            init();
        }
    }

    public void init() {
        Path dir = Path.of(turmsProperties.getPlugin().getDir());
        pluginManager = new DefaultPluginManager(dir);
        pluginManager.loadPlugins();
        pluginManager.startPlugins();

        clientRequestHandlerList = pluginManager.getExtensions(ClientRequestHandler.class);
        expiredMessageAutoDeletionNotificationHandlerList = pluginManager.getExtensions(ExpiredMessageAutoDeletionNotificationHandler.class);
        logHandlerList = pluginManager.getExtensions(LogHandler.class);
        userAuthenticatorList = pluginManager.getExtensions(UserAuthenticator.class);
        userOnlineStatusChangeHandlerList = pluginManager.getExtensions(UserOnlineStatusChangeHandler.class);
        List<StorageServiceProvider> storageServiceProviders = pluginManager.getExtensions(StorageServiceProvider.class);
        if (!storageServiceProviders.isEmpty()) {
            this.storageServiceProvider = storageServiceProviders.get(0);
        }
        initExtensions(clientRequestHandlerList);
        initExtensions(expiredMessageAutoDeletionNotificationHandlerList);
        initExtensions(logHandlerList);
        initExtensions(userAuthenticatorList);
        initExtensions(userOnlineStatusChangeHandlerList);
        initExtension(storageServiceProvider);
    }

    @PreDestroy
    public void destroy() {
        pluginManager.stopPlugins();
    }

    private void initExtension(TurmsExtension extension) {
        try {
            extension.setContext(context);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    private void initExtensions(List<? extends TurmsExtension> extensions) {
        for (TurmsExtension extension : extensions) {
            initExtension(extension);
        }
    }
}