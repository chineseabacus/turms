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
// source: request/user/relationship/update_relationship_request.proto

package im.turms.common.model.dto.request.user.relationship;

/**
 * Protobuf type {@code im.turms.proto.UpdateRelationshipRequest}
 */
public final class UpdateRelationshipRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:im.turms.proto.UpdateRelationshipRequest)
    UpdateRelationshipRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use UpdateRelationshipRequest.newBuilder() to construct.
  private UpdateRelationshipRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UpdateRelationshipRequest() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new UpdateRelationshipRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private UpdateRelationshipRequest(
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

            userId_ = input.readInt64();
            break;
          }
          case 18: {
            com.google.protobuf.BoolValue.Builder subBuilder = null;
            if (blocked_ != null) {
              subBuilder = blocked_.toBuilder();
            }
            blocked_ = input.readMessage(com.google.protobuf.BoolValue.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(blocked_);
              blocked_ = subBuilder.buildPartial();
            }

            break;
          }
          case 26: {
            com.google.protobuf.Int32Value.Builder subBuilder = null;
            if (newGroupIndex_ != null) {
              subBuilder = newGroupIndex_.toBuilder();
            }
            newGroupIndex_ = input.readMessage(com.google.protobuf.Int32Value.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(newGroupIndex_);
              newGroupIndex_ = subBuilder.buildPartial();
            }

            break;
          }
          case 34: {
            com.google.protobuf.Int32Value.Builder subBuilder = null;
            if (deleteGroupIndex_ != null) {
              subBuilder = deleteGroupIndex_.toBuilder();
            }
            deleteGroupIndex_ = input.readMessage(com.google.protobuf.Int32Value.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(deleteGroupIndex_);
              deleteGroupIndex_ = subBuilder.buildPartial();
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
    return im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequestOuterClass.internal_static_im_turms_proto_UpdateRelationshipRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequestOuterClass.internal_static_im_turms_proto_UpdateRelationshipRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequest.class, im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequest.Builder.class);
  }

  public static final int USER_ID_FIELD_NUMBER = 1;
  private long userId_;
  /**
   * <code>int64 user_id = 1;</code>
   * @return The userId.
   */
  @java.lang.Override
  public long getUserId() {
    return userId_;
  }

  public static final int BLOCKED_FIELD_NUMBER = 2;
  private com.google.protobuf.BoolValue blocked_;
  /**
   * <code>.google.protobuf.BoolValue blocked = 2;</code>
   * @return Whether the blocked field is set.
   */
  @java.lang.Override
  public boolean hasBlocked() {
    return blocked_ != null;
  }
  /**
   * <code>.google.protobuf.BoolValue blocked = 2;</code>
   * @return The blocked.
   */
  @java.lang.Override
  public com.google.protobuf.BoolValue getBlocked() {
    return blocked_ == null ? com.google.protobuf.BoolValue.getDefaultInstance() : blocked_;
  }
  /**
   * <code>.google.protobuf.BoolValue blocked = 2;</code>
   */
  @java.lang.Override
  public com.google.protobuf.BoolValueOrBuilder getBlockedOrBuilder() {
    return getBlocked();
  }

  public static final int NEW_GROUP_INDEX_FIELD_NUMBER = 3;
  private com.google.protobuf.Int32Value newGroupIndex_;
  /**
   * <code>.google.protobuf.Int32Value new_group_index = 3;</code>
   * @return Whether the newGroupIndex field is set.
   */
  @java.lang.Override
  public boolean hasNewGroupIndex() {
    return newGroupIndex_ != null;
  }
  /**
   * <code>.google.protobuf.Int32Value new_group_index = 3;</code>
   * @return The newGroupIndex.
   */
  @java.lang.Override
  public com.google.protobuf.Int32Value getNewGroupIndex() {
    return newGroupIndex_ == null ? com.google.protobuf.Int32Value.getDefaultInstance() : newGroupIndex_;
  }
  /**
   * <code>.google.protobuf.Int32Value new_group_index = 3;</code>
   */
  @java.lang.Override
  public com.google.protobuf.Int32ValueOrBuilder getNewGroupIndexOrBuilder() {
    return getNewGroupIndex();
  }

  public static final int DELETE_GROUP_INDEX_FIELD_NUMBER = 4;
  private com.google.protobuf.Int32Value deleteGroupIndex_;
  /**
   * <code>.google.protobuf.Int32Value delete_group_index = 4;</code>
   * @return Whether the deleteGroupIndex field is set.
   */
  @java.lang.Override
  public boolean hasDeleteGroupIndex() {
    return deleteGroupIndex_ != null;
  }
  /**
   * <code>.google.protobuf.Int32Value delete_group_index = 4;</code>
   * @return The deleteGroupIndex.
   */
  @java.lang.Override
  public com.google.protobuf.Int32Value getDeleteGroupIndex() {
    return deleteGroupIndex_ == null ? com.google.protobuf.Int32Value.getDefaultInstance() : deleteGroupIndex_;
  }
  /**
   * <code>.google.protobuf.Int32Value delete_group_index = 4;</code>
   */
  @java.lang.Override
  public com.google.protobuf.Int32ValueOrBuilder getDeleteGroupIndexOrBuilder() {
    return getDeleteGroupIndex();
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
    if (userId_ != 0L) {
      output.writeInt64(1, userId_);
    }
    if (blocked_ != null) {
      output.writeMessage(2, getBlocked());
    }
    if (newGroupIndex_ != null) {
      output.writeMessage(3, getNewGroupIndex());
    }
    if (deleteGroupIndex_ != null) {
      output.writeMessage(4, getDeleteGroupIndex());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (userId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, userId_);
    }
    if (blocked_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getBlocked());
    }
    if (newGroupIndex_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getNewGroupIndex());
    }
    if (deleteGroupIndex_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(4, getDeleteGroupIndex());
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
    if (!(obj instanceof im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequest)) {
      return super.equals(obj);
    }
    im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequest other = (im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequest) obj;

    if (getUserId()
        != other.getUserId()) return false;
    if (hasBlocked() != other.hasBlocked()) return false;
    if (hasBlocked()) {
      if (!getBlocked()
          .equals(other.getBlocked())) return false;
    }
    if (hasNewGroupIndex() != other.hasNewGroupIndex()) return false;
    if (hasNewGroupIndex()) {
      if (!getNewGroupIndex()
          .equals(other.getNewGroupIndex())) return false;
    }
    if (hasDeleteGroupIndex() != other.hasDeleteGroupIndex()) return false;
    if (hasDeleteGroupIndex()) {
      if (!getDeleteGroupIndex()
          .equals(other.getDeleteGroupIndex())) return false;
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
    hash = (37 * hash) + USER_ID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getUserId());
    if (hasBlocked()) {
      hash = (37 * hash) + BLOCKED_FIELD_NUMBER;
      hash = (53 * hash) + getBlocked().hashCode();
    }
    if (hasNewGroupIndex()) {
      hash = (37 * hash) + NEW_GROUP_INDEX_FIELD_NUMBER;
      hash = (53 * hash) + getNewGroupIndex().hashCode();
    }
    if (hasDeleteGroupIndex()) {
      hash = (37 * hash) + DELETE_GROUP_INDEX_FIELD_NUMBER;
      hash = (53 * hash) + getDeleteGroupIndex().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequest parseFrom(
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
  public static Builder newBuilder(im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequest prototype) {
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
   * Protobuf type {@code im.turms.proto.UpdateRelationshipRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:im.turms.proto.UpdateRelationshipRequest)
      im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequestOuterClass.internal_static_im_turms_proto_UpdateRelationshipRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequestOuterClass.internal_static_im_turms_proto_UpdateRelationshipRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequest.class, im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequest.Builder.class);
    }

    // Construct using im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequest.newBuilder()
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
      userId_ = 0L;

      if (blockedBuilder_ == null) {
        blocked_ = null;
      } else {
        blocked_ = null;
        blockedBuilder_ = null;
      }
      if (newGroupIndexBuilder_ == null) {
        newGroupIndex_ = null;
      } else {
        newGroupIndex_ = null;
        newGroupIndexBuilder_ = null;
      }
      if (deleteGroupIndexBuilder_ == null) {
        deleteGroupIndex_ = null;
      } else {
        deleteGroupIndex_ = null;
        deleteGroupIndexBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequestOuterClass.internal_static_im_turms_proto_UpdateRelationshipRequest_descriptor;
    }

    @java.lang.Override
    public im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequest getDefaultInstanceForType() {
      return im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequest.getDefaultInstance();
    }

    @java.lang.Override
    public im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequest build() {
      im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequest buildPartial() {
      im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequest result = new im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequest(this);
      result.userId_ = userId_;
      if (blockedBuilder_ == null) {
        result.blocked_ = blocked_;
      } else {
        result.blocked_ = blockedBuilder_.build();
      }
      if (newGroupIndexBuilder_ == null) {
        result.newGroupIndex_ = newGroupIndex_;
      } else {
        result.newGroupIndex_ = newGroupIndexBuilder_.build();
      }
      if (deleteGroupIndexBuilder_ == null) {
        result.deleteGroupIndex_ = deleteGroupIndex_;
      } else {
        result.deleteGroupIndex_ = deleteGroupIndexBuilder_.build();
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
      if (other instanceof im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequest) {
        return mergeFrom((im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequest other) {
      if (other == im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequest.getDefaultInstance()) return this;
      if (other.getUserId() != 0L) {
        setUserId(other.getUserId());
      }
      if (other.hasBlocked()) {
        mergeBlocked(other.getBlocked());
      }
      if (other.hasNewGroupIndex()) {
        mergeNewGroupIndex(other.getNewGroupIndex());
      }
      if (other.hasDeleteGroupIndex()) {
        mergeDeleteGroupIndex(other.getDeleteGroupIndex());
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
      im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private long userId_ ;
    /**
     * <code>int64 user_id = 1;</code>
     * @return The userId.
     */
    @java.lang.Override
    public long getUserId() {
      return userId_;
    }
    /**
     * <code>int64 user_id = 1;</code>
     * @param value The userId to set.
     * @return This builder for chaining.
     */
    public Builder setUserId(long value) {

      userId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 user_id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearUserId() {

      userId_ = 0L;
      onChanged();
      return this;
    }

    private com.google.protobuf.BoolValue blocked_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.BoolValue, com.google.protobuf.BoolValue.Builder, com.google.protobuf.BoolValueOrBuilder> blockedBuilder_;
    /**
     * <code>.google.protobuf.BoolValue blocked = 2;</code>
     * @return Whether the blocked field is set.
     */
    public boolean hasBlocked() {
      return blockedBuilder_ != null || blocked_ != null;
    }
    /**
     * <code>.google.protobuf.BoolValue blocked = 2;</code>
     * @return The blocked.
     */
    public com.google.protobuf.BoolValue getBlocked() {
      if (blockedBuilder_ == null) {
        return blocked_ == null ? com.google.protobuf.BoolValue.getDefaultInstance() : blocked_;
      } else {
        return blockedBuilder_.getMessage();
      }
    }
    /**
     * <code>.google.protobuf.BoolValue blocked = 2;</code>
     */
    public Builder setBlocked(com.google.protobuf.BoolValue value) {
      if (blockedBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        blocked_ = value;
        onChanged();
      } else {
        blockedBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.google.protobuf.BoolValue blocked = 2;</code>
     */
    public Builder setBlocked(
        com.google.protobuf.BoolValue.Builder builderForValue) {
      if (blockedBuilder_ == null) {
        blocked_ = builderForValue.build();
        onChanged();
      } else {
        blockedBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.google.protobuf.BoolValue blocked = 2;</code>
     */
    public Builder mergeBlocked(com.google.protobuf.BoolValue value) {
      if (blockedBuilder_ == null) {
        if (blocked_ != null) {
          blocked_ =
            com.google.protobuf.BoolValue.newBuilder(blocked_).mergeFrom(value).buildPartial();
        } else {
          blocked_ = value;
        }
        onChanged();
      } else {
        blockedBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.google.protobuf.BoolValue blocked = 2;</code>
     */
    public Builder clearBlocked() {
      if (blockedBuilder_ == null) {
        blocked_ = null;
        onChanged();
      } else {
        blocked_ = null;
        blockedBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.google.protobuf.BoolValue blocked = 2;</code>
     */
    public com.google.protobuf.BoolValue.Builder getBlockedBuilder() {

      onChanged();
      return getBlockedFieldBuilder().getBuilder();
    }
    /**
     * <code>.google.protobuf.BoolValue blocked = 2;</code>
     */
    public com.google.protobuf.BoolValueOrBuilder getBlockedOrBuilder() {
      if (blockedBuilder_ != null) {
        return blockedBuilder_.getMessageOrBuilder();
      } else {
        return blocked_ == null ?
            com.google.protobuf.BoolValue.getDefaultInstance() : blocked_;
      }
    }
    /**
     * <code>.google.protobuf.BoolValue blocked = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.BoolValue, com.google.protobuf.BoolValue.Builder, com.google.protobuf.BoolValueOrBuilder>
        getBlockedFieldBuilder() {
      if (blockedBuilder_ == null) {
        blockedBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.protobuf.BoolValue, com.google.protobuf.BoolValue.Builder, com.google.protobuf.BoolValueOrBuilder>(
                getBlocked(),
                getParentForChildren(),
                isClean());
        blocked_ = null;
      }
      return blockedBuilder_;
    }

    private com.google.protobuf.Int32Value newGroupIndex_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Int32Value, com.google.protobuf.Int32Value.Builder, com.google.protobuf.Int32ValueOrBuilder> newGroupIndexBuilder_;
    /**
     * <code>.google.protobuf.Int32Value new_group_index = 3;</code>
     * @return Whether the newGroupIndex field is set.
     */
    public boolean hasNewGroupIndex() {
      return newGroupIndexBuilder_ != null || newGroupIndex_ != null;
    }
    /**
     * <code>.google.protobuf.Int32Value new_group_index = 3;</code>
     * @return The newGroupIndex.
     */
    public com.google.protobuf.Int32Value getNewGroupIndex() {
      if (newGroupIndexBuilder_ == null) {
        return newGroupIndex_ == null ? com.google.protobuf.Int32Value.getDefaultInstance() : newGroupIndex_;
      } else {
        return newGroupIndexBuilder_.getMessage();
      }
    }
    /**
     * <code>.google.protobuf.Int32Value new_group_index = 3;</code>
     */
    public Builder setNewGroupIndex(com.google.protobuf.Int32Value value) {
      if (newGroupIndexBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        newGroupIndex_ = value;
        onChanged();
      } else {
        newGroupIndexBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Int32Value new_group_index = 3;</code>
     */
    public Builder setNewGroupIndex(
        com.google.protobuf.Int32Value.Builder builderForValue) {
      if (newGroupIndexBuilder_ == null) {
        newGroupIndex_ = builderForValue.build();
        onChanged();
      } else {
        newGroupIndexBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Int32Value new_group_index = 3;</code>
     */
    public Builder mergeNewGroupIndex(com.google.protobuf.Int32Value value) {
      if (newGroupIndexBuilder_ == null) {
        if (newGroupIndex_ != null) {
          newGroupIndex_ =
            com.google.protobuf.Int32Value.newBuilder(newGroupIndex_).mergeFrom(value).buildPartial();
        } else {
          newGroupIndex_ = value;
        }
        onChanged();
      } else {
        newGroupIndexBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Int32Value new_group_index = 3;</code>
     */
    public Builder clearNewGroupIndex() {
      if (newGroupIndexBuilder_ == null) {
        newGroupIndex_ = null;
        onChanged();
      } else {
        newGroupIndex_ = null;
        newGroupIndexBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Int32Value new_group_index = 3;</code>
     */
    public com.google.protobuf.Int32Value.Builder getNewGroupIndexBuilder() {

      onChanged();
      return getNewGroupIndexFieldBuilder().getBuilder();
    }
    /**
     * <code>.google.protobuf.Int32Value new_group_index = 3;</code>
     */
    public com.google.protobuf.Int32ValueOrBuilder getNewGroupIndexOrBuilder() {
      if (newGroupIndexBuilder_ != null) {
        return newGroupIndexBuilder_.getMessageOrBuilder();
      } else {
        return newGroupIndex_ == null ?
            com.google.protobuf.Int32Value.getDefaultInstance() : newGroupIndex_;
      }
    }
    /**
     * <code>.google.protobuf.Int32Value new_group_index = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Int32Value, com.google.protobuf.Int32Value.Builder, com.google.protobuf.Int32ValueOrBuilder>
        getNewGroupIndexFieldBuilder() {
      if (newGroupIndexBuilder_ == null) {
        newGroupIndexBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.protobuf.Int32Value, com.google.protobuf.Int32Value.Builder, com.google.protobuf.Int32ValueOrBuilder>(
                getNewGroupIndex(),
                getParentForChildren(),
                isClean());
        newGroupIndex_ = null;
      }
      return newGroupIndexBuilder_;
    }

    private com.google.protobuf.Int32Value deleteGroupIndex_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Int32Value, com.google.protobuf.Int32Value.Builder, com.google.protobuf.Int32ValueOrBuilder> deleteGroupIndexBuilder_;
    /**
     * <code>.google.protobuf.Int32Value delete_group_index = 4;</code>
     * @return Whether the deleteGroupIndex field is set.
     */
    public boolean hasDeleteGroupIndex() {
      return deleteGroupIndexBuilder_ != null || deleteGroupIndex_ != null;
    }
    /**
     * <code>.google.protobuf.Int32Value delete_group_index = 4;</code>
     * @return The deleteGroupIndex.
     */
    public com.google.protobuf.Int32Value getDeleteGroupIndex() {
      if (deleteGroupIndexBuilder_ == null) {
        return deleteGroupIndex_ == null ? com.google.protobuf.Int32Value.getDefaultInstance() : deleteGroupIndex_;
      } else {
        return deleteGroupIndexBuilder_.getMessage();
      }
    }
    /**
     * <code>.google.protobuf.Int32Value delete_group_index = 4;</code>
     */
    public Builder setDeleteGroupIndex(com.google.protobuf.Int32Value value) {
      if (deleteGroupIndexBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        deleteGroupIndex_ = value;
        onChanged();
      } else {
        deleteGroupIndexBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Int32Value delete_group_index = 4;</code>
     */
    public Builder setDeleteGroupIndex(
        com.google.protobuf.Int32Value.Builder builderForValue) {
      if (deleteGroupIndexBuilder_ == null) {
        deleteGroupIndex_ = builderForValue.build();
        onChanged();
      } else {
        deleteGroupIndexBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Int32Value delete_group_index = 4;</code>
     */
    public Builder mergeDeleteGroupIndex(com.google.protobuf.Int32Value value) {
      if (deleteGroupIndexBuilder_ == null) {
        if (deleteGroupIndex_ != null) {
          deleteGroupIndex_ =
            com.google.protobuf.Int32Value.newBuilder(deleteGroupIndex_).mergeFrom(value).buildPartial();
        } else {
          deleteGroupIndex_ = value;
        }
        onChanged();
      } else {
        deleteGroupIndexBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Int32Value delete_group_index = 4;</code>
     */
    public Builder clearDeleteGroupIndex() {
      if (deleteGroupIndexBuilder_ == null) {
        deleteGroupIndex_ = null;
        onChanged();
      } else {
        deleteGroupIndex_ = null;
        deleteGroupIndexBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Int32Value delete_group_index = 4;</code>
     */
    public com.google.protobuf.Int32Value.Builder getDeleteGroupIndexBuilder() {

      onChanged();
      return getDeleteGroupIndexFieldBuilder().getBuilder();
    }
    /**
     * <code>.google.protobuf.Int32Value delete_group_index = 4;</code>
     */
    public com.google.protobuf.Int32ValueOrBuilder getDeleteGroupIndexOrBuilder() {
      if (deleteGroupIndexBuilder_ != null) {
        return deleteGroupIndexBuilder_.getMessageOrBuilder();
      } else {
        return deleteGroupIndex_ == null ?
            com.google.protobuf.Int32Value.getDefaultInstance() : deleteGroupIndex_;
      }
    }
    /**
     * <code>.google.protobuf.Int32Value delete_group_index = 4;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Int32Value, com.google.protobuf.Int32Value.Builder, com.google.protobuf.Int32ValueOrBuilder>
        getDeleteGroupIndexFieldBuilder() {
      if (deleteGroupIndexBuilder_ == null) {
        deleteGroupIndexBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.protobuf.Int32Value, com.google.protobuf.Int32Value.Builder, com.google.protobuf.Int32ValueOrBuilder>(
                getDeleteGroupIndex(),
                getParentForChildren(),
                isClean());
        deleteGroupIndex_ = null;
      }
      return deleteGroupIndexBuilder_;
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


    // @@protoc_insertion_point(builder_scope:im.turms.proto.UpdateRelationshipRequest)
  }

  // @@protoc_insertion_point(class_scope:im.turms.proto.UpdateRelationshipRequest)
  private static final im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequest();
  }

  public static im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UpdateRelationshipRequest>
      PARSER = new com.google.protobuf.AbstractParser<UpdateRelationshipRequest>() {
    @java.lang.Override
    public UpdateRelationshipRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new UpdateRelationshipRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<UpdateRelationshipRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<UpdateRelationshipRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public im.turms.common.model.dto.request.user.relationship.UpdateRelationshipRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

