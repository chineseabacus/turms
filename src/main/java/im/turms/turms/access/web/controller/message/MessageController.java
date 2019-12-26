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

package im.turms.turms.access.web.controller.message;

import im.turms.turms.access.web.util.ResponseFactory;
import im.turms.turms.annotation.web.RequiredPermission;
import im.turms.turms.common.DateTimeUtil;
import im.turms.turms.common.PageUtil;
import im.turms.turms.common.TurmsStatusCode;
import im.turms.turms.constant.ChatType;
import im.turms.turms.constant.DivideBy;
import im.turms.turms.constant.MessageDeliveryStatus;
import im.turms.turms.exception.TurmsBusinessException;
import im.turms.turms.pojo.bo.common.DateRange;
import im.turms.turms.pojo.domain.Message;
import im.turms.turms.pojo.dto.*;
import im.turms.turms.service.message.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;

import static im.turms.turms.constant.AdminPermission.*;

@RestController
@RequestMapping("/messages")
public class MessageController {
    private final MessageService messageService;
    private final PageUtil pageUtil;
    private final DateTimeUtil dateTimeUtil;

    public MessageController(MessageService messageService, PageUtil pageUtil, DateTimeUtil dateTimeUtil) {
        this.messageService = messageService;
        this.pageUtil = pageUtil;
        this.dateTimeUtil = dateTimeUtil;
    }

    @GetMapping
    @RequiredPermission(MESSAGE_QUERY)
    public Mono<ResponseEntity<ResponseDTO<Collection<Message>>>> queryCompleteMessages(
            @RequestParam(required = false) Set<Long> ids,
            @RequestParam(required = false) ChatType chatType,
            @RequestParam(required = false) Boolean areSystemMessages,
            @RequestParam(required = false) Long senderId,
            @RequestParam(required = false) Long targetId,
            @RequestParam(required = false) Date deliveryDateStart,
            @RequestParam(required = false) Date deliveryDateEnd,
            @RequestParam(required = false) Date deletionDateStart,
            @RequestParam(required = false) Date deletionDateEnd,
            @RequestParam(required = false) MessageDeliveryStatus deliveryStatus,
            @RequestParam(required = false) Integer size) {
        Flux<Message> completeMessages = messageService.queryCompleteMessages(
                false,
                ids,
                chatType,
                areSystemMessages,
                senderId,
                targetId,
                DateRange.of(deliveryDateStart, deliveryDateEnd),
                DateRange.of(deletionDateStart, deletionDateEnd),
                deliveryStatus,
                0,
                pageUtil.getSize(size));
        return ResponseFactory.okIfTruthy(completeMessages);
    }

    @GetMapping("/page")
    @RequiredPermission(MESSAGE_QUERY)
    public Mono<ResponseEntity<ResponseDTO<PaginationDTO<Message>>>> queryCompleteMessages(
            @RequestParam(required = false) Set<Long> ids,
            @RequestParam(required = false) ChatType chatType,
            @RequestParam(required = false) Boolean areSystemMessages,
            @RequestParam(required = false) Long senderId,
            @RequestParam(required = false) Long targetId,
            @RequestParam(required = false) Date deliveryDateStart,
            @RequestParam(required = false) Date deliveryDateEnd,
            @RequestParam(required = false) Date deletionDateStart,
            @RequestParam(required = false) Date deletionDateEnd,
            @RequestParam(required = false) MessageDeliveryStatus deliveryStatus,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(required = false) Integer size) {
        Mono<Long> count = messageService.countMessages(
                ids,
                chatType,
                areSystemMessages,
                senderId,
                targetId,
                DateRange.of(deliveryDateStart, deliveryDateEnd),
                DateRange.of(deletionDateStart, deletionDateEnd),
                deliveryStatus);
        Flux<Message> completeMessages = messageService.queryCompleteMessages(
                false,
                ids,
                chatType,
                areSystemMessages,
                senderId,
                targetId,
                DateRange.of(deliveryDateStart, deliveryDateEnd),
                DateRange.of(deletionDateStart, deletionDateEnd),
                deliveryStatus,
                page,
                pageUtil.getSize(size));
        return ResponseFactory.page(count, completeMessages);
    }

    @PostMapping
    @RequiredPermission(MESSAGE_CREATE)
    public Mono<ResponseEntity<ResponseDTO<AcknowledgedDTO>>> createMessages(
            @RequestParam(defaultValue = "true") Boolean deliver,
            @RequestBody CreateMessageDTO dto) {
        Mono<Boolean> acknowledged = messageService.sendMessage(
                deliver,
                dto.getChatType(),
                dto.getIsSystemMessage(),
                dto.getText(),
                dto.getRecords(),
                dto.getSenderId(),
                dto.getTargetId(),
                dto.getBurnAfter(),
                dto.getReferenceId());
        return ResponseFactory.acknowledged(acknowledged);
    }

    @PutMapping
    @RequiredPermission(MESSAGE_UPDATE)
    public Mono<ResponseEntity<ResponseDTO<AcknowledgedDTO>>> updateMessages(
            @RequestParam Set<Long> ids,
            @RequestBody UpdateMessageDTO dto) {
        Mono<Boolean> acknowledged = messageService.updateMessage(
                ids,
                dto.getIsSystemMessage(),
                dto.getText(),
                dto.getRecords(),
                dto.getBurnAfter(),
                null);
        return ResponseFactory.acknowledged(acknowledged);
    }

