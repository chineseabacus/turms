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
// source: request/storage/query_signed_get_url_request.proto

package im.turms.common.model.dto.request.storage;

public interface QuerySignedGetUrlRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:im.turms.proto.QuerySignedGetUrlRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.im.turms.proto.ContentType content_type = 1;</code>
   * @return The enum numeric value on the wire for contentType.
   */
  int getContentTypeValue();
  /**
   * <code>.im.turms.proto.ContentType content_type = 1;</code>
   * @return The contentType.
   */
  im.turms.common.constant.ContentType getContentType();

  /**
   * <code>.google.protobuf.StringValue key_str = 2;</code>
   * @return Whether the keyStr field is set.
   */
  boolean hasKeyStr();
  /**
   * <code>.google.protobuf.StringValue key_str = 2;</code>
   * @return The keyStr.
   */
  com.google.protobuf.StringValue getKeyStr();
  /**
   * <code>.google.protobuf.StringValue key_str = 2;</code>
   */
  com.google.protobuf.StringValueOrBuilder getKeyStrOrBuilder();

  /**
   * <code>.google.protobuf.Int64Value key_num = 3;</code>
   * @return Whether the keyNum field is set.
   */
  boolean hasKeyNum();
  /**
   * <code>.google.protobuf.Int64Value key_num = 3;</code>
   * @return The keyNum.
   */
  com.google.protobuf.Int64Value getKeyNum();
  /**
   * <code>.google.protobuf.Int64Value key_num = 3;</code>
   */
  com.google.protobuf.Int64ValueOrBuilder getKeyNumOrBuilder();
}
