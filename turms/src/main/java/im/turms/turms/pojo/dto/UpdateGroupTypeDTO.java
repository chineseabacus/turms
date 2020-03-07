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

package im.turms.turms.pojo.dto;

import im.turms.common.constant.GroupInvitationStrategy;
import im.turms.common.constant.GroupJoinStrategy;
import im.turms.common.constant.GroupUpdateStrategy;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class UpdateGroupTypeDTO {
    private final String name;

    private final Integer groupSizeLimit;

    private final GroupInvitationStrategy invitationStrategy;

    private final GroupJoinStrategy joinStrategy;

    private final GroupUpdateStrategy groupInfoUpdateStrategy;

    private final GroupUpdateStrategy memberInfoUpdateStrategy;

    private final Boolean guestSpeakable;

    private final Boolean selfInfoUpdatable;

    private final Boolean enableReadReceipt;

    private final Boolean messageEditable;
}
