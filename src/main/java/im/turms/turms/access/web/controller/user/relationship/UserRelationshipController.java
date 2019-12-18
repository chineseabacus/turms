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

package im.turms.turms.access.web.controller.user.relationship;

import im.turms.turms.access.web.util.ResponseFactory;
import im.turms.turms.annotation.web.RequiredPermission;
import im.turms.turms.common.PageUtil;
import im.turms.turms.common.TurmsStatusCode;
import im.turms.turms.exception.TurmsBusinessException;
import im.turms.turms.pojo.domain.UserRelationship;
import im.turms.turms.pojo.dto.*;
import im.turms.turms.service.user.relationship.UserRelationshipGroupService;
import im.turms.turms.service.user.relationship.UserRelationshipService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static im.turms.turms.common.Constants.DEFAULT_RELATIONSHIP_GROUP_INDEX;
import static im.turms.turms.constant.AdminPermission.*;

@RestController
@RequestMapping("/users/relationships")
public class UserRelationshipController {
    private final UserRelationshipService userRelationshipService;
    private final UserRelationshipGroupService userRelationshipGroupService;
    private final PageUtil pageUtil;

    public UserRelationshipController(UserRelationshipService userRelationshipService, PageUtil pageUtil, UserRelationshipGroupService userRelationshipGroupService) {
        this.userRelationshipService = userRelationshipService;
        this.pageUtil = pageUtil;
        this.userRelationshipGroupService = userRelationshipGroupService;
    }

    @PostMapping
    @RequiredPermission(USER_RELATIONSHIP_CREATE)
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
    @RequiredPermission(USER_RELATIONSHIP_DELETE)
    public Mono<ResponseEntity<ResponseDTO<AcknowledgedDTO>>> deleteRelationships(
            @RequestParam(required = false) Long ownerId,
            @RequestParam(required = false) Set<Long> relatedUsersIds,
            UserRelationship.KeyList keys) {
        Mono<Boolean> deleted;
        if (keys != null && !keys.getKeys().isEmpty()) {
            deleted = userRelationshipService.deleteOneSidedRelationships(new HashSet<>(keys.getKeys()));
        } else {
            deleted = userRelationshipService.deleteOneSidedRelationships(ownerId, relatedUsersIds);
        }
        return ResponseFactory.acknowledged(deleted);
    }

    @PutMapping
    @RequiredPermission(USER_RELATIONSHIP_UPDATE)
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
    @RequiredPermission(USER_RELATIONSHIP_QUERY)
    public Mono<ResponseEntity<ResponseDTO<Collection<UserRelationshipDTO>>>> queryRelationships(
            @RequestParam Long ownerId,
            @RequestParam(required = false) Set<Long> relatedUsersIds,
            @RequestParam(required = false) Integer groupIndex,
            @RequestParam(required = false) Boolean isBlocked,
            @RequestParam(required = false) Date establishmentDateStart,
            @RequestParam(required = false) Date establishmentDateEnd,
            @RequestParam(required = false) Integer size,
            @RequestParam(defaultValue = "false") Boolean withGroupIndexes) {
        size = pageUtil.getSize(size);
        Flux<UserRelationship> relationshipsFlux = userRelationshipService.queryRelationships(
                ownerId, relatedUsersIds, groupIndex, isBlocked, establishmentDateStart, establishmentDateEnd, 0, size);
        Flux<UserRelationshipDTO> dtoFlux = relationship2dto(ownerId, withGroupIndexes, relationshipsFlux);
        return ResponseFactory.okIfTruthy(dtoFlux);
    }

    @GetMapping("/page")
    @RequiredPermission(USER_RELATIONSHIP_QUERY)
    public Mono<ResponseEntity<ResponseDTO<PaginationDTO<UserRelationshipDTO>>>> queryRelationships(
            @RequestParam(required = false) Long ownerId,
            @RequestParam(required = false) Set<Long> relatedUsersIds,
            @RequestParam(required = false) Integer groupIndex,
            @RequestParam(required = false) Boolean isBlocked,
            @RequestParam(required = false) Date establishmentDateStart,
            @RequestParam(required = false) Date establishmentDateEnd,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(required = false) Integer size,
            @RequestParam(defaultValue = "false") Boolean withGroupIndexes) {
        size = pageUtil.getSize(size);
        Mono<Long> count = userRelationshipService.countRelationships(
                ownerId, relatedUsersIds, groupIndex, isBlocked);
        Flux<UserRelationship> relationshipsFlux = userRelationshipService.queryRelationships(
                ownerId, relatedUsersIds, groupIndex, isBlocked, establishmentDateStart, establishmentDateEnd, page, size);
        Flux<UserRelationshipDTO> dtoFlux = relationship2dto(ownerId, withGroupIndexes, relationshipsFlux);
        return ResponseFactory.page(count, dtoFlux);
    }

    private Flux<UserRelationshipDTO> relationship2dto(Long ownerId, Boolean withGroupIndexes, Flux<UserRelationship> relationshipsFlux) {
        return relationshipsFlux
                .flatMap(relationship -> {
                    if (withGroupIndexes) {
                        if (ownerId != null) {
                            return userRelationshipGroupService.queryGroupIndexes(
                                    ownerId, relationship.getKey().getRelatedUserId())
                                    .collect(Collectors.toSet())
                                    .map(indexes -> UserRelationshipDTO.fromDomain(relationship, indexes));
                        } else {
                            return Flux.error(TurmsBusinessException.get(TurmsStatusCode.ILLEGAL_ARGUMENTS));
                        }
                    } else {
                        return Mono.just(UserRelationshipDTO.fromDomain(relationship));
                    }
                });
    }
}
