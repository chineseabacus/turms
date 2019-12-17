package im.turms.turms.service.message;

import com.mongodb.client.result.UpdateResult;
import im.turms.turms.cluster.TurmsClusterManager;
import im.turms.turms.common.QueryBuilder;
import im.turms.turms.common.TurmsStatusCode;
import im.turms.turms.common.UpdateBuilder;
import im.turms.turms.constant.ChatType;
import im.turms.turms.constant.MessageDeliveryStatus;
import im.turms.turms.exception.TurmsBusinessException;
import im.turms.turms.pojo.domain.MessageStatus;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Nullable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

import static im.turms.turms.common.Constants.*;

@Service
public class MessageStatusService {
    private static final MessageStatus EMPTY_MESSAGE_STATUS = new MessageStatus();
    private final ReactiveMongoTemplate mongoTemplate;
    private final TurmsClusterManager turmsClusterManager;

    public MessageStatusService(ReactiveMongoTemplate mongoTemplate, TurmsClusterManager turmsClusterManager) {
        this.mongoTemplate = mongoTemplate;
        this.turmsClusterManager = turmsClusterManager;
    }

    public Mono<Boolean> isMessageRead(@NotNull Long messageId, @NotNull Long recipientId) {
        Query query = new Query()
                .addCriteria(Criteria.where(ID_MESSAGE_ID).is(messageId))
                .addCriteria(Criteria.where(ID_RECIPIENT_ID).is(recipientId))
                .addCriteria(Criteria.where(MessageStatus.Fields.readDate).ne(null));
        return mongoTemplate.exists(query, MessageStatus.class);
    }

    public Flux<Long> queryMessagesIdsByDeliveryStatusAndTargetId(
            @NotNull MessageDeliveryStatus deliveryStatus,
            @Nullable ChatType chatType,
            @Nullable Long targetId) {
        Query query = new Query()
                .addCriteria(Criteria.where(MessageStatus.Fields.deliveryStatus).is(deliveryStatus));
        if (chatType == ChatType.PRIVATE || chatType == ChatType.GROUP) {
            if (targetId == null) {
                return Flux.empty();
            }
            if (chatType == ChatType.PRIVATE) {
                query.addCriteria(Criteria.where(ID_RECIPIENT_ID).is(targetId));
            } else {
                query.addCriteria(Criteria.where(MessageStatus.Fields.groupId).is(targetId));
            }
        }
        query.fields().include(ID_MESSAGE_ID);
        return mongoTemplate
                .find(query, MessageStatus.class)
                .map(status -> status.getKey().getMessageId());
    }

    public Mono<Boolean> updateMessageStatuses(
            @Nullable Set<Long> messageIds,
            @Nullable Set<Long> recipientIds,
            @Nullable Date recallDate,
            @Nullable Date readDate,
            @Nullable Date receptionDate,
            @Nullable ReactiveMongoOperations operations) {
        boolean isIllegalRecall = recallDate != null
                && !turmsClusterManager.getTurmsProperties().getMessage().isAllowRecallingMessage();
        boolean isIllegalRead = readDate != null
                && !turmsClusterManager.getTurmsProperties().getMessage().getReadReceipt().isEnabled();
        if (isIllegalRecall || isIllegalRead) {
            throw TurmsBusinessException.get(TurmsStatusCode.DISABLE_FUNCTION);
        }
        Query query = QueryBuilder
                .newBuilder()
                .addInIfNotNull(ID_MESSAGE_ID, messageIds)
                .addInIfNotNull(ID_RECIPIENT_ID, recipientIds)
                .buildQuery();
        Update update = UpdateBuilder.newBuilder()
                .setIfNotNull(MessageStatus.Fields.recallDate, recallDate)
                .setIfNotNull(MessageStatus.Fields.readDate, readDate)
                .setIfNotNull(MessageStatus.Fields.receptionDate, receptionDate)
                .build();
        ReactiveMongoOperations mongoOperations = operations != null ? operations : mongoTemplate;
        return mongoOperations.updateFirst(query, update, MessageStatus.class)
                .map(UpdateResult::wasAcknowledged);
    }

    public Mono<Boolean> updateMessageStatus(
            @NotNull Long messageId,
            @NotNull Long recipientId,
            @Nullable Date recallDate,
            @Nullable Date readDate,
            @Nullable Date receptionDate,
            @Nullable ReactiveMongoOperations operations) {
        return updateMessageStatuses(
                Collections.singleton(messageId),
                Collections.singleton(recipientId),
                recallDate, readDate, receptionDate, operations);
    }

