// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: response/group/group_invitations_with_version.proto

package im.turms.turms.pojo.response;

public final class GroupInvitationsWithVersionOuterClass {
  private GroupInvitationsWithVersionOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_im_turms_proto_GroupInvitationsWithVersion_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_im_turms_proto_GroupInvitationsWithVersion_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n3response/group/group_invitations_with_" +
      "version.proto\022\016im.turms.proto\032\036google/pr" +
      "otobuf/wrappers.proto\032 dto/group/group_i" +
      "nvitation.proto\"\221\001\n\033GroupInvitationsWith" +
      "Version\022:\n\021group_invitations\030\001 \003(\0132\037.im." +
      "turms.proto.GroupInvitation\0226\n\021last_upda" +
      "ted_date\030\002 \001(\0132\033.google.protobuf.Int64Va" +
      "lueB \n\034im.turms.turms.pojo.responseP\001b\006p" +
      "roto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.WrappersProto.getDescriptor(),
          im.turms.turms.pojo.dto.GroupInvitationOuterClass.getDescriptor(),
        });
    internal_static_im_turms_proto_GroupInvitationsWithVersion_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_im_turms_proto_GroupInvitationsWithVersion_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_im_turms_proto_GroupInvitationsWithVersion_descriptor,
        new java.lang.String[] { "GroupInvitations", "LastUpdatedDate", });
    com.google.protobuf.WrappersProto.getDescriptor();
    im.turms.turms.pojo.dto.GroupInvitationOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}