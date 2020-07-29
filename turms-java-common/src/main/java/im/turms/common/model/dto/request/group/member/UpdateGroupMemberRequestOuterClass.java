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
// source: request/group/member/update_group_member_request.proto

package im.turms.common.model.dto.request.group.member;

import im.turms.common.constant.GroupMemberRoleOuterClass;

public final class UpdateGroupMemberRequestOuterClass {
  private UpdateGroupMemberRequestOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_im_turms_proto_UpdateGroupMemberRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_im_turms_proto_UpdateGroupMemberRequest_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n6request/group/member/update_group_memb" +
      "er_request.proto\022\016im.turms.proto\032\036google" +
      "/protobuf/wrappers.proto\032 constant/group" +
      "_member_role.proto\"\316\001\n\030UpdateGroupMember" +
      "Request\022\020\n\010group_id\030\001 \001(\003\022\021\n\tmember_id\030\002" +
      " \001(\003\022*\n\004name\030\003 \001(\0132\034.google.protobuf.Str" +
      "ingValue\022-\n\004role\030\004 \001(\0162\037.im.turms.proto." +
      "GroupMemberRole\0222\n\rmute_end_date\030\005 \001(\0132\033" +
      ".google.protobuf.Int64ValueB5\n.im.turms." +
      "common.model.dto.request.group.memberP\001\272" +
      "\002\000b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.WrappersProto.getDescriptor(),
          GroupMemberRoleOuterClass.getDescriptor(),
        });
    internal_static_im_turms_proto_UpdateGroupMemberRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_im_turms_proto_UpdateGroupMemberRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_im_turms_proto_UpdateGroupMemberRequest_descriptor,
        new java.lang.String[] { "GroupId", "MemberId", "Name", "Role", "MuteEndDate", });
    com.google.protobuf.WrappersProto.getDescriptor();
    GroupMemberRoleOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
