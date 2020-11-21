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

package im.turms.server.common.property.constant;

import com.google.common.collect.Sets;
import im.turms.common.model.dto.request.TurmsRequest;
import lombok.Getter;

import java.util.Collections;
import java.util.Set;

import static im.turms.common.model.dto.request.TurmsRequest.KindCase.*;

/**
 * @author James Chen
 */
public enum LoggingRequestCategory {
    ALL(Pool.ALL),
    NONE(Pool.NONE),

    CREATE(Pool.CREATE),
    DELETE(Pool.DELETE),
    UPDATE(Pool.UPDATE),
    QUERY(Pool.QUERY),

    STORAGE(Pool.STORAGE),
    MESSAGE(Pool.MESSAGE),
    USER(Pool.USER),
    USER_RELATIONSHIP(Pool.USER_RELATIONSHIP),
    GROUP(Pool.GROUP),
    GROUP_BLACKLIST(Pool.GROUP_BLACKLIST),
    GROUP_ENROLLMENT(Pool.GROUP_ENROLLMENT),
    GROUP_MEMBER(Pool.GROUP_MEMBER);

    @Getter
    private final Set<TurmsRequest.KindCase> requestTypes;

    LoggingRequestCategory(Set<TurmsRequest.KindCase> requestTypes) {
        this.requestTypes = requestTypes;
    }

    private static class Pool {
        private static final Set<TurmsRequest.KindCase> ALL;
        private static final Set<TurmsRequest.KindCase> NONE = Collections.emptySet();

        private static final Set<TurmsRequest.KindCase> CREATE = Set.of(
                CREATE_SESSION_REQUEST,
                CREATE_MESSAGE_REQUEST,
                CREATE_FRIEND_REQUEST_REQUEST,
                CREATE_RELATIONSHIP_GROUP_REQUEST,
                CREATE_RELATIONSHIP_REQUEST,
                CREATE_GROUP_REQUEST,
                CREATE_GROUP_BLACKLISTED_USER_REQUEST,
                CREATE_GROUP_INVITATION_REQUEST,
                CREATE_GROUP_JOIN_REQUEST_REQUEST,
                CREATE_GROUP_JOIN_QUESTION_REQUEST,
                CREATE_GROUP_MEMBER_REQUEST);

        private static final Set<TurmsRequest.KindCase> DELETE = Set.of(
                DELETE_SESSION_REQUEST,
                DELETE_RESOURCE_REQUEST,
                DELETE_RELATIONSHIP_GROUP_REQUEST,
                DELETE_RELATIONSHIP_REQUEST,
                DELETE_GROUP_REQUEST,
                DELETE_GROUP_BLACKLISTED_USER_REQUEST,
                DELETE_GROUP_INVITATION_REQUEST,
                DELETE_GROUP_JOIN_REQUEST_REQUEST,
                DELETE_GROUP_JOIN_QUESTION_REQUEST,
                DELETE_GROUP_MEMBER_REQUEST);

        private static final Set<TurmsRequest.KindCase> UPDATE = Set.of(
                ACK_REQUEST,
                UPDATE_MESSAGE_REQUEST,
                UPDATE_TYPING_STATUS_REQUEST,
                UPDATE_USER_LOCATION_REQUEST,
                UPDATE_USER_ONLINE_STATUS_REQUEST,
                UPDATE_USER_REQUEST,
                UPDATE_FRIEND_REQUEST_REQUEST,
                UPDATE_RELATIONSHIP_GROUP_REQUEST,
                UPDATE_RELATIONSHIP_REQUEST,
                UPDATE_GROUP_REQUEST,
                UPDATE_GROUP_JOIN_QUESTION_REQUEST,
                UPDATE_GROUP_MEMBER_REQUEST);

        private static final Set<TurmsRequest.KindCase> QUERY = Set.of(
                QUERY_SIGNED_GET_URL_REQUEST,
                QUERY_SIGNED_PUT_URL_REQUEST,
                QUERY_MESSAGE_STATUSES_REQUEST,
                QUERY_MESSAGES_REQUEST,
                QUERY_PENDING_MESSAGES_WITH_TOTAL_REQUEST,
                QUERY_USER_PROFILE_REQUEST,
                QUERY_USER_IDS_NEARBY_REQUEST,
                QUERY_USER_INFOS_NEARBY_REQUEST,
                QUERY_USER_ONLINE_STATUSES_REQUEST,
                QUERY_FRIEND_REQUESTS_REQUEST,
                QUERY_RELATED_USER_IDS_REQUEST,
                QUERY_RELATIONSHIP_GROUPS_REQUEST,
                QUERY_RELATIONSHIPS_REQUEST,
                QUERY_GROUP_REQUEST,
                QUERY_JOINED_GROUP_IDS_REQUEST,
                QUERY_JOINED_GROUP_INFOS_REQUEST,
                QUERY_GROUP_BLACKLISTED_USER_IDS_REQUEST,
                QUERY_GROUP_BLACKLISTED_USER_INFOS_REQUEST,
                QUERY_GROUP_INVITATIONS_REQUEST,
                QUERY_GROUP_JOIN_REQUESTS_REQUEST,
                QUERY_GROUP_JOIN_QUESTIONS_REQUEST,
                QUERY_GROUP_MEMBERS_REQUEST);

