// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: model/signal/acknowledge.proto

package im.turms.turms.pojo.bo.signal;

/**
 * Protobuf type {@code im.turms.proto.Acknowledge}
 */
public  final class Acknowledge extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:im.turms.proto.Acknowledge)
    AcknowledgeOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Acknowledge.newBuilder() to construct.
  private Acknowledge(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Acknowledge() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Acknowledge();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Acknowledge(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            deliveryDate_ = input.readInt64();
            break;
          }
          case 18: {
            com.google.protobuf.Int64Value.Builder subBuilder = null;
            if (messageId_ != null) {
              subBuilder = messageId_.toBuilder();
            }
            messageId_ = input.readMessage(com.google.protobuf.Int64Value.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(messageId_);
              messageId_ = subBuilder.buildPartial();
            }

            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return im.turms.turms.pojo.bo.signal.AcknowledgeOuterClass.internal_static_im_turms_proto_Acknowledge_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return im.turms.turms.pojo.bo.signal.AcknowledgeOuterClass.internal_static_im_turms_proto_Acknowledge_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            im.turms.turms.pojo.bo.signal.Acknowledge.class, im.turms.turms.pojo.bo.signal.Acknowledge.Builder.class);
  }

  public static final int DELIVERY_DATE_FIELD_NUMBER = 1;
  private long deliveryDate_;
  /**
   * <code>int64 delivery_date = 1;</code>
   * @return The deliveryDate.
   */
  public long getDeliveryDate() {
    return deliveryDate_;
  }

  public static final int MESSAGE_ID_FIELD_NUMBER = 2;
  private com.google.protobuf.Int64Value messageId_;
  /**
   * <code>.google.protobuf.Int64Value message_id = 2;</code>
   * @return Whether the messageId field is set.
   */
  public boolean hasMessageId() {
    return messageId_ != null;
  }
  /**
   * <code>.google.protobuf.Int64Value message_id = 2;</code>
   * @return The messageId.
   */
  public com.google.protobuf.Int64Value getMessageId() {
    return messageId_ == null ? com.google.protobuf.Int64Value.getDefaultInstance() : messageId_;
  }
  /**
   * <code>.google.protobuf.Int64Value message_id = 2;</code>
   */
  public com.google.protobuf.Int64ValueOrBuilder getMessageIdOrBuilder() {
    return getMessageId();
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (deliveryDate_ != 0L) {
      output.writeInt64(1, deliveryDate_);
    }
    if (messageId_ != null) {
      output.writeMessage(2, getMessageId());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (deliveryDate_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, deliveryDate_);
    }
    if (messageId_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getMessageId());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof im.turms.turms.pojo.bo.signal.Acknowledge)) {
      return super.equals(obj);
    }
    im.turms.turms.pojo.bo.signal.Acknowledge other = (im.turms.turms.pojo.bo.signal.Acknowledge) obj;

    if (getDeliveryDate()
        != other.getDeliveryDate()) return false;
    if (hasMessageId() != other.hasMessageId()) return false;
    if (hasMessageId()) {
      if (!getMessageId()
          .equals(other.getMessageId())) return false;
    }
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + DELIVERY_DATE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getDeliveryDate());
    if (hasMessageId()) {
      hash = (37 * hash) + MESSAGE_ID_FIELD_NUMBER;
      hash = (53 * hash) + getMessageId().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static im.turms.turms.pojo.bo.signal.Acknowledge parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static im.turms.turms.pojo.bo.signal.Acknowledge parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static im.turms.turms.pojo.bo.signal.Acknowledge parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static im.turms.turms.pojo.bo.signal.Acknowledge parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static im.turms.turms.pojo.bo.signal.Acknowledge parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static im.turms.turms.pojo.bo.signal.Acknowledge parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static im.turms.turms.pojo.bo.signal.Acknowledge parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static im.turms.turms.pojo.bo.signal.Acknowledge parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static im.turms.turms.pojo.bo.signal.Acknowledge parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static im.turms.turms.pojo.bo.signal.Acknowledge parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static im.turms.turms.pojo.bo.signal.Acknowledge parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static im.turms.turms.pojo.bo.signal.Acknowledge parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(im.turms.turms.pojo.bo.signal.Acknowledge prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code im.turms.proto.Acknowledge}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:im.turms.proto.Acknowledge)
      im.turms.turms.pojo.bo.signal.AcknowledgeOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return im.turms.turms.pojo.bo.signal.AcknowledgeOuterClass.internal_static_im_turms_proto_Acknowledge_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return im.turms.turms.pojo.bo.signal.AcknowledgeOuterClass.internal_static_im_turms_proto_Acknowledge_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              im.turms.turms.pojo.bo.signal.Acknowledge.class, im.turms.turms.pojo.bo.signal.Acknowledge.Builder.class);
    }

    // Construct using im.turms.turms.pojo.bo.signal.Acknowledge.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      deliveryDate_ = 0L;

      if (messageIdBuilder_ == null) {
        messageId_ = null;
      } else {
        messageId_ = null;
        messageIdBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return im.turms.turms.pojo.bo.signal.AcknowledgeOuterClass.internal_static_im_turms_proto_Acknowledge_descriptor;
    }

    @java.lang.Override
    public im.turms.turms.pojo.bo.signal.Acknowledge getDefaultInstanceForType() {
      return im.turms.turms.pojo.bo.signal.Acknowledge.getDefaultInstance();
    }

    @java.lang.Override
    public im.turms.turms.pojo.bo.signal.Acknowledge build() {
      im.turms.turms.pojo.bo.signal.Acknowledge result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public im.turms.turms.pojo.bo.signal.Acknowledge buildPartial() {
      im.turms.turms.pojo.bo.signal.Acknowledge result = new im.turms.turms.pojo.bo.signal.Acknowledge(this);
      result.deliveryDate_ = deliveryDate_;
      if (messageIdBuilder_ == null) {
        result.messageId_ = messageId_;
      } else {
        result.messageId_ = messageIdBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof im.turms.turms.pojo.bo.signal.Acknowledge) {
        return mergeFrom((im.turms.turms.pojo.bo.signal.Acknowledge)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(im.turms.turms.pojo.bo.signal.Acknowledge other) {
      if (other == im.turms.turms.pojo.bo.signal.Acknowledge.getDefaultInstance()) return this;
      if (other.getDeliveryDate() != 0L) {
        setDeliveryDate(other.getDeliveryDate());
      }
      if (other.hasMessageId()) {
        mergeMessageId(other.getMessageId());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      im.turms.turms.pojo.bo.signal.Acknowledge parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (im.turms.turms.pojo.bo.signal.Acknowledge) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private long deliveryDate_ ;
    /**
     * <code>int64 delivery_date = 1;</code>
     * @return The deliveryDate.
     */
    public long getDeliveryDate() {
      return deliveryDate_;
    }
    /**
     * <code>int64 delivery_date = 1;</code>
     * @param value The deliveryDate to set.
     * @return This builder for chaining.
     */
    public Builder setDeliveryDate(long value) {
      
      deliveryDate_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 delivery_date = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearDeliveryDate() {
      
      deliveryDate_ = 0L;
      onChanged();
      return this;
    }

    private com.google.protobuf.Int64Value messageId_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Int64Value, com.google.protobuf.Int64Value.Builder, com.google.protobuf.Int64ValueOrBuilder> messageIdBuilder_;
    /**
     * <code>.google.protobuf.Int64Value message_id = 2;</code>
     * @return Whether the messageId field is set.
     */
    public boolean hasMessageId() {
      return messageIdBuilder_ != null || messageId_ != null;
    }
    /**
     * <code>.google.protobuf.Int64Value message_id = 2;</code>
     * @return The messageId.
     */
    public com.google.protobuf.Int64Value getMessageId() {
      if (messageIdBuilder_ == null) {
        return messageId_ == null ? com.google.protobuf.Int64Value.getDefaultInstance() : messageId_;
      } else {
        return messageIdBuilder_.getMessage();
      }
    }
    /**
     * <code>.google.protobuf.Int64Value message_id = 2;</code>
     */
    public Builder setMessageId(com.google.protobuf.Int64Value value) {
      if (messageIdBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        messageId_ = value;
        onChanged();
      } else {
        messageIdBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Int64Value message_id = 2;</code>
     */
    public Builder setMessageId(
        com.google.protobuf.Int64Value.Builder builderForValue) {
      if (messageIdBuilder_ == null) {
        messageId_ = builderForValue.build();
        onChanged();
      } else {
        messageIdBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Int64Value message_id = 2;</code>
     */
    public Builder mergeMessageId(com.google.protobuf.Int64Value value) {
      if (messageIdBuilder_ == null) {
        if (messageId_ != null) {
          messageId_ =
            com.google.protobuf.Int64Value.newBuilder(messageId_).mergeFrom(value).buildPartial();
        } else {
          messageId_ = value;
        }
        onChanged();
      } else {
        messageIdBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Int64Value message_id = 2;</code>
     */
    public Builder clearMessageId() {
      if (messageIdBuilder_ == null) {
        messageId_ = null;
        onChanged();
      } else {
        messageId_ = null;
        messageIdBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Int64Value message_id = 2;</code>
     */
    public com.google.protobuf.Int64Value.Builder getMessageIdBuilder() {
      
      onChanged();
      return getMessageIdFieldBuilder().getBuilder();
    }
    /**
     * <code>.google.protobuf.Int64Value message_id = 2;</code>
     */
    public com.google.protobuf.Int64ValueOrBuilder getMessageIdOrBuilder() {
      if (messageIdBuilder_ != null) {
        return messageIdBuilder_.getMessageOrBuilder();
      } else {
        return messageId_ == null ?
            com.google.protobuf.Int64Value.getDefaultInstance() : messageId_;
      }
    }
    /**
     * <code>.google.protobuf.Int64Value message_id = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Int64Value, com.google.protobuf.Int64Value.Builder, com.google.protobuf.Int64ValueOrBuilder> 
        getMessageIdFieldBuilder() {
      if (messageIdBuilder_ == null) {
        messageIdBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.protobuf.Int64Value, com.google.protobuf.Int64Value.Builder, com.google.protobuf.Int64ValueOrBuilder>(
                getMessageId(),
                getParentForChildren(),
                isClean());
        messageId_ = null;
      }
      return messageIdBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:im.turms.proto.Acknowledge)
  }

  // @@protoc_insertion_point(class_scope:im.turms.proto.Acknowledge)
  private static final im.turms.turms.pojo.bo.signal.Acknowledge DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new im.turms.turms.pojo.bo.signal.Acknowledge();
  }

  public static im.turms.turms.pojo.bo.signal.Acknowledge getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Acknowledge>
      PARSER = new com.google.protobuf.AbstractParser<Acknowledge>() {
    @java.lang.Override
    public Acknowledge parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Acknowledge(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Acknowledge> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Acknowledge> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public im.turms.turms.pojo.bo.signal.Acknowledge getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