    @DeleteMapping
    @RequiredPermission(MESSAGE_DELETE)
    public Mono<ResponseEntity<ResponseDTO<AcknowledgedDTO>>> deleteMessages(
            @RequestParam Set<Long> messagesIds,
            @RequestParam(defaultValue = "false") Boolean deleteMessagesStatuses,
            @RequestParam(required = false) Boolean shouldDeleteLogically) {
        Mono<Boolean> deleted = messageService
                .deleteMessages(messagesIds, deleteMessagesStatuses, shouldDeleteLogically);
        return ResponseFactory.acknowledged(deleted);
    }

    @GetMapping("/count")
    @RequiredPermission(MESSAGE_QUERY)
    public Mono<ResponseEntity<ResponseDTO<MessageStatisticsDTO>>> countMessages(
            @RequestParam(required = false) ChatType chatType,
            @RequestParam(required = false) Boolean areSystemMessages,
            @RequestParam(required = false) Date sentStartDate,
            @RequestParam(required = false) Date sentEndDate,
            @RequestParam(required = false) Date sentOnAverageStartDate,
            @RequestParam(required = false) Date sentOnAverageEndDate,
            @RequestParam(required = false) Date acknowledgedStartDate,
            @RequestParam(required = false) Date acknowledgedEndDate,
            @RequestParam(required = false) Date acknowledgedOnAverageStartDate,
            @RequestParam(required = false) Date acknowledgedOnAverageEndDate,
            @RequestParam(defaultValue = "NOOP") DivideBy divideBy) {
        List<Mono<?>> counts = new LinkedList<>();
        MessageStatisticsDTO statistics = new MessageStatisticsDTO();
        if (chatType == ChatType.UNRECOGNIZED) {
            throw TurmsBusinessException.get(TurmsStatusCode.ILLEGAL_ARGUMENTS);
        }
        if (divideBy == null || divideBy == DivideBy.NOOP) {
            if (sentOnAverageStartDate != null || sentOnAverageEndDate != null) {
                counts.add(messageService.countSentMessagesOnAverage(
                        DateRange.of(sentOnAverageStartDate, sentOnAverageEndDate),
                        chatType,
                        areSystemMessages)
                        .doOnNext(statistics::setSentMessagesOnAverage));
            }
            if (acknowledgedStartDate != null || acknowledgedEndDate != null) {
                counts.add(messageService.countAcknowledgedMessages(
                        DateRange.of(acknowledgedStartDate, acknowledgedEndDate),
                        chatType,
                        areSystemMessages)
                        .doOnNext(statistics::setAcknowledgedMessages));
            }
            if (acknowledgedOnAverageStartDate != null || acknowledgedOnAverageEndDate != null) {
                counts.add(messageService.countAcknowledgedMessagesOnAverage(
                        DateRange.of(acknowledgedOnAverageStartDate, acknowledgedOnAverageEndDate),
                        chatType,
                        areSystemMessages)
                        .doOnNext(statistics::setAcknowledgedMessagesOnAverage));
            }
            if (counts.isEmpty() || sentStartDate != null || sentEndDate != null) {
                counts.add(messageService.countSentMessages(
                        DateRange.of(sentStartDate, sentEndDate),
                        chatType,
                        areSystemMessages)
                        .doOnNext(statistics::setSentMessages));
            }
        } else {
            if (sentOnAverageStartDate != null && sentOnAverageEndDate != null) {
                counts.add(dateTimeUtil.checkAndQueryBetweenDate(
                        DateRange.of(sentOnAverageStartDate, sentOnAverageEndDate),
                        divideBy,
                        messageService::countSentMessagesOnAverage,
                        chatType,
                        areSystemMessages)
                        .doOnNext(statistics::setSentMessagesOnAverageRecords));
            }
            if (acknowledgedStartDate != null && acknowledgedEndDate != null) {
                counts.add(dateTimeUtil.checkAndQueryBetweenDate(
                        DateRange.of(acknowledgedStartDate, acknowledgedEndDate),
                        divideBy,
                        messageService::countAcknowledgedMessages,
                        chatType,
                        areSystemMessages)
                        .doOnNext(statistics::setAcknowledgedMessagesRecords));
            }
            if (acknowledgedOnAverageStartDate != null && acknowledgedOnAverageEndDate != null) {
                counts.add(dateTimeUtil.checkAndQueryBetweenDate(
                        DateRange.of(acknowledgedOnAverageStartDate, acknowledgedOnAverageEndDate),
                        divideBy,
                        messageService::countAcknowledgedMessagesOnAverage,
                        chatType,
                        areSystemMessages)
                        .doOnNext(statistics::setAcknowledgedMessagesOnAverageRecords));
            }
            if (sentStartDate != null && sentEndDate != null) {
                counts.add(dateTimeUtil.checkAndQueryBetweenDate(
                        DateRange.of(sentStartDate, sentEndDate),
                        divideBy,
                        messageService::countSentMessages,
                        chatType,
                        areSystemMessages)
                        .doOnNext(statistics::setSentMessagesRecords));
            }
            if (counts.isEmpty()) {
                throw TurmsBusinessException.get(TurmsStatusCode.ILLEGAL_ARGUMENTS);
            }
        }
        return ResponseFactory.okIfTruthy(Flux.merge(counts).then(Mono.just(statistics)));
    }
}
