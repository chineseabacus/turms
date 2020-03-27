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

package im.turms.turms.config.hazelcast;

import com.hazelcast.config.Config;
import com.hazelcast.config.MemberAttributeConfig;
import com.hazelcast.config.XmlConfigBuilder;
import com.hazelcast.config.YamlConfigBuilder;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.spring.context.SpringManagedContext;
import im.turms.turms.annotation.cluster.PostHazelcastInitialized;
import im.turms.turms.cluster.TurmsClusterManager;
import im.turms.turms.common.AddressUtil;
import im.turms.turms.property.TurmsProperties;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.hazelcast.HazelcastProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.file.NoSuchFileException;
import java.util.Map;
import java.util.function.Function;

@Log4j2
@Configuration
public class HazelcastConfig {
    private final Integer port;
    private final ApplicationContext applicationContext;
    private final TurmsClusterManager turmsClusterManager;

    public HazelcastConfig(ApplicationContext applicationContext, TurmsClusterManager turmsClusterManager) throws UnknownHostException {
        this.applicationContext = applicationContext;
        this.turmsClusterManager = turmsClusterManager;
        String portStr = applicationContext.getEnvironment().getProperty("server.port");
        Integer tempPort;
        try {
            tempPort = portStr != null ? Integer.parseInt(portStr) : null;
        } catch (NumberFormatException ignored) {
            tempPort = null;
        }
        if (tempPort == null) {
            throw new UnknownHostException("The local port of the current server cannot be found");
        }
        this.port = tempPort;
    }

    @Bean
    HazelcastInstance hazelcastInstance(HazelcastProperties properties, TurmsProperties turmsProperties) throws IOException {
        Resource configResource = properties.resolveConfigLocation();
        HazelcastInstance instance;
        if (configResource != null) {
            Config config = getConfig(configResource, turmsProperties);
            if (StringUtils.hasText(config.getInstanceName())) {
                instance = Hazelcast.getOrCreateHazelcastInstance(config);
            } else {
                instance = Hazelcast.newHazelcastInstance(config);
            }
        } else {
            throw new NoSuchFileException("The config file for Hazelcast is missing");
        }
        turmsClusterManager.setHazelcastInstance(instance);
        Map<String, Object> beans = applicationContext.getBeansWithAnnotation(PostHazelcastInitialized.class);
        for (Object value : beans.values()) {
            if (value instanceof Function) {
                Function<TurmsClusterManager, Void> function = (Function<TurmsClusterManager, Void>) value;
                function.apply(turmsClusterManager);
            }
        }
        return instance;
    }

    private Config getConfig(Resource configLocation, TurmsProperties turmsProperties) throws IOException {
        URL configUrl = configLocation.getURL();
        Config config = createConfig(configUrl);
        if (ResourceUtils.isFileURL(configUrl)) {
            config.setConfigurationFile(configLocation.getFile());
        } else {
            config.setConfigurationUrl(configUrl);
        }
        Map<String, Object> beans = applicationContext.getBeansWithAnnotation(im.turms.turms.annotation.cluster.HazelcastConfig.class);
        for (Object value : beans.values()) {
            if (value instanceof Function) {
                Function<Config, Void> function = (Function<Config, Void>) value;
                function.apply(config);
            }
        }
        SpringManagedContext springManagedContext = new SpringManagedContext();
        springManagedContext.setApplicationContext(applicationContext);
        config.setManagedContext(springManagedContext);

        MemberAttributeConfig attributeConfig = new MemberAttributeConfig();
        String ip = AddressUtil.queryIp(turmsProperties);
        attributeConfig.setAttribute(TurmsClusterManager.ATTRIBUTE_ADDRESS, String.format("%s:%d", ip, port));
        config.setMemberAttributeConfig(attributeConfig);

        AddressUtil.onAddressChangeListeners.add(addressTuple -> {
            turmsClusterManager.updateAddress(String.format("%s:%d", addressTuple.getIp(), port));
            return null;
        });

        return config;
    }

    private static Config createConfig(URL configUrl) throws IOException {
        String configFileName = configUrl.getPath();
        if (configFileName.endsWith(".yaml") || configFileName.endsWith(".yml")) {
            return new YamlConfigBuilder(configUrl).build();
        }
        return new XmlConfigBuilder(configUrl).build();
    }
}
