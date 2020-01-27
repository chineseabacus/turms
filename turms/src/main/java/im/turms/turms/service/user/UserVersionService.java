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

package im.turms.turms.service.user;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import im.turms.turms.pojo.domain.UserVersion;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.annotation.Nullable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

import static im.turms.turms.common.Constants.ID;

@Service
@Validated
public class UserVersionService {
    private final ReactiveMongoTemplate mongoTemplate;

    public UserVersionService(ReactiveMongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Mono<Date> queryRelationshipsLastUpdatedDate(@NotNull Long userId) {
        Query query = new Query().addCriteria(Criteria.where(ID).is(userId));
        query.fields().include(UserVersion.Fields.relationships);
        return mongoTemplate.findOne(query, UserVersion.class)
                .map(UserVersion::getRelationships);
    }

    public Mono<Date> queryGroupInvitationsLastUpdatedDate(@NotNull Long userId) {
        Query query = new Query().addCriteria(Criteria.where(ID).is(userId));
        query.fields().include(UserVersion.Fields.groupInvitations);
        return mongoTemplate.findOne(query, UserVersion.class)
                .map(UserVersion::getGroupInvitations);
    }

    public Mono<Date> queryRelationshipGroupsLastUpdatedDate(@NotNull Long userId) {
        Query query = new Query().addCriteria(Criteria.where(ID).is(userId));
        query.fields().include(UserVersion.Fields.relationshipGroups);
        return mongoTemplate.findOne(query, UserVersion.class)
                .map(UserVersion::getRelationshipGroups);
    }

    public Mono<Date> queryJoinedGroupVersion(@NotNull Long userId) {
        Query query = new Query().addCriteria(Criteria.where(ID).is(userId));
        query.fields().include(UserVersion.Fields.joinedGroups);
        return mongoTemplate.findOne(query, UserVersion.class)
                .map(UserVersion::getJoinedGroups);
    }

    public Mono<Date> queryFriendRequestsVersion(@NotNull Long userId) {
        Query query = new Query().addCriteria(Criteria.where(ID).is(userId));
        query.fields().include(UserVersion.Fields.friendRequests);
        return mongoTemplate.findOne(query, UserVersion.class)
                .map(UserVersion::getFriendRequests);
    }

    public Mono<UserVersion> upsertEmptyUserVersion(
            @NotNull Long userId,
            @Nullable ReactiveMongoOperations operations) {
        UserVersion userVersion = new UserVersion();
        userVersion.setUserId(userId);
        ReactiveMongoOperations mongoOperations = operations != null ? operations : mongoTemplate;
        return mongoOperations.save(userVersion);
    }

    public Mono<Boolean> updateRelationshipsVersion(@NotNull Long userId, @Nullable ReactiveMongoOperations operations) {
        return updateSpecificVersion(userId, operations, UserVersion.Fields.relationships);
    }

    public Mono<Boolean> updateRelationshipsVersion(@NotEmpty Set<Long> userIds, @Nullable ReactiveMongoOperations operations) {
        return updateSpecificVersion(userIds, operations, UserVersion.Fields.relationships);
    }

    public Mono<Boolean> updateFriendRequestsVersion(@NotNull Long userId) {
        return updateSpecificVersion(userId, null, UserVersion.Fields.friendRequests);
    }

    public Mono<Boolean> updateRelationshipGroupsVersion(@NotNull Long userId) {
        return updateSpecificVersion(userId, null, UserVersion.Fields.relationshipGroups);
    }

    public Mono<Boolean> updateRelationshipGroupsVersion(@NotEmpty Set<Long> userIds) {
        return updateSpecificVersion(userIds, null, UserVersion.Fields.relationshipGroups);
    }

    public Mono<Boolean> updateRelationshipGroupsMembersVersion(@NotNull Long userId) {
        return updateSpecificVersion(userId, null, UserVersion.Fields.relationshipGroupsMembers);
    }

    public Mono<Boolean> updateRelationshipGroupsMembersVersion(@NotEmpty Set<Long> userIds) {
        return updateSpecificVersion(userIds, null, UserVersion.Fields.relationshipGroupsMembers);
    }

    public Mono<Boolean> updateGroupInvitationsVersion(@NotNull Long userId) {
        return updateSpecificVersion(userId, null, UserVersion.Fields.groupInvitations);
    }

    public Mono<Boolean> updateJoinedGroupsVersion(@NotNull Long userId) {
        return updateSpecificVersion(userId, null, UserVersion.Fields.joinedGroups);
    }

    public Mono<Boolean> updateSpecificVersion(@NotNull Long userId, @Nullable ReactiveMongoOperations operations, @NotEmpty String... fields) {
        return updateSpecificVersion(Collections.singleton(userId), operations, fields);
    }

    public Mono<Boolean> updateSpecificVersion(@NotEmpty Set<Long> userIds, @Nullable ReactiveMongoOperations operations, @NotEmpty String... fields) {
        Query query = new Query().addCriteria(Criteria.where(ID).in(userIds));
        Update update = new Update();
        Date now = new Date();
        for (String field : fields) {
            update.set(field, now);
        }
        ReactiveMongoOperations mongoOperations = operations != null ? operations : mongoTemplate;
        return mongoOperations.updateMulti(query, update, UserVersion.class)
                .map(UpdateResult::wasAcknowledged);
    }

    public Mono<Boolean> delete(
            @NotEmpty Set<Long> userIds,
            @Nullable ReactiveMongoOperations operations) {
        Query query = new Query().addCriteria(Criteria.where(ID).in(userIds));
        ReactiveMongoOperations mongoOperations = operations != null ? operations : mongoTemplate;
        return mongoOperations.remove(query).map(DeleteResult::wasAcknowledged);
    }
}
