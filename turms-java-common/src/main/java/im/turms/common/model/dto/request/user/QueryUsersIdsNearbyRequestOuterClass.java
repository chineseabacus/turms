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
// source: request/user/query_users_ids_nearby_request.proto

package im.turms.common.model.dto.request.user;

public final class QueryUsersIdsNearbyRequestOuterClass {
  private QueryUsersIdsNearbyRequestOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_im_turms_proto_QueryUsersIdsNearbyRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_im_turms_proto_QueryUsersIdsNearbyRequest_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n1request/user/query_users_ids_nearby_re" +
      "quest.proto\022\016im.turms.proto\032\036google/prot" +
      "obuf/wrappers.proto\"\240\001\n\032QueryUsersIdsNea" +
      "rbyRequest\022\020\n\010latitude\030\001 \001(\002\022\021\n\tlongitud" +
      "e\030\002 \001(\002\022-\n\010distance\030\003 \001(\0132\033.google.proto" +
      "buf.FloatValue\022.\n\tmaxNumber\030\004 \001(\0132\033.goog" +
      "le.protobuf.Int32ValueB-\n&im.turms.commo" +
      "n.model.dto.request.userP\001\272\002\000b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.WrappersProto.getDescriptor(),
        });
    internal_static_im_turms_proto_QueryUsersIdsNearbyRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_im_turms_proto_QueryUsersIdsNearbyRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_im_turms_proto_QueryUsersIdsNearbyRequest_descriptor,
        new java.lang.String[] { "Latitude", "Longitude", "Distance", "MaxNumber", });
    com.google.protobuf.WrappersProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
