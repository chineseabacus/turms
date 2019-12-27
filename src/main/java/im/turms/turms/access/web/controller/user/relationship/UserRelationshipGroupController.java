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
import im.turms.turms.pojo.bo.common.DateRange;
import im.turms.turms.pojo.domain.UserRelationshipGroup;
import im.turms.turms.pojo.dto.*;
import im.turms.turms.service.user.relationship.UserRelationshipGroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static im.turms.turms.constant.AdminPermission.*;

@RestController
@RequestMapping("/users/relationships/groups")
public class UserRelationshipGroupController {
    private final UserRelationshipGroupService userRelationshipGroupService;
    private final PageUtil pageUtil;

    public UserRelationshipGroupController(PageUtil pageUtil, UserRelationshipGroupService userRelationshipGroupService) {
        this.pageUtil = pageUtil;
        this.userRelationshipGroupService = userRelationshipGroupService;
    }

    @PostMapping
    @RequiredPermission(USER_RELATIONSHIP_GROUP_CREATE)
    public Mono<ResponseEntity<ResponseDTO<UserRelationshipGroup>>> addRelationshipGroup(@RequestBody AddRelationshipGroupDTO addRelationshipGroupDTO) {
        Mono<UserRelationshipGroup> createMono = userRelationshipGroupService.createRelationshipGroup(
                addRelationshipGroupDTO.getOwnerId(),
                addRelationshipGroupDTO.getIndex(),
                addRelationshipGroupDTO.getName(),
                addRelationshipGroupDTO.getCreationDate(),
                null);
        return ResponseFactory.okIfTruthy(createMono);
    }

    @DeleteMapping
    @RequiredPermission(USER_RELATIONSHIP_GROUP_DELETE)
    public Mono<ResponseEntity<ResponseDTO<AcknowledgedDTO>>> deleteRelationshipGroups(
            @RequestParam(required = false) UserRelationshipGroup.KeyList keys) {
        Mono<Boolean> deleted;
        if (keys != null && !keys.getKeys().isEmpty()) {
            deleted = userRelationshipGroupService.deleteRelationshipGroups(new HashSet<>(keys.getKeys()));
        } else {
            deleted = userRelationshipGroupService.deleteRelationshipGroups();
        }
        return ResponseFactory.acknowledged(deleted);
    }

    @PutMapping
    @RequiredPermission(USER_RELATIONSHIP_GROUP_UPDATE)
    public Mono<ResponseEntity<ResponseDTO<AcknowledgedDTO>>> updateRelationshipGroups(
            @RequestParam Long ownerId,
            @RequestParam(required = false) Set<Long> indexes,
            @RequestBody UpdateRelationshipGroupDTO updateRelationshipGroupDTO) {
        Mono<Boolean> updated = userRelationshipGroupService.updateRelationshipGroups(
                ownerId,
                indexes,
                updateRelationshipGroupDTO.getOwnerId(),
                updateRelationshipGroupDTO.getIndex(),
                updateRelationshipGroupDTO.getName(),
                updateRelationshipGroupDTO.getCreationDate());
        return ResponseFactory.acknowledged(updated);
    }

    @GetMapping
    @RequiredPermission(USER_RELATIONSHIP_GROUP_QUERY)
    public Mono<ResponseEntity<ResponseDTO<Collection<UserRelationshipGroup>>>> queryRelationshipGroups(
            @RequestParam Long ownerId,
            @RequestParam(required = false) Set<Long> indexes,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Date creationDateStart,
            @RequestParam(required = false) Date creationDateEnd,
            @RequestParam(required = false) Integer size) {
        size = pageUtil.getSize(size);
        Flux<UserRelationshipGroup> queryFlux = userRelationshipGroupService.queryRelationshipGroups(
                ownerId, indexes, name, DateRange.of(creationDateStart, creationDateEnd), 0, size);
        return ResponseFactory.okIfTruthy(queryFlux);
    }

    @GetMapping("/page")
    @RequiredPermission(USER_RELATIONSHIP_GROUP_QUERY)
    public Mono<ResponseEntity<ResponseDTO<PaginationDTO<UserRelationshipGroup>>>> queryRelationshipGroups(
            @RequestParam Long ownerId,
            @RequestParam(required = false) Set<Long> indexes,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Date creationDateStart,
            @RequestParam(required = false) Date creationDateEnd,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(required = false) Integer size) {
        size = pageUtil.getSize(size);
        Mono<Long> count = userRelationshipGroupService.countRelationshipGroups(
                ownerId, indexes, name, DateRange.of(creationDateStart, creationDateEnd));
        Flux<UserRelationshipGroup> queryFlux = userRelationshipGroupService.queryRelationshipGroups(
                ownerId, indexes, name, DateRange.of(creationDateStart, creationDateEnd), page, size);
        return ResponseFactory.page(count, queryFlux);
    }
}