        private static final Set<TurmsRequest.KindCase> STORAGE = Set.of(DELETE_RESOURCE_REQUEST,
                QUERY_SIGNED_GET_URL_REQUEST,
                QUERY_SIGNED_PUT_URL_REQUEST);

        private static final Set<TurmsRequest.KindCase> MESSAGE = Set.of(CREATE_MESSAGE_REQUEST,
                QUERY_MESSAGE_STATUSES_REQUEST,
                QUERY_MESSAGES_REQUEST,
                QUERY_PENDING_MESSAGES_WITH_TOTAL_REQUEST,
                UPDATE_MESSAGE_REQUEST,
                UPDATE_TYPING_STATUS_REQUEST);

        private static final Set<TurmsRequest.KindCase> USER = Set.of(QUERY_USER_PROFILE_REQUEST,
                QUERY_USER_IDS_NEARBY_REQUEST,
                QUERY_USER_INFOS_NEARBY_REQUEST,
                QUERY_USER_ONLINE_STATUSES_REQUEST,
                UPDATE_USER_LOCATION_REQUEST,
                UPDATE_USER_ONLINE_STATUS_REQUEST,
                UPDATE_USER_REQUEST);

        private static final Set<TurmsRequest.KindCase> USER_RELATIONSHIP = Set.of(CREATE_FRIEND_REQUEST_REQUEST,
                CREATE_RELATIONSHIP_GROUP_REQUEST,
                CREATE_RELATIONSHIP_REQUEST,
                DELETE_RELATIONSHIP_GROUP_REQUEST,
                DELETE_RELATIONSHIP_REQUEST,
                QUERY_FRIEND_REQUESTS_REQUEST,
                QUERY_RELATED_USER_IDS_REQUEST,
                QUERY_RELATIONSHIP_GROUPS_REQUEST,
                QUERY_RELATIONSHIPS_REQUEST,
                UPDATE_FRIEND_REQUEST_REQUEST,
                UPDATE_RELATIONSHIP_GROUP_REQUEST,
                UPDATE_RELATIONSHIP_REQUEST);

        private static final Set<TurmsRequest.KindCase> GROUP = Set.of(CREATE_GROUP_REQUEST,
                DELETE_GROUP_REQUEST,
                QUERY_GROUP_REQUEST,
                QUERY_JOINED_GROUP_IDS_REQUEST,
                QUERY_JOINED_GROUP_INFOS_REQUEST,
                UPDATE_GROUP_REQUEST);

        private static final Set<TurmsRequest.KindCase> GROUP_BLACKLIST = Set.of(CREATE_GROUP_BLACKLISTED_USER_REQUEST,
                DELETE_GROUP_BLACKLISTED_USER_REQUEST,
                QUERY_GROUP_BLACKLISTED_USER_IDS_REQUEST,
                QUERY_GROUP_BLACKLISTED_USER_INFOS_REQUEST);

        private static final Set<TurmsRequest.KindCase> GROUP_ENROLLMENT = Set.of(CHECK_GROUP_JOIN_QUESTIONS_ANSWERS_REQUEST,
                CREATE_GROUP_INVITATION_REQUEST,
                CREATE_GROUP_JOIN_REQUEST_REQUEST,
                CREATE_GROUP_JOIN_QUESTION_REQUEST,
                DELETE_GROUP_INVITATION_REQUEST,
                DELETE_GROUP_JOIN_REQUEST_REQUEST,
                DELETE_GROUP_JOIN_QUESTION_REQUEST,
                QUERY_GROUP_INVITATIONS_REQUEST,
                QUERY_GROUP_JOIN_REQUESTS_REQUEST,
                QUERY_GROUP_JOIN_QUESTIONS_REQUEST,
                UPDATE_GROUP_JOIN_QUESTION_REQUEST);

        private static final Set<TurmsRequest.KindCase> GROUP_MEMBER = Set.of(CREATE_GROUP_MEMBER_REQUEST,
                DELETE_GROUP_MEMBER_REQUEST,
                QUERY_GROUP_MEMBERS_REQUEST,
                UPDATE_GROUP_MEMBER_REQUEST);

        static {
            Set<TurmsRequest.KindCase> result = Sets.newHashSetWithExpectedSize(
                    CREATE.size()
                            + DELETE.size()
                            + UPDATE.size()
                            + QUERY.size());
            result.addAll(CREATE);
            result.addAll(DELETE);
            result.addAll(UPDATE);
            result.addAll(QUERY);
            ALL = result;
        }
    }

}