    public Mono<Boolean> authAndUpdateMessagesDeliveryStatus(
            @NotNull Long recipientId,
            @NotEmpty Collection<Long> messagesIds,
            @NotNull MessageDeliveryStatus deliveryStatus) {
        Query query = new Query()
                .addCriteria(Criteria.where(ID_MESSAGE_ID).in(messagesIds))
                .addCriteria(Criteria.where(ID_RECIPIENT_ID).is(recipientId));
        Update update = new Update().set(MessageStatus.Fields.deliveryStatus, deliveryStatus);
        return mongoTemplate.updateMulti(query, update, MessageStatus.class)
                .map(UpdateResult::wasAcknowledged);
    }

    public Mono<Boolean> updateMessagesReadDate(
            @NotNull Long messageId,
            @Nullable Date readDate) {
        Query query = new Query()
                .addCriteria(Criteria.where(ID_MESSAGE_ID).is(messageId))
                .addCriteria(Criteria.where(MessageStatus.Fields.readDate).is(null));
        Update update;
        if (readDate != null) {
            update = new Update().set(MessageStatus.Fields.readDate, readDate);
        } else {
            update = new Update().unset(MessageStatus.Fields.readDate);
        }
        return mongoTemplate.findAndModify(query, update, MessageStatus.class)
                .defaultIfEmpty(EMPTY_MESSAGE_STATUS)
                .map(status -> EMPTY_MESSAGE_STATUS != status);
    }

    public Mono<MessageStatus> queryMessageStatus(@NotNull Long messageId) {
        Query query = new Query().addCriteria(Criteria.where(ID_MESSAGE_ID).is(messageId));
        return mongoTemplate.findOne(query, MessageStatus.class);
    }

    public Flux<MessageStatus> queryMessageStatuses(@NotEmpty Set<Long> messageIds) {
        Query query = new Query().addCriteria(Criteria.where(ID_MESSAGE_ID).in(messageIds));
        return mongoTemplate.find(query, MessageStatus.class);
    }

    public Flux<MessageStatus> queryMessageStatuses(@NotEmpty Set<Long> ids, @Nullable Integer page, @Nullable Integer size) {
        Query query = QueryBuilder
                .newBuilder()
                .addInIfNotNull(ID_MESSAGE_ID, ids)
                .paginateIfNotNull(page, size);
        return mongoTemplate.find(query, MessageStatus.class);
    }

    public Mono<Long> countPendingMessages(
            @NotNull ChatType chatType,
            @Nullable Boolean areSystemMessages,
            @NotNull Long groupOrSenderId,
            @NotNull Long recipientId) {
        Query query = new Query()
                .addCriteria(Criteria.where(ID_RECIPIENT_ID).is(recipientId))
                .addCriteria(Criteria.where(MessageStatus.Fields.deliveryStatus).is(MessageDeliveryStatus.READY));
        if (areSystemMessages != null) {
            query.addCriteria(Criteria.where(MessageStatus.Fields.isSystemMessage).is(areSystemMessages));
        }
        switch (chatType) {
            case PRIVATE:
                query.addCriteria(Criteria.where(MessageStatus.Fields.groupId).is(null))
                        .addCriteria(Criteria.where(MessageStatus.Fields.senderId).is(groupOrSenderId));
                break;
            case GROUP:
                query.addCriteria(Criteria.where(MessageStatus.Fields.groupId).is(groupOrSenderId));
                break;
            default:
                throw new UnsupportedOperationException("");
        }
        return mongoTemplate.count(query, MessageStatus.class);
    }

    public Mono<Boolean> acknowledge(@NotEmpty Set<Long> messagesIds) {
        Query query = new Query().addCriteria(Criteria.where(ID).in(messagesIds));
        Update update = new Update().set(MessageStatus.Fields.deliveryStatus, MessageDeliveryStatus.RECEIVED);
        if (turmsClusterManager.getTurmsProperties().getMessage()
                .isUpdateReadDateAutomaticallyAfterUserQueryingMessage()) {
            Date now = new Date();
            update.set(MessageStatus.Fields.readDate, now);
        }
        return mongoTemplate.updateMulti(query, update, MessageStatus.class)
                .map(UpdateResult::wasAcknowledged);
    }
}
