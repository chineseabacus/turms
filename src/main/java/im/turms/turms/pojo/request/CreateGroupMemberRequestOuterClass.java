// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: request/group/member/create_group_member_request.proto

package im.turms.turms.pojo.request;

public final class CreateGroupMemberRequestOuterClass {
  private CreateGroupMemberRequestOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_im_turms_proto_CreateGroupMemberRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_im_turms_proto_CreateGroupMemberRequest_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n6request/group/member/create_group_memb" +
      "er_request.proto\022\016im.turms.proto\032\036google" +
      "/protobuf/wrappers.proto\032 constant/group" +
      "_member_role.proto\"\314\001\n\030CreateGroupMember" +
      "Request\022\020\n\010group_id\030\001 \001(\003\022\017\n\007user_id\030\002 \001" +
      "(\003\022*\n\004name\030\003 \001(\0132\034.google.protobuf.Strin" +
      "gValue\022-\n\004role\030\004 \001(\0162\037.im.turms.proto.Gr" +
      "oupMemberRole\0222\n\rmute_end_date\030\005 \001(\0132\033.g" +
      "oogle.protobuf.Int64ValueB\037\n\033im.turms.tu" +
      "rms.pojo.requestP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.WrappersProto.getDescriptor(),
          im.turms.turms.constant.GroupMemberRoleOuterClass.getDescriptor(),
        });
    internal_static_im_turms_proto_CreateGroupMemberRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_im_turms_proto_CreateGroupMemberRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_im_turms_proto_CreateGroupMemberRequest_descriptor,
        new java.lang.String[] { "GroupId", "UserId", "Name", "Role", "MuteEndDate", });
    com.google.protobuf.WrappersProto.getDescriptor();
    im.turms.turms.constant.GroupMemberRoleOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}