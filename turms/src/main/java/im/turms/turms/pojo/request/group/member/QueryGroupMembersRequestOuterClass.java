// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: request/group/member/query_group_members_request.proto

package im.turms.turms.pojo.request.group.member;

public final class QueryGroupMembersRequestOuterClass {
  private QueryGroupMembersRequestOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_im_turms_proto_QueryGroupMembersRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_im_turms_proto_QueryGroupMembersRequest_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n6request/group/member/query_group_membe" +
      "rs_request.proto\022\016im.turms.proto\032\036google" +
      "/protobuf/wrappers.proto\"\260\001\n\030QueryGroupM" +
      "embersRequest\022\020\n\010group_id\030\001 \001(\003\0226\n\021last_" +
      "updated_date\030\002 \001(\0132\033.google.protobuf.Int" +
      "64Value\022\031\n\021group_members_ids\030\003 \003(\003\022/\n\013wi" +
      "th_status\030\004 \001(\0132\032.google.protobuf.BoolVa" +
      "lueB,\n(im.turms.turms.pojo.request.group" +
      ".memberP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.WrappersProto.getDescriptor(),
        });
    internal_static_im_turms_proto_QueryGroupMembersRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_im_turms_proto_QueryGroupMembersRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_im_turms_proto_QueryGroupMembersRequest_descriptor,
        new java.lang.String[] { "GroupId", "LastUpdatedDate", "GroupMembersIds", "WithStatus", });
    com.google.protobuf.WrappersProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
