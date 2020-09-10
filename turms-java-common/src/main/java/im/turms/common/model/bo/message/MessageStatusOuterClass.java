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
// source: model/message/message_status.proto

package im.turms.common.model.bo.message;

public final class MessageStatusOuterClass {
  private MessageStatusOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_im_turms_proto_MessageStatus_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_im_turms_proto_MessageStatus_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\"model/message/message_status.proto\022\016im" +
      ".turms.proto\032\036google/protobuf/wrappers.p" +
      "roto\032&constant/message_delivery_status.p" +
      "roto\"\310\002\n\rMessageStatus\022/\n\nmessage_id\030\001 \001" +
      "(\0132\033.google.protobuf.Int64Value\022/\n\nto_us" +
      "er_id\030\002 \001(\0132\033.google.protobuf.Int64Value" +
      "\022>\n\017delivery_status\030\003 \001(\0162%.im.turms.pro" +
      "to.MessageDeliveryStatus\0223\n\016reception_da" +
      "te\030\004 \001(\0132\033.google.protobuf.Int64Value\022.\n" +
      "\tread_date\030\005 \001(\0132\033.google.protobuf.Int64" +
      "Value\0220\n\013recall_date\030\006 \001(\0132\033.google.prot" +
      "obuf.Int64ValueB\'\n im.turms.common.model" +
      ".bo.messageP\001\272\002\000b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.WrappersProto.getDescriptor(),
          im.turms.common.constant.MessageDeliveryStatusOuterClass.getDescriptor(),
        });
    internal_static_im_turms_proto_MessageStatus_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_im_turms_proto_MessageStatus_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_im_turms_proto_MessageStatus_descriptor,
        new java.lang.String[] { "MessageId", "ToUserId", "DeliveryStatus", "ReceptionDate", "ReadDate", "RecallDate", });
    com.google.protobuf.WrappersProto.getDescriptor();
    im.turms.common.constant.MessageDeliveryStatusOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
