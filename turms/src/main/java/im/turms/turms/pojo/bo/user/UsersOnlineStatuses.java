// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: model/user/users_online_statuses.proto

package im.turms.turms.pojo.bo.user;

/**
 * Protobuf type {@code im.turms.proto.UsersOnlineStatuses}
 */
public  final class UsersOnlineStatuses extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:im.turms.proto.UsersOnlineStatuses)
    UsersOnlineStatusesOrBuilder {
private static final long serialVersionUID = 0L;
  // Use UsersOnlineStatuses.newBuilder() to construct.
  private UsersOnlineStatuses(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UsersOnlineStatuses() {
    userStatuses_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new UsersOnlineStatuses();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private UsersOnlineStatuses(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
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
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              userStatuses_ = new java.util.ArrayList<im.turms.turms.pojo.bo.user.UserStatusDetail>();
              mutable_bitField0_ |= 0x00000001;
            }
            userStatuses_.add(
                input.readMessage(im.turms.turms.pojo.bo.user.UserStatusDetail.parser(), extensionRegistry));
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
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        userStatuses_ = java.util.Collections.unmodifiableList(userStatuses_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return im.turms.turms.pojo.bo.user.UsersOnlineStatusesOuterClass.internal_static_im_turms_proto_UsersOnlineStatuses_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return im.turms.turms.pojo.bo.user.UsersOnlineStatusesOuterClass.internal_static_im_turms_proto_UsersOnlineStatuses_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            im.turms.turms.pojo.bo.user.UsersOnlineStatuses.class, im.turms.turms.pojo.bo.user.UsersOnlineStatuses.Builder.class);
  }

  public static final int USER_STATUSES_FIELD_NUMBER = 1;
  private java.util.List<im.turms.turms.pojo.bo.user.UserStatusDetail> userStatuses_;
  /**
   * <code>repeated .im.turms.proto.UserStatusDetail user_statuses = 1;</code>
   */
  public java.util.List<im.turms.turms.pojo.bo.user.UserStatusDetail> getUserStatusesList() {
    return userStatuses_;
  }
  /**
   * <code>repeated .im.turms.proto.UserStatusDetail user_statuses = 1;</code>
   */
  public java.util.List<? extends im.turms.turms.pojo.bo.user.UserStatusDetailOrBuilder> 
      getUserStatusesOrBuilderList() {
    return userStatuses_;
  }
  /**
   * <code>repeated .im.turms.proto.UserStatusDetail user_statuses = 1;</code>
   */
  public int getUserStatusesCount() {
    return userStatuses_.size();
  }
  /**
   * <code>repeated .im.turms.proto.UserStatusDetail user_statuses = 1;</code>
   */
  public im.turms.turms.pojo.bo.user.UserStatusDetail getUserStatuses(int index) {
    return userStatuses_.get(index);
  }
  /**
   * <code>repeated .im.turms.proto.UserStatusDetail user_statuses = 1;</code>
   */
  public im.turms.turms.pojo.bo.user.UserStatusDetailOrBuilder getUserStatusesOrBuilder(
      int index) {
    return userStatuses_.get(index);
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
    for (int i = 0; i < userStatuses_.size(); i++) {
      output.writeMessage(1, userStatuses_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < userStatuses_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, userStatuses_.get(i));
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
    if (!(obj instanceof im.turms.turms.pojo.bo.user.UsersOnlineStatuses)) {
      return super.equals(obj);
    }
    im.turms.turms.pojo.bo.user.UsersOnlineStatuses other = (im.turms.turms.pojo.bo.user.UsersOnlineStatuses) obj;

    if (!getUserStatusesList()
        .equals(other.getUserStatusesList())) return false;
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
    if (getUserStatusesCount() > 0) {
      hash = (37 * hash) + USER_STATUSES_FIELD_NUMBER;
      hash = (53 * hash) + getUserStatusesList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static im.turms.turms.pojo.bo.user.UsersOnlineStatuses parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static im.turms.turms.pojo.bo.user.UsersOnlineStatuses parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static im.turms.turms.pojo.bo.user.UsersOnlineStatuses parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static im.turms.turms.pojo.bo.user.UsersOnlineStatuses parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static im.turms.turms.pojo.bo.user.UsersOnlineStatuses parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static im.turms.turms.pojo.bo.user.UsersOnlineStatuses parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static im.turms.turms.pojo.bo.user.UsersOnlineStatuses parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static im.turms.turms.pojo.bo.user.UsersOnlineStatuses parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static im.turms.turms.pojo.bo.user.UsersOnlineStatuses parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static im.turms.turms.pojo.bo.user.UsersOnlineStatuses parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static im.turms.turms.pojo.bo.user.UsersOnlineStatuses parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static im.turms.turms.pojo.bo.user.UsersOnlineStatuses parseFrom(
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
  public static Builder newBuilder(im.turms.turms.pojo.bo.user.UsersOnlineStatuses prototype) {
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
   * Protobuf type {@code im.turms.proto.UsersOnlineStatuses}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:im.turms.proto.UsersOnlineStatuses)
      im.turms.turms.pojo.bo.user.UsersOnlineStatusesOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return im.turms.turms.pojo.bo.user.UsersOnlineStatusesOuterClass.internal_static_im_turms_proto_UsersOnlineStatuses_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return im.turms.turms.pojo.bo.user.UsersOnlineStatusesOuterClass.internal_static_im_turms_proto_UsersOnlineStatuses_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              im.turms.turms.pojo.bo.user.UsersOnlineStatuses.class, im.turms.turms.pojo.bo.user.UsersOnlineStatuses.Builder.class);
    }

    // Construct using im.turms.turms.pojo.bo.user.UsersOnlineStatuses.newBuilder()
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
        getUserStatusesFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (userStatusesBuilder_ == null) {
        userStatuses_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        userStatusesBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return im.turms.turms.pojo.bo.user.UsersOnlineStatusesOuterClass.internal_static_im_turms_proto_UsersOnlineStatuses_descriptor;
    }

    @java.lang.Override
    public im.turms.turms.pojo.bo.user.UsersOnlineStatuses getDefaultInstanceForType() {
      return im.turms.turms.pojo.bo.user.UsersOnlineStatuses.getDefaultInstance();
    }

    @java.lang.Override
    public im.turms.turms.pojo.bo.user.UsersOnlineStatuses build() {
      im.turms.turms.pojo.bo.user.UsersOnlineStatuses result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public im.turms.turms.pojo.bo.user.UsersOnlineStatuses buildPartial() {
      im.turms.turms.pojo.bo.user.UsersOnlineStatuses result = new im.turms.turms.pojo.bo.user.UsersOnlineStatuses(this);
      int from_bitField0_ = bitField0_;
      if (userStatusesBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          userStatuses_ = java.util.Collections.unmodifiableList(userStatuses_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.userStatuses_ = userStatuses_;
      } else {
        result.userStatuses_ = userStatusesBuilder_.build();
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
      if (other instanceof im.turms.turms.pojo.bo.user.UsersOnlineStatuses) {
        return mergeFrom((im.turms.turms.pojo.bo.user.UsersOnlineStatuses)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(im.turms.turms.pojo.bo.user.UsersOnlineStatuses other) {
      if (other == im.turms.turms.pojo.bo.user.UsersOnlineStatuses.getDefaultInstance()) return this;
      if (userStatusesBuilder_ == null) {
        if (!other.userStatuses_.isEmpty()) {
          if (userStatuses_.isEmpty()) {
            userStatuses_ = other.userStatuses_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureUserStatusesIsMutable();
            userStatuses_.addAll(other.userStatuses_);
          }
          onChanged();
        }
      } else {
        if (!other.userStatuses_.isEmpty()) {
          if (userStatusesBuilder_.isEmpty()) {
            userStatusesBuilder_.dispose();
            userStatusesBuilder_ = null;
            userStatuses_ = other.userStatuses_;
            bitField0_ = (bitField0_ & ~0x00000001);
            userStatusesBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getUserStatusesFieldBuilder() : null;
          } else {
            userStatusesBuilder_.addAllMessages(other.userStatuses_);
          }
        }
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
      im.turms.turms.pojo.bo.user.UsersOnlineStatuses parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (im.turms.turms.pojo.bo.user.UsersOnlineStatuses) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<im.turms.turms.pojo.bo.user.UserStatusDetail> userStatuses_ =
      java.util.Collections.emptyList();
    private void ensureUserStatusesIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        userStatuses_ = new java.util.ArrayList<im.turms.turms.pojo.bo.user.UserStatusDetail>(userStatuses_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        im.turms.turms.pojo.bo.user.UserStatusDetail, im.turms.turms.pojo.bo.user.UserStatusDetail.Builder, im.turms.turms.pojo.bo.user.UserStatusDetailOrBuilder> userStatusesBuilder_;

    /**
     * <code>repeated .im.turms.proto.UserStatusDetail user_statuses = 1;</code>
     */
    public java.util.List<im.turms.turms.pojo.bo.user.UserStatusDetail> getUserStatusesList() {
      if (userStatusesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(userStatuses_);
      } else {
        return userStatusesBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .im.turms.proto.UserStatusDetail user_statuses = 1;</code>
     */
    public int getUserStatusesCount() {
      if (userStatusesBuilder_ == null) {
        return userStatuses_.size();
      } else {
        return userStatusesBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .im.turms.proto.UserStatusDetail user_statuses = 1;</code>
     */
    public im.turms.turms.pojo.bo.user.UserStatusDetail getUserStatuses(int index) {
      if (userStatusesBuilder_ == null) {
        return userStatuses_.get(index);
      } else {
        return userStatusesBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .im.turms.proto.UserStatusDetail user_statuses = 1;</code>
     */
    public Builder setUserStatuses(
        int index, im.turms.turms.pojo.bo.user.UserStatusDetail value) {
      if (userStatusesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureUserStatusesIsMutable();
        userStatuses_.set(index, value);
        onChanged();
      } else {
        userStatusesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .im.turms.proto.UserStatusDetail user_statuses = 1;</code>
     */
    public Builder setUserStatuses(
        int index, im.turms.turms.pojo.bo.user.UserStatusDetail.Builder builderForValue) {
      if (userStatusesBuilder_ == null) {
        ensureUserStatusesIsMutable();
        userStatuses_.set(index, builderForValue.build());
        onChanged();
      } else {
        userStatusesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .im.turms.proto.UserStatusDetail user_statuses = 1;</code>
     */
    public Builder addUserStatuses(im.turms.turms.pojo.bo.user.UserStatusDetail value) {
      if (userStatusesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureUserStatusesIsMutable();
        userStatuses_.add(value);
        onChanged();
      } else {
        userStatusesBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .im.turms.proto.UserStatusDetail user_statuses = 1;</code>
     */
    public Builder addUserStatuses(
        int index, im.turms.turms.pojo.bo.user.UserStatusDetail value) {
      if (userStatusesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureUserStatusesIsMutable();
        userStatuses_.add(index, value);
        onChanged();
      } else {
        userStatusesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .im.turms.proto.UserStatusDetail user_statuses = 1;</code>
     */
    public Builder addUserStatuses(
        im.turms.turms.pojo.bo.user.UserStatusDetail.Builder builderForValue) {
      if (userStatusesBuilder_ == null) {
        ensureUserStatusesIsMutable();
        userStatuses_.add(builderForValue.build());
        onChanged();
      } else {
        userStatusesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .im.turms.proto.UserStatusDetail user_statuses = 1;</code>
     */
    public Builder addUserStatuses(
        int index, im.turms.turms.pojo.bo.user.UserStatusDetail.Builder builderForValue) {
      if (userStatusesBuilder_ == null) {
        ensureUserStatusesIsMutable();
        userStatuses_.add(index, builderForValue.build());
        onChanged();
      } else {
        userStatusesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .im.turms.proto.UserStatusDetail user_statuses = 1;</code>
     */
    public Builder addAllUserStatuses(
        java.lang.Iterable<? extends im.turms.turms.pojo.bo.user.UserStatusDetail> values) {
      if (userStatusesBuilder_ == null) {
        ensureUserStatusesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, userStatuses_);
        onChanged();
      } else {
        userStatusesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .im.turms.proto.UserStatusDetail user_statuses = 1;</code>
     */
    public Builder clearUserStatuses() {
      if (userStatusesBuilder_ == null) {
        userStatuses_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        userStatusesBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .im.turms.proto.UserStatusDetail user_statuses = 1;</code>
     */
    public Builder removeUserStatuses(int index) {
      if (userStatusesBuilder_ == null) {
        ensureUserStatusesIsMutable();
        userStatuses_.remove(index);
        onChanged();
      } else {
        userStatusesBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .im.turms.proto.UserStatusDetail user_statuses = 1;</code>
     */
    public im.turms.turms.pojo.bo.user.UserStatusDetail.Builder getUserStatusesBuilder(
        int index) {
      return getUserStatusesFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .im.turms.proto.UserStatusDetail user_statuses = 1;</code>
     */
    public im.turms.turms.pojo.bo.user.UserStatusDetailOrBuilder getUserStatusesOrBuilder(
        int index) {
      if (userStatusesBuilder_ == null) {
        return userStatuses_.get(index);  } else {
        return userStatusesBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .im.turms.proto.UserStatusDetail user_statuses = 1;</code>
     */
    public java.util.List<? extends im.turms.turms.pojo.bo.user.UserStatusDetailOrBuilder> 
         getUserStatusesOrBuilderList() {
      if (userStatusesBuilder_ != null) {
        return userStatusesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(userStatuses_);
      }
    }
    /**
     * <code>repeated .im.turms.proto.UserStatusDetail user_statuses = 1;</code>
     */
    public im.turms.turms.pojo.bo.user.UserStatusDetail.Builder addUserStatusesBuilder() {
      return getUserStatusesFieldBuilder().addBuilder(
          im.turms.turms.pojo.bo.user.UserStatusDetail.getDefaultInstance());
    }
    /**
     * <code>repeated .im.turms.proto.UserStatusDetail user_statuses = 1;</code>
     */
    public im.turms.turms.pojo.bo.user.UserStatusDetail.Builder addUserStatusesBuilder(
        int index) {
      return getUserStatusesFieldBuilder().addBuilder(
          index, im.turms.turms.pojo.bo.user.UserStatusDetail.getDefaultInstance());
    }
    /**
     * <code>repeated .im.turms.proto.UserStatusDetail user_statuses = 1;</code>
     */
    public java.util.List<im.turms.turms.pojo.bo.user.UserStatusDetail.Builder> 
         getUserStatusesBuilderList() {
      return getUserStatusesFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        im.turms.turms.pojo.bo.user.UserStatusDetail, im.turms.turms.pojo.bo.user.UserStatusDetail.Builder, im.turms.turms.pojo.bo.user.UserStatusDetailOrBuilder> 
        getUserStatusesFieldBuilder() {
      if (userStatusesBuilder_ == null) {
        userStatusesBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            im.turms.turms.pojo.bo.user.UserStatusDetail, im.turms.turms.pojo.bo.user.UserStatusDetail.Builder, im.turms.turms.pojo.bo.user.UserStatusDetailOrBuilder>(
                userStatuses_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        userStatuses_ = null;
      }
      return userStatusesBuilder_;
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


    // @@protoc_insertion_point(builder_scope:im.turms.proto.UsersOnlineStatuses)
  }

  // @@protoc_insertion_point(class_scope:im.turms.proto.UsersOnlineStatuses)
  private static final im.turms.turms.pojo.bo.user.UsersOnlineStatuses DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new im.turms.turms.pojo.bo.user.UsersOnlineStatuses();
  }

  public static im.turms.turms.pojo.bo.user.UsersOnlineStatuses getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UsersOnlineStatuses>
      PARSER = new com.google.protobuf.AbstractParser<UsersOnlineStatuses>() {
    @java.lang.Override
    public UsersOnlineStatuses parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new UsersOnlineStatuses(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<UsersOnlineStatuses> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<UsersOnlineStatuses> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public im.turms.turms.pojo.bo.user.UsersOnlineStatuses getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

