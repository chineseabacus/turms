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

// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: request/group/blacklist/create_group_blacklisted_user_request.proto

package im.turms.common.model.dto.request.group.blacklist;

/**
 * Protobuf type {@code im.turms.proto.CreateGroupBlacklistedUserRequest}
 */
public  final class CreateGroupBlacklistedUserRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:im.turms.proto.CreateGroupBlacklistedUserRequest)
    CreateGroupBlacklistedUserRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use CreateGroupBlacklistedUserRequest.newBuilder() to construct.
  private CreateGroupBlacklistedUserRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CreateGroupBlacklistedUserRequest() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new CreateGroupBlacklistedUserRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private CreateGroupBlacklistedUserRequest(
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

            groupId_ = input.readInt64();
            break;
          }
          case 16: {

            blacklistedUserId_ = input.readInt64();
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
    return CreateGroupBlacklistedUserRequestOuterClass.internal_static_im_turms_proto_CreateGroupBlacklistedUserRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return CreateGroupBlacklistedUserRequestOuterClass.internal_static_im_turms_proto_CreateGroupBlacklistedUserRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            CreateGroupBlacklistedUserRequest.class, CreateGroupBlacklistedUserRequest.Builder.class);
  }

  public static final int GROUP_ID_FIELD_NUMBER = 1;
  private long groupId_;
  /**
   * <code>int64 group_id = 1;</code>
   * @return The groupId.
   */
  public long getGroupId() {
    return groupId_;
  }

  public static final int BLACKLISTED_USER_ID_FIELD_NUMBER = 2;
  private long blacklistedUserId_;
  /**
   * <code>int64 blacklisted_user_id = 2;</code>
   * @return The blacklistedUserId.
   */
  public long getBlacklistedUserId() {
    return blacklistedUserId_;
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
    if (groupId_ != 0L) {
      output.writeInt64(1, groupId_);
    }
    if (blacklistedUserId_ != 0L) {
      output.writeInt64(2, blacklistedUserId_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (groupId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, groupId_);
    }
    if (blacklistedUserId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, blacklistedUserId_);
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
    if (!(obj instanceof CreateGroupBlacklistedUserRequest)) {
      return super.equals(obj);
    }
    CreateGroupBlacklistedUserRequest other = (CreateGroupBlacklistedUserRequest) obj;

    if (getGroupId()
        != other.getGroupId()) return false;
    if (getBlacklistedUserId()
        != other.getBlacklistedUserId()) return false;
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
    hash = (37 * hash) + GROUP_ID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getGroupId());
    hash = (37 * hash) + BLACKLISTED_USER_ID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getBlacklistedUserId());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static CreateGroupBlacklistedUserRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static CreateGroupBlacklistedUserRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static CreateGroupBlacklistedUserRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static CreateGroupBlacklistedUserRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static CreateGroupBlacklistedUserRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static CreateGroupBlacklistedUserRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static CreateGroupBlacklistedUserRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static CreateGroupBlacklistedUserRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static CreateGroupBlacklistedUserRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static CreateGroupBlacklistedUserRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static CreateGroupBlacklistedUserRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static CreateGroupBlacklistedUserRequest parseFrom(
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
  public static Builder newBuilder(CreateGroupBlacklistedUserRequest prototype) {
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
   * Protobuf type {@code im.turms.proto.CreateGroupBlacklistedUserRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:im.turms.proto.CreateGroupBlacklistedUserRequest)
          CreateGroupBlacklistedUserRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return CreateGroupBlacklistedUserRequestOuterClass.internal_static_im_turms_proto_CreateGroupBlacklistedUserRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return CreateGroupBlacklistedUserRequestOuterClass.internal_static_im_turms_proto_CreateGroupBlacklistedUserRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              CreateGroupBlacklistedUserRequest.class, CreateGroupBlacklistedUserRequest.Builder.class);
    }

    // Construct using im.turms.common.model.dto.request.group.blacklist.CreateGroupBlacklistedUserRequest.newBuilder()
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
      groupId_ = 0L;

      blacklistedUserId_ = 0L;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return CreateGroupBlacklistedUserRequestOuterClass.internal_static_im_turms_proto_CreateGroupBlacklistedUserRequest_descriptor;
    }

    @java.lang.Override
    public CreateGroupBlacklistedUserRequest getDefaultInstanceForType() {
      return CreateGroupBlacklistedUserRequest.getDefaultInstance();
    }

    @java.lang.Override
    public CreateGroupBlacklistedUserRequest build() {
      CreateGroupBlacklistedUserRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public CreateGroupBlacklistedUserRequest buildPartial() {
      CreateGroupBlacklistedUserRequest result = new CreateGroupBlacklistedUserRequest(this);
      result.groupId_ = groupId_;
      result.blacklistedUserId_ = blacklistedUserId_;
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
      if (other instanceof CreateGroupBlacklistedUserRequest) {
        return mergeFrom((CreateGroupBlacklistedUserRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(CreateGroupBlacklistedUserRequest other) {
      if (other == CreateGroupBlacklistedUserRequest.getDefaultInstance()) return this;
      if (other.getGroupId() != 0L) {
        setGroupId(other.getGroupId());
      }
      if (other.getBlacklistedUserId() != 0L) {
        setBlacklistedUserId(other.getBlacklistedUserId());
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
      CreateGroupBlacklistedUserRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (CreateGroupBlacklistedUserRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private long groupId_ ;
    /**
     * <code>int64 group_id = 1;</code>
     * @return The groupId.
     */
    public long getGroupId() {
      return groupId_;
    }
    /**
     * <code>int64 group_id = 1;</code>
     * @param value The groupId to set.
     * @return This builder for chaining.
     */
    public Builder setGroupId(long value) {
      
      groupId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 group_id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearGroupId() {
      
      groupId_ = 0L;
      onChanged();
      return this;
    }

    private long blacklistedUserId_ ;
    /**
     * <code>int64 blacklisted_user_id = 2;</code>
     * @return The blacklistedUserId.
     */
    public long getBlacklistedUserId() {
      return blacklistedUserId_;
    }
    /**
     * <code>int64 blacklisted_user_id = 2;</code>
     * @param value The blacklistedUserId to set.
     * @return This builder for chaining.
     */
    public Builder setBlacklistedUserId(long value) {
      
      blacklistedUserId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 blacklisted_user_id = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearBlacklistedUserId() {
      
      blacklistedUserId_ = 0L;
      onChanged();
      return this;
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


    // @@protoc_insertion_point(builder_scope:im.turms.proto.CreateGroupBlacklistedUserRequest)
  }

  // @@protoc_insertion_point(class_scope:im.turms.proto.CreateGroupBlacklistedUserRequest)
  private static final CreateGroupBlacklistedUserRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new CreateGroupBlacklistedUserRequest();
  }

  public static CreateGroupBlacklistedUserRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CreateGroupBlacklistedUserRequest>
      PARSER = new com.google.protobuf.AbstractParser<CreateGroupBlacklistedUserRequest>() {
    @java.lang.Override
    public CreateGroupBlacklistedUserRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new CreateGroupBlacklistedUserRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<CreateGroupBlacklistedUserRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CreateGroupBlacklistedUserRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public CreateGroupBlacklistedUserRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

