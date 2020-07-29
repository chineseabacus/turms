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

package im.turms.gateway.plugin.extension;

import im.turms.common.model.dto.notification.TurmsNotification;
import im.turms.server.common.plugin.base.TurmsExtension;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * @author James Chen
 */
public abstract class TurmsNotificationHandler extends TurmsExtension {

    public abstract void handle(@NotNull TurmsNotification notification, @NotEmpty Set<Long> recipientIds, @NotNull Set<Long> offlineRecipientIds);

}