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

package im.turms.server.common.rpc.request;

import im.turms.server.common.cluster.service.rpc.RpcCallable;
import im.turms.server.common.rpc.service.IOutboundMessageService;
import io.netty.buffer.ByteBuf;
import lombok.Data;
import org.springframework.context.ApplicationContext;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * @author James Chen
 */
@Data
public class SendNotificationRequest extends RpcCallable<Boolean> {

    private static IOutboundMessageService outboundMessageService;

    private final ByteBuf notificationBuffer;
    private final Set<Long> recipientIds;

    /**
     * @param notificationBuffer should be a direct byte buffer of TurmsNotification
     */
    public SendNotificationRequest(@NotNull ByteBuf notificationBuffer, @NotEmpty Set<Long> recipientIds) {
        this.notificationBuffer = notificationBuffer;
        this.recipientIds = recipientIds;
    }

    @Override
    public boolean isAsync() {
        return false;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        super.setApplicationContext(applicationContext);
        if (outboundMessageService == null) {
            outboundMessageService = getContext().getBean(IOutboundMessageService.class);
        }
    }

    /**
     * @return true if the notification has forwarded to one recipient at least
     */
    @Override
    public Boolean call() {
        return outboundMessageService.sendNotificationToLocalClients(notificationBuffer, recipientIds);
    }

}
