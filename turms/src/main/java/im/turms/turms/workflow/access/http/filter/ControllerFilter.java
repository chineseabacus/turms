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

package im.turms.turms.workflow.access.http.filter;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import im.turms.server.common.cluster.node.Node;
import im.turms.turms.plugin.manager.TurmsPluginManager;
import im.turms.turms.workflow.access.http.permission.AdminPermission;
import im.turms.turms.workflow.access.http.permission.RequiredPermission;
import im.turms.turms.workflow.service.impl.admin.AdminService;
import im.turms.turms.workflow.service.impl.log.AdminActionLogService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.cors.reactive.CorsUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.reactive.result.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Parameter;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author James Chen
 */
@Component
public class ControllerFilter implements WebFilter {

    private static final BasicDBObject EMPTY_DBOJBECT = new BasicDBObject();
    private static final String HEADER_ACCOUNT = "account";
    private static final String HEADER_PASSWORD = "password";
    private static final String ATTR_BODY = "BODY";
    private static final List<String> DELETE_FILTER_PARAM_NAME = List.of("ids", "keys", "accounts");

    private final Node node;
    private final RequestMappingHandlerMapping requestMappingHandlerMapping;
    private final AdminService adminService;
    private final AdminActionLogService adminActionLogService;
    private final TurmsPluginManager turmsPluginManager;
    private final boolean pluginEnabled;
    private final boolean enableAdminApi;
    @Value("${springfox.documentation.enabled}")
    private boolean isOpenApiEnabled = false;

    public ControllerFilter(
            Node node,
            RequestMappingHandlerMapping requestMappingHandlerMapping,
            AdminService adminService,
            AdminActionLogService adminActionLogService,
            TurmsPluginManager turmsPluginManager) {
        this.requestMappingHandlerMapping = requestMappingHandlerMapping;
        this.adminService = adminService;
        this.adminActionLogService = adminActionLogService;
        this.node = node;
        this.turmsPluginManager = turmsPluginManager;
        pluginEnabled = node.getSharedProperties().getPlugin().isEnabled();
        enableAdminApi = node.getSharedProperties().getService().getAdminApi().isEnabled();
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        return requestMappingHandlerMapping.getHandler(exchange)
                .share()
                .flatMap(handlerMethodObject -> {
                    if (isOpenApiEnabledAndOpenApiRequest(exchange)) {
                        return chain.filter(exchange);
                    }
                    if (handlerMethodObject instanceof HandlerMethod) {
                        HandlerMethod handlerMethod = (HandlerMethod) handlerMethodObject;
                        return filterHandlerMethod(handlerMethod, exchange, chain);
                    } else {
                        return filterUnhandledRequest(exchange, chain);
                    }
                });
    }

    private Mono<Void> filterHandlerMethod(HandlerMethod handlerMethod, ServerWebExchange exchange, WebFilterChain chain) {
        RequiredPermission requiredPermission = handlerMethod.getMethodAnnotation(RequiredPermission.class);
        if (requiredPermission != null && requiredPermission.value().equals(AdminPermission.NONE)) {
            return chain.filter(exchange);
        }
        if (!enableAdminApi) {
            exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
            return Mono.empty();
        }
        if (!node.getSharedProperties().getService().getAdminApi().isAllowDeletingWithoutFilter()) {
            DeleteMapping deleteMapping = handlerMethod.getMethodAnnotation(DeleteMapping.class);
            if (deleteMapping != null && !isValidDeleteRequest(handlerMethod, exchange, deleteMapping)) {
                exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
                return Mono.empty();
            }
        }
        String account = parseAccount(exchange);
        String password = parsePassword(exchange);
        if (account != null && password != null) {
            return adminService.authenticate(account, password)
                    .flatMap(authenticated -> {
                        if (authenticated == null || !authenticated) {
                            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                            return Mono.empty();
                        }
                        if (requiredPermission != null) {
                            return adminService.isAdminAuthorized(exchange, account, requiredPermission.value())
                                    .flatMap(authorized -> {
                                        if (authorized != null && authorized) {
                                            return tryPersistAndPass(account, exchange, chain, handlerMethod);
                                        } else {
                                            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                                            return Mono.empty();
                                        }
                                    });
                        } else {
                            return tryPersistAndPass(account, exchange, chain, handlerMethod);
                        }
                    });
        } else {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return Mono.empty();
        }
    }

