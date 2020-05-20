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

package im.turms.turms.pojo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Sharded;
import org.springframework.data.mongodb.core.mapping.ShardingStrategy;

import java.util.Date;

/**
 * Use the hash-based sharding because the userId increases monotonically.
 */
@Data
@AllArgsConstructor
@Sharded(shardingStrategy = ShardingStrategy.HASH, immutableKey = true)
public final class UserVersion {
    @Id
    private final Long userId;

    @Field(Fields.SENT_FRIEND_REQUESTS)
    private final Date sentFriendRequests;

    @Field(Fields.RECEIVED_FRIEND_REQUESTS)
    private final Date receivedFriendRequests;

    @Field(Fields.RELATIONSHIPS)
    private final Date relationships;

    @Field(Fields.RELATIONSHIP_GROUPS)
    private final Date relationshipGroups;

    @Field(Fields.RELATIONSHIP_GROUPS_MEMBERS)
    private final Date relationshipGroupsMembers;

    @Field(Fields.GROUP_JOIN_REQUESTS)
    private final Date groupJoinRequests; // sent group join requests

    @Field(Fields.SENT_GROUP_INVITATIONS)
    private final Date sentGroupInvitations;

    @Field(Fields.RECEIVED_GROUP_INVITATIONS)
    private final Date receivedGroupInvitations;

    @Field(Fields.JOINED_GROUPS)
    private final Date joinedGroups;

    public static class Fields {
        public static final String SENT_FRIEND_REQUESTS = "sfr";
        public static final String RECEIVED_FRIEND_REQUESTS = "rfr";

        public static final String RELATIONSHIPS = "r";
        public static final String RELATIONSHIP_GROUPS = "rg";
        public static final String RELATIONSHIP_GROUPS_MEMBERS = "rgm";

        public static final String GROUP_JOIN_REQUESTS = "gjr";

        public static final String SENT_GROUP_INVITATIONS = "sgi";
        public static final String RECEIVED_GROUP_INVITATIONS = "rgi";

        public static final String JOINED_GROUPS = "jg";

        private Fields() {
        }
    }
}
