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
// source: request/group/blacklist/delete_group_blacklisted_user_request.proto

package im.turms.common.model.dto.request.group.blacklist;

public final class DeleteGroupBlacklistedUserRequestOuterClass {
  private DeleteGroupBlacklistedUserRequestOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_im_turms_proto_DeleteGroupBlacklistedUserRequest_descriptor;
  static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_im_turms_proto_DeleteGroupBlacklistedUserRequest_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\nCrequest/group/blacklist/delete_group_b" +
      "lacklisted_user_request.proto\022\016im.turms." +
      "proto\"F\n!DeleteGroupBlacklistedUserReque" +
      "st\022\020\n\010group_id\030\001 \001(\003\022\017\n\007user_id\030\002 \001(\003B8\n" +
      "1im.turms.common.model.dto.request.group" +
      ".blacklistP\001\272\002\000b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_im_turms_proto_DeleteGroupBlacklistedUserRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_im_turms_proto_DeleteGroupBlacklistedUserRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_im_turms_proto_DeleteGroupBlacklistedUserRequest_descriptor,
        new java.lang.String[] { "GroupId", "UserId", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
