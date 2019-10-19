// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: request/message/create_message_request.proto

package im.turms.turms.pojo.request;

public interface CreateMessageRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:im.turms.proto.CreateMessageRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.google.protobuf.Int64Value message_id = 1;</code>
   * @return Whether the messageId field is set.
   */
  boolean hasMessageId();
  /**
   * <code>.google.protobuf.Int64Value message_id = 1;</code>
   * @return The messageId.
   */
  com.google.protobuf.Int64Value getMessageId();
  /**
   * <code>.google.protobuf.Int64Value message_id = 1;</code>
   */
  com.google.protobuf.Int64ValueOrBuilder getMessageIdOrBuilder();

  /**
   * <code>.im.turms.proto.ChatType chat_type = 2;</code>
   * @return The enum numeric value on the wire for chatType.
   */
  int getChatTypeValue();
  /**
   * <code>.im.turms.proto.ChatType chat_type = 2;</code>
   * @return The chatType.
   */
  im.turms.turms.constant.ChatType getChatType();

  /**
   * <code>int64 to_id = 3;</code>
   * @return The toId.
   */
  long getToId();

  /**
   * <code>int64 delivery_date = 4;</code>
   * @return The deliveryDate.
   */
  long getDeliveryDate();

  /**
   * <code>.google.protobuf.StringValue text = 5;</code>
   * @return Whether the text field is set.
   */
  boolean hasText();
  /**
   * <code>.google.protobuf.StringValue text = 5;</code>
   * @return The text.
   */
  com.google.protobuf.StringValue getText();
  /**
   * <code>.google.protobuf.StringValue text = 5;</code>
   */
  com.google.protobuf.StringValueOrBuilder getTextOrBuilder();

  /**
   * <code>repeated bytes records = 6;</code>
   * @return A list containing the records.
   */
  java.util.List<com.google.protobuf.ByteString> getRecordsList();
  /**
   * <code>repeated bytes records = 6;</code>
   * @return The count of records.
   */
  int getRecordsCount();
  /**
   * <code>repeated bytes records = 6;</code>
   * @param index The index of the element to return.
   * @return The records at the given index.
   */
  com.google.protobuf.ByteString getRecords(int index);

  /**
   * <code>.google.protobuf.Int32Value burn_after = 7;</code>
   * @return Whether the burnAfter field is set.
   */
  boolean hasBurnAfter();
  /**
   * <code>.google.protobuf.Int32Value burn_after = 7;</code>
   * @return The burnAfter.
   */
  com.google.protobuf.Int32Value getBurnAfter();
  /**
   * <code>.google.protobuf.Int32Value burn_after = 7;</code>
   */
  com.google.protobuf.Int32ValueOrBuilder getBurnAfterOrBuilder();
}