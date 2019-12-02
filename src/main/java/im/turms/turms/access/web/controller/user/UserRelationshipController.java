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

package im.turms.turms.access.web.controller.user;

import im.turms.turms.access.web.util.ResponseFactory;
import im.turms.turms.annotation.web.RequiredPermission;
import im.turms.turms.common.PageUtil;
import im.turms.turms.constant.AdminPermission;
import im.turms.turms.pojo.domain.UserRelationship;
import im.turms.turms.pojo.dto.*;
import im.turms.turms.service.user.relationship.UserRelationshipService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.Set;

import static im.turms.turms.common.Constants.DEFAULT_RELATIONSHIP_GROUP_INDEX;

@RestController
@RequestMapping("/users/relationships")
public class UserRelationshipController {
    private final UserRelationshipService userRelationshipService;
    private final PageUtil pageUtil;

    public UserRelationshipController(UserRelationshipService userRelationshipService, PageUtil pageUtil) {
        this.userRelationshipService = userRelationshipService;
        this.pageUtil = pageUtil;
    }

    @PostMapping
    @RequiredPermission(AdminPermission.USER_RELATIONSHIP_CREATE)
    public Mono<ResponseEntity<ResponseDTO<AcknowledgedDTO>>> addRelationship(@RequestBody AddRelationshipDTO addRelationshipDTO) {
        Mono<Boolean> upsert = userRelationshipService.upsertOneSidedRelationship(
                addRelationshipDTO.getOwnerId(),
                addRelationshipDTO.getRelatedUserId(),
                addRelationshipDTO.getIsBlocked(),
                DEFAULT_RELATIONSHIP_GROUP_INDEX,
                null,
                addRelationshipDTO.getEstablishmentDate(),
                false,
                null);
        return ResponseFactory.acknowledged(upsert);
    }

    @DeleteMapping
    @RequiredPermission(AdminPermission.USER_RELATIONSHIP_DELETE)
    public Mono<ResponseEntity<ResponseDTO<AcknowledgedDTO>>> deleteRelationships(
            @RequestParam Long ownerId,
            @RequestParam(required = false) Set<Long> relatedUsersIds) {
        Mono<Boolean> deleted = userRelationshipService.deleteOneSidedRelationships(ownerId, relatedUsersIds);
        return ResponseFactory.acknowledged(deleted);
    }

    @PutMapping
    @RequiredPermission(AdminPermission.USER_RELATIONSHIP_UPDATE)
    public Mono<ResponseEntity<ResponseDTO<AcknowledgedDTO>>> updateRelationships(
            @RequestParam Long ownerId,
            @RequestParam(required = false) Set<Long> relatedUsersIds,
            @RequestBody UpdateRelationshipDTO updateRelationshipDTO) {
        Mono<Boolean> updated = userRelationshipService.updateUserOneSidedRelationships(
                ownerId,
                relatedUsersIds,
                updateRelationshipDTO.getIsBlocked(),
                updateRelationshipDTO.getEstablishmentDate());
        return ResponseFactory.acknowledged(updated);
    }

    @GetMapping
    @RequiredPermission(AdminPermission.USER_RELATIONSHIP_QUERY)
    public Mono<ResponseEntity<ResponseDTO<Collection<UserRelationship>>>> queryRelationships(
            @RequestParam Long ownerId,
            @RequestParam(required = false) Set<Long> relatedUsersIds,
            @RequestParam(required = false) Integer groupIndex,
            @RequestParam(required = false) Boolean isBlocked,
            @RequestParam(required = false) Integer size) {
        size = pageUtil.getSize(size);
        Flux<UserRelationship> relationshipsFlux = userRelationshipService.queryRelationships(
                ownerId, relatedUsersIds, groupIndex, isBlocked, 0, size);
        return ResponseFactory.okIfTruthy(relationshipsFlux);
    }

    @GetMapping("/page")
    @RequiredPermission(AdminPermission.USER_RELATIONSHIP_QUERY)
    public Mono<ResponseEntity<ResponseDTO<PaginationDTO<UserRelationship>>>> queryRelationships(
            @RequestParam Long ownerId,
            @RequestParam(required = false) Set<Long> relatedUsersIds,
            @RequestParam(required = false) Integer groupIndex,
            @RequestParam(required = false) Boolean isBlocked,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(required = false) Integer size) {
        size = pageUtil.getSize(size);
        Mono<Long> count = userRelationshipService.countRelationships(
                ownerId, relatedUsersIds, groupIndex, isBlocked);
        Flux<UserRelationship> relationshipsFlux = userRelationshipService.queryRelationships(
                ownerId, relatedUsersIds, groupIndex, isBlocked, page, size);
        return ResponseFactory.page(count, relationshipsFlux);
    }
}
