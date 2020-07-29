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
// source: request/storage/delete_resource_request.proto

package im.turms.common.model.dto.request.storage;

import im.turms.common.constant.ContentType;

/**
 * Protobuf type {@code im.turms.proto.DeleteResourceRequest}
 */
public  final class DeleteResourceRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:im.turms.proto.DeleteResourceRequest)
    DeleteResourceRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use DeleteResourceRequest.newBuilder() to construct.
  private DeleteResourceRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private DeleteResourceRequest() {
    contentType_ = 0;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new DeleteResourceRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private DeleteResourceRequest(
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
            int rawValue = input.readEnum();

            contentType_ = rawValue;
            break;
          }
          case 18: {
            com.google.protobuf.StringValue.Builder subBuilder = null;
            if (keyStr_ != null) {
              subBuilder = keyStr_.toBuilder();
            }
            keyStr_ = input.readMessage(com.google.protobuf.StringValue.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(keyStr_);
              keyStr_ = subBuilder.buildPartial();
            }

            break;
          }
          case 26: {
            com.google.protobuf.Int64Value.Builder subBuilder = null;
            if (keyNum_ != null) {
              subBuilder = keyNum_.toBuilder();
            }
            keyNum_ = input.readMessage(com.google.protobuf.Int64Value.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(keyNum_);
              keyNum_ = subBuilder.buildPartial();
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
    return DeleteResourceRequestOuterClass.internal_static_im_turms_proto_DeleteResourceRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return DeleteResourceRequestOuterClass.internal_static_im_turms_proto_DeleteResourceRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            DeleteResourceRequest.class, DeleteResourceRequest.Builder.class);
  }

  public static final int CONTENT_TYPE_FIELD_NUMBER = 1;
  private int contentType_;
  /**
   * <code>.im.turms.proto.ContentType content_type = 1;</code>
   * @return The enum numeric value on the wire for contentType.
   */
  public int getContentTypeValue() {
    return contentType_;
  }
  /**
   * <code>.im.turms.proto.ContentType content_type = 1;</code>
   * @return The contentType.
   */
  public ContentType getContentType() {
    @SuppressWarnings("deprecation")
    ContentType result = ContentType.valueOf(contentType_);
    return result == null ? ContentType.UNRECOGNIZED : result;
  }

  public static final int KEY_STR_FIELD_NUMBER = 2;
  private com.google.protobuf.StringValue keyStr_;
  /**
   * <code>.google.protobuf.StringValue key_str = 2;</code>
   * @return Whether the keyStr field is set.
   */
  public boolean hasKeyStr() {
    return keyStr_ != null;
  }
  /**
   * <code>.google.protobuf.StringValue key_str = 2;</code>
   * @return The keyStr.
   */
  public com.google.protobuf.StringValue getKeyStr() {
    return keyStr_ == null ? com.google.protobuf.StringValue.getDefaultInstance() : keyStr_;
  }
  /**
   * <code>.google.protobuf.StringValue key_str = 2;</code>
   */
  public com.google.protobuf.StringValueOrBuilder getKeyStrOrBuilder() {
    return getKeyStr();
  }

  public static final int KEY_NUM_FIELD_NUMBER = 3;
  private com.google.protobuf.Int64Value keyNum_;
  /**
   * <code>.google.protobuf.Int64Value key_num = 3;</code>
   * @return Whether the keyNum field is set.
   */
  public boolean hasKeyNum() {
    return keyNum_ != null;
  }
  /**
   * <code>.google.protobuf.Int64Value key_num = 3;</code>
   * @return The keyNum.
   */
  public com.google.protobuf.Int64Value getKeyNum() {
    return keyNum_ == null ? com.google.protobuf.Int64Value.getDefaultInstance() : keyNum_;
  }
  /**
   * <code>.google.protobuf.Int64Value key_num = 3;</code>
   */
  public com.google.protobuf.Int64ValueOrBuilder getKeyNumOrBuilder() {
    return getKeyNum();
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
    if (contentType_ != ContentType.PROFILE.getNumber()) {
      output.writeEnum(1, contentType_);
    }
    if (keyStr_ != null) {
      output.writeMessage(2, getKeyStr());
    }
    if (keyNum_ != null) {
      output.writeMessage(3, getKeyNum());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (contentType_ != ContentType.PROFILE.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, contentType_);
    }
    if (keyStr_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getKeyStr());
    }
    if (keyNum_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getKeyNum());
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
    if (!(obj instanceof DeleteResourceRequest)) {
      return super.equals(obj);
    }
    DeleteResourceRequest other = (DeleteResourceRequest) obj;

    if (contentType_ != other.contentType_) return false;
    if (hasKeyStr() != other.hasKeyStr()) return false;
    if (hasKeyStr()) {
      if (!getKeyStr()
          .equals(other.getKeyStr())) return false;
    }
    if (hasKeyNum() != other.hasKeyNum()) return false;
    if (hasKeyNum()) {
      if (!getKeyNum()
          .equals(other.getKeyNum())) return false;
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
    hash = (37 * hash) + CONTENT_TYPE_FIELD_NUMBER;
    hash = (53 * hash) + contentType_;
    if (hasKeyStr()) {
      hash = (37 * hash) + KEY_STR_FIELD_NUMBER;
      hash = (53 * hash) + getKeyStr().hashCode();
    }
    if (hasKeyNum()) {
      hash = (37 * hash) + KEY_NUM_FIELD_NUMBER;
      hash = (53 * hash) + getKeyNum().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static DeleteResourceRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static DeleteResourceRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static DeleteResourceRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static DeleteResourceRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static DeleteResourceRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static DeleteResourceRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static DeleteResourceRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static DeleteResourceRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static DeleteResourceRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static DeleteResourceRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static DeleteResourceRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static DeleteResourceRequest parseFrom(
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
  public static Builder newBuilder(DeleteResourceRequest prototype) {
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
   * Protobuf type {@code im.turms.proto.DeleteResourceRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:im.turms.proto.DeleteResourceRequest)
          DeleteResourceRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return DeleteResourceRequestOuterClass.internal_static_im_turms_proto_DeleteResourceRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return DeleteResourceRequestOuterClass.internal_static_im_turms_proto_DeleteResourceRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              DeleteResourceRequest.class, DeleteResourceRequest.Builder.class);
    }

    // Construct using im.turms.common.model.dto.request.storage.DeleteResourceRequest.newBuilder()
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
      contentType_ = 0;

      if (keyStrBuilder_ == null) {
        keyStr_ = null;
      } else {
        keyStr_ = null;
        keyStrBuilder_ = null;
      }
      if (keyNumBuilder_ == null) {
        keyNum_ = null;
      } else {
        keyNum_ = null;
        keyNumBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return DeleteResourceRequestOuterClass.internal_static_im_turms_proto_DeleteResourceRequest_descriptor;
    }

    @java.lang.Override
    public DeleteResourceRequest getDefaultInstanceForType() {
      return DeleteResourceRequest.getDefaultInstance();
    }

    @java.lang.Override
    public DeleteResourceRequest build() {
      DeleteResourceRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public DeleteResourceRequest buildPartial() {
      DeleteResourceRequest result = new DeleteResourceRequest(this);
      result.contentType_ = contentType_;
      if (keyStrBuilder_ == null) {
        result.keyStr_ = keyStr_;
      } else {
        result.keyStr_ = keyStrBuilder_.build();
      }
      if (keyNumBuilder_ == null) {
        result.keyNum_ = keyNum_;
      } else {
        result.keyNum_ = keyNumBuilder_.build();
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
      if (other instanceof DeleteResourceRequest) {
        return mergeFrom((DeleteResourceRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(DeleteResourceRequest other) {
      if (other == DeleteResourceRequest.getDefaultInstance()) return this;
      if (other.contentType_ != 0) {
        setContentTypeValue(other.getContentTypeValue());
      }
      if (other.hasKeyStr()) {
        mergeKeyStr(other.getKeyStr());
      }
      if (other.hasKeyNum()) {
        mergeKeyNum(other.getKeyNum());
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
      DeleteResourceRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (DeleteResourceRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int contentType_ = 0;
    /**
     * <code>.im.turms.proto.ContentType content_type = 1;</code>
     * @return The enum numeric value on the wire for contentType.
     */
    public int getContentTypeValue() {
      return contentType_;
    }
    /**
     * <code>.im.turms.proto.ContentType content_type = 1;</code>
     * @param value The enum numeric value on the wire for contentType to set.
     * @return This builder for chaining.
     */
    public Builder setContentTypeValue(int value) {
      contentType_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.im.turms.proto.ContentType content_type = 1;</code>
     * @return The contentType.
     */
    public ContentType getContentType() {
      @SuppressWarnings("deprecation")
      ContentType result = ContentType.valueOf(contentType_);
      return result == null ? ContentType.UNRECOGNIZED : result;
    }
    /**
     * <code>.im.turms.proto.ContentType content_type = 1;</code>
     * @param value The contentType to set.
     * @return This builder for chaining.
     */
    public Builder setContentType(ContentType value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      contentType_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.im.turms.proto.ContentType content_type = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearContentType() {
      
      contentType_ = 0;
      onChanged();
      return this;
    }

    private com.google.protobuf.StringValue keyStr_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.StringValue, com.google.protobuf.StringValue.Builder, com.google.protobuf.StringValueOrBuilder> keyStrBuilder_;
    /**
     * <code>.google.protobuf.StringValue key_str = 2;</code>
     * @return Whether the keyStr field is set.
     */
    public boolean hasKeyStr() {
      return keyStrBuilder_ != null || keyStr_ != null;
    }
    /**
     * <code>.google.protobuf.StringValue key_str = 2;</code>
     * @return The keyStr.
     */
    public com.google.protobuf.StringValue getKeyStr() {
      if (keyStrBuilder_ == null) {
        return keyStr_ == null ? com.google.protobuf.StringValue.getDefaultInstance() : keyStr_;
      } else {
        return keyStrBuilder_.getMessage();
      }
    }
    /**
     * <code>.google.protobuf.StringValue key_str = 2;</code>
     */
    public Builder setKeyStr(com.google.protobuf.StringValue value) {
      if (keyStrBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        keyStr_ = value;
        onChanged();
      } else {
        keyStrBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.google.protobuf.StringValue key_str = 2;</code>
     */
    public Builder setKeyStr(
        com.google.protobuf.StringValue.Builder builderForValue) {
      if (keyStrBuilder_ == null) {
        keyStr_ = builderForValue.build();
        onChanged();
      } else {
        keyStrBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.google.protobuf.StringValue key_str = 2;</code>
     */
    public Builder mergeKeyStr(com.google.protobuf.StringValue value) {
      if (keyStrBuilder_ == null) {
        if (keyStr_ != null) {
          keyStr_ =
            com.google.protobuf.StringValue.newBuilder(keyStr_).mergeFrom(value).buildPartial();
        } else {
          keyStr_ = value;
        }
        onChanged();
      } else {
        keyStrBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.google.protobuf.StringValue key_str = 2;</code>
     */
    public Builder clearKeyStr() {
      if (keyStrBuilder_ == null) {
        keyStr_ = null;
        onChanged();
      } else {
        keyStr_ = null;
        keyStrBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.google.protobuf.StringValue key_str = 2;</code>
     */
    public com.google.protobuf.StringValue.Builder getKeyStrBuilder() {
      
      onChanged();
      return getKeyStrFieldBuilder().getBuilder();
    }
    /**
     * <code>.google.protobuf.StringValue key_str = 2;</code>
     */
    public com.google.protobuf.StringValueOrBuilder getKeyStrOrBuilder() {
      if (keyStrBuilder_ != null) {
        return keyStrBuilder_.getMessageOrBuilder();
      } else {
        return keyStr_ == null ?
            com.google.protobuf.StringValue.getDefaultInstance() : keyStr_;
      }
    }
    /**
     * <code>.google.protobuf.StringValue key_str = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.StringValue, com.google.protobuf.StringValue.Builder, com.google.protobuf.StringValueOrBuilder> 
        getKeyStrFieldBuilder() {
      if (keyStrBuilder_ == null) {
        keyStrBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.protobuf.StringValue, com.google.protobuf.StringValue.Builder, com.google.protobuf.StringValueOrBuilder>(
                getKeyStr(),
                getParentForChildren(),
                isClean());
        keyStr_ = null;
      }
      return keyStrBuilder_;
    }

    private com.google.protobuf.Int64Value keyNum_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Int64Value, com.google.protobuf.Int64Value.Builder, com.google.protobuf.Int64ValueOrBuilder> keyNumBuilder_;
    /**
     * <code>.google.protobuf.Int64Value key_num = 3;</code>
     * @return Whether the keyNum field is set.
     */
    public boolean hasKeyNum() {
      return keyNumBuilder_ != null || keyNum_ != null;
    }
    /**
     * <code>.google.protobuf.Int64Value key_num = 3;</code>
     * @return The keyNum.
     */
    public com.google.protobuf.Int64Value getKeyNum() {
      if (keyNumBuilder_ == null) {
        return keyNum_ == null ? com.google.protobuf.Int64Value.getDefaultInstance() : keyNum_;
      } else {
        return keyNumBuilder_.getMessage();
      }
    }
    /**
     * <code>.google.protobuf.Int64Value key_num = 3;</code>
     */
    public Builder setKeyNum(com.google.protobuf.Int64Value value) {
      if (keyNumBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        keyNum_ = value;
        onChanged();
      } else {
        keyNumBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Int64Value key_num = 3;</code>
     */
    public Builder setKeyNum(
        com.google.protobuf.Int64Value.Builder builderForValue) {
      if (keyNumBuilder_ == null) {
        keyNum_ = builderForValue.build();
        onChanged();
      } else {
        keyNumBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Int64Value key_num = 3;</code>
     */
    public Builder mergeKeyNum(com.google.protobuf.Int64Value value) {
      if (keyNumBuilder_ == null) {
        if (keyNum_ != null) {
          keyNum_ =
            com.google.protobuf.Int64Value.newBuilder(keyNum_).mergeFrom(value).buildPartial();
        } else {
          keyNum_ = value;
        }
        onChanged();
      } else {
        keyNumBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Int64Value key_num = 3;</code>
     */
    public Builder clearKeyNum() {
      if (keyNumBuilder_ == null) {
        keyNum_ = null;
        onChanged();
      } else {
        keyNum_ = null;
        keyNumBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Int64Value key_num = 3;</code>
     */
    public com.google.protobuf.Int64Value.Builder getKeyNumBuilder() {
      
      onChanged();
      return getKeyNumFieldBuilder().getBuilder();
    }
    /**
     * <code>.google.protobuf.Int64Value key_num = 3;</code>
     */
    public com.google.protobuf.Int64ValueOrBuilder getKeyNumOrBuilder() {
      if (keyNumBuilder_ != null) {
        return keyNumBuilder_.getMessageOrBuilder();
      } else {
        return keyNum_ == null ?
            com.google.protobuf.Int64Value.getDefaultInstance() : keyNum_;
      }
    }
    /**
     * <code>.google.protobuf.Int64Value key_num = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Int64Value, com.google.protobuf.Int64Value.Builder, com.google.protobuf.Int64ValueOrBuilder> 
        getKeyNumFieldBuilder() {
      if (keyNumBuilder_ == null) {
        keyNumBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.protobuf.Int64Value, com.google.protobuf.Int64Value.Builder, com.google.protobuf.Int64ValueOrBuilder>(
                getKeyNum(),
                getParentForChildren(),
                isClean());
        keyNum_ = null;
      }
      return keyNumBuilder_;
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


    // @@protoc_insertion_point(builder_scope:im.turms.proto.DeleteResourceRequest)
  }

  // @@protoc_insertion_point(class_scope:im.turms.proto.DeleteResourceRequest)
  private static final DeleteResourceRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new DeleteResourceRequest();
  }

  public static DeleteResourceRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DeleteResourceRequest>
      PARSER = new com.google.protobuf.AbstractParser<DeleteResourceRequest>() {
    @java.lang.Override
    public DeleteResourceRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new DeleteResourceRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<DeleteResourceRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DeleteResourceRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public DeleteResourceRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