    private Mono<Void> filterUnhandledRequest(ServerWebExchange exchange, WebFilterChain chain) {
        if (CorsUtils.isPreFlightRequest(exchange.getRequest())) {
            return chain.filter(exchange);
        }
        if (!enableAdminApi) {
            exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
            return Mono.empty();
        }
        String account = parseAccount(exchange);
        String password = parsePassword(exchange);
        if (account == null || password == null) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return Mono.empty();
        }
        return adminService.authenticate(account, password)
                .flatMap(authenticated -> {
                    if (authenticated) {
                        return chain.filter(exchange);
                    } else {
                        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                        return Mono.empty();
                    }
                });
    }

    private String parseAccount(@NotNull ServerWebExchange exchange) {
        ServerHttpRequest request = exchange.getRequest();
        return request.getHeaders().getFirst(HEADER_ACCOUNT);
    }

    private String parsePassword(@NotNull ServerWebExchange exchange) {
        ServerHttpRequest request = exchange.getRequest();
        return request.getHeaders().getFirst(HEADER_PASSWORD);
    }

    private Mono<Void> tryPersistAndPass(
            @NotNull String account,
            @NotNull ServerWebExchange exchange,
            @NotNull WebFilterChain chain,
            @NotNull HandlerMethod handlerMethod) {
        boolean logAdminAction = node.getSharedProperties().getService().getLog().isLogAdminAction();
        boolean triggerHandlers = pluginEnabled && !turmsPluginManager.getAdminActionHandlerList().isEmpty();
        Mono<Void> additionalMono;
        if (logAdminAction || triggerHandlers) {
            ServerHttpRequest request = exchange.getRequest();
            String action = handlerMethod.getMethod().getName();
            String host = Objects.requireNonNull(request.getRemoteAddress()).getHostString();
            DBObject params = null;
            Mono<BasicDBObject> bodyMono;
            if (node.getSharedProperties().getService().getLog().isLogAdminRequestParams()) {
                params = parseValidParams(request, handlerMethod);
            }
            if (node.getSharedProperties().getService().getLog().isLogAdminRequestBody()) {
                bodyMono = parseValidBody(exchange);
                exchange = replaceRequestBody(exchange);
            } else {
                bodyMono = Mono.empty();
            }
            DBObject finalParams = params;
            additionalMono = bodyMono.defaultIfEmpty(EMPTY_DBOJBECT).doOnNext(dbObject -> {
                DBObject body = dbObject != EMPTY_DBOJBECT ? dbObject : null;
                adminActionLogService.tryLogAndTriggerHandlers(
                        account,
                        new Date(),
                        host,
                        action,
                        finalParams,
                        body);
            }).then();
        } else {
            additionalMono = Mono.empty();
        }
        ServerWebExchange finalExchange = exchange;
        return additionalMono.then(chain.filter(exchange))
                .doFinally(signalType -> finalExchange.getAttributes().remove(ATTR_BODY));
    }

    private DBObject parseValidParams(ServerHttpRequest request, HandlerMethod handlerMethod) {
        MethodParameter[] methodParameters = handlerMethod.getMethodParameters();
        MultiValueMap<String, String> queryParams = request.getQueryParams();
        BasicDBObject params = null;
        if (methodParameters.length > 0 && !queryParams.isEmpty()) {
            params = new BasicDBObject(queryParams.size());
            for (MethodParameter methodParameter : methodParameters) {
                String parameterName = methodParameter.getParameterName();
                if (parameterName != null) {
                    String value = queryParams.getFirst(parameterName);
                    if (value != null) {
                        params.put(parameterName, value);
                    }
                }
            }
            if (params.isEmpty()) {
                params = EMPTY_DBOJBECT;
            }
        }
        return params;
    }

    private Mono<BasicDBObject> parseValidBody(@NotNull ServerWebExchange exchange) {
        return DataBufferUtils.join(exchange.getRequest().getBody())
                .map(dataBuffer -> {
                    exchange.getAttributes().put(ATTR_BODY, dataBuffer);
                    String json = dataBuffer.toString(StandardCharsets.UTF_8);
                    BasicDBObject dbObject = BasicDBObject.parse(json);
                    return dbObject.isEmpty() ? EMPTY_DBOJBECT : dbObject;
                });
    }

    /**
     * Build a new request with a new body to pass down to RequestBodyMethodArgumentResolver.resolveArgument
     */
    private ServerWebExchange replaceRequestBody(ServerWebExchange exchange) {
        ServerHttpRequest mutatedRequest = new ServerHttpRequestDecorator(exchange.getRequest()) {
            @Override
            public Flux<DataBuffer> getBody() {
                DataBuffer dataBuffer = exchange.getAttribute(ATTR_BODY);
                if (dataBuffer != null) {
                    return Flux.just(dataBuffer);
                } else {
                    return getDelegate().getBody();
                }
            }
        };
        return exchange.mutate().request(mutatedRequest).build();
    }

    private boolean isValidDeleteRequest(HandlerMethod handlerMethod, ServerWebExchange exchange, DeleteMapping deleteMapping) {
        String methodFilterName = null;
        for (Parameter parameter : handlerMethod.getMethod().getParameters()) {
            String name = parameter.getName();
            if (DELETE_FILTER_PARAM_NAME.contains(name)) {
                methodFilterName = name;
            }
        }
        if (methodFilterName == null) {
            return true;
        } else {
            MultiValueMap<String, String> queryParams = exchange.getRequest().getQueryParams();
            String filterValue = queryParams.getFirst(methodFilterName);
            return filterValue != null && !filterValue.isBlank();
        }
    }

    private boolean isOpenApiEnabledAndOpenApiRequest(@NotNull ServerWebExchange exchange) {
        if (isOpenApiEnabled) {
            String path = exchange.getRequest().getURI().getPath();
            return path.startsWith("/v3/api-docs")
                    || path.startsWith("/swagger-resources")
                    || path.startsWith("/swagger-ui");
        } else {
            return false;
        }
    }

}
