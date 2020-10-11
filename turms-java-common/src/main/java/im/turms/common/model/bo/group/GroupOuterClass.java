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
// source: model/group/group.proto

package im.turms.common.model.bo.group;

public final class GroupOuterClass {
  private GroupOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_im_turms_proto_Group_descriptor;
  static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_im_turms_proto_Group_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\027model/group/group.proto\022\016im.turms.prot" +
      "o\032\036google/protobuf/wrappers.proto\"\223\004\n\005Gr" +
      "oup\022\'\n\002id\030\001 \001(\0132\033.google.protobuf.Int64V" +
      "alue\022,\n\007type_id\030\002 \001(\0132\033.google.protobuf." +
      "Int64Value\022/\n\ncreator_id\030\003 \001(\0132\033.google." +
      "protobuf.Int64Value\022-\n\010owner_id\030\004 \001(\0132\033." +
      "google.protobuf.Int64Value\022*\n\004name\030\005 \001(\013" +
      "2\034.google.protobuf.StringValue\022+\n\005intro\030" +
      "\006 \001(\0132\034.google.protobuf.StringValue\0222\n\014a" +
      "nnouncement\030\007 \001(\0132\034.google.protobuf.Stri" +
      "ngValue\0222\n\rcreation_date\030\010 \001(\0132\033.google." +
      "protobuf.Int64Value\0222\n\rdeletion_date\030\t \001" +
      "(\0132\033.google.protobuf.Int64Value\0222\n\rmute_" +
      "end_date\030\n \001(\0132\033.google.protobuf.Int64Va" +
      "lue\022*\n\006active\030\013 \001(\0132\032.google.protobuf.Bo" +
      "olValueB%\n\036im.turms.common.model.bo.grou" +
      "pP\001\272\002\000b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.WrappersProto.getDescriptor(),
        });
    internal_static_im_turms_proto_Group_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_im_turms_proto_Group_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_im_turms_proto_Group_descriptor,
        new java.lang.String[] { "Id", "TypeId", "CreatorId", "OwnerId", "Name", "Intro", "Announcement", "CreationDate", "DeletionDate", "MuteEndDate", "Active", });
    com.google.protobuf.WrappersProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
