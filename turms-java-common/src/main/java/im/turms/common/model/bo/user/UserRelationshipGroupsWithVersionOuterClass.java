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
// source: model/user/user_relationship_groups_with_version.proto

package im.turms.common.model.bo.user;

public final class UserRelationshipGroupsWithVersionOuterClass {
  private UserRelationshipGroupsWithVersionOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_im_turms_proto_UserRelationshipGroupsWithVersion_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_im_turms_proto_UserRelationshipGroupsWithVersion_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n6model/user/user_relationship_groups_wi" +
      "th_version.proto\022\016im.turms.proto\032\036google" +
      "/protobuf/wrappers.proto\032(model/user/use" +
      "r_relationship_group.proto\"\244\001\n!UserRelat" +
      "ionshipGroupsWithVersion\022G\n\030user_relatio" +
      "nship_groups\030\001 \003(\0132%.im.turms.proto.User" +
      "RelationshipGroup\0226\n\021last_updated_date\030\002" +
      " \001(\0132\033.google.protobuf.Int64ValueB$\n\035im." +
      "turms.common.model.bo.userP\001\272\002\000b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.WrappersProto.getDescriptor(),
          UserRelationshipGroupOuterClass.getDescriptor(),
        });
    internal_static_im_turms_proto_UserRelationshipGroupsWithVersion_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_im_turms_proto_UserRelationshipGroupsWithVersion_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_im_turms_proto_UserRelationshipGroupsWithVersion_descriptor,
        new java.lang.String[] { "UserRelationshipGroups", "LastUpdatedDate", });
    com.google.protobuf.WrappersProto.getDescriptor();
    UserRelationshipGroupOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
