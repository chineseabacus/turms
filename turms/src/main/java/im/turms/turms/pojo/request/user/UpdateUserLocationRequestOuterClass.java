// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: request/user/update_user_location_request.proto

package im.turms.turms.pojo.request.user;

public final class UpdateUserLocationRequestOuterClass {
  private UpdateUserLocationRequestOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_im_turms_proto_UpdateUserLocationRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_im_turms_proto_UpdateUserLocationRequest_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n/request/user/update_user_location_requ" +
      "est.proto\022\016im.turms.proto\032\036google/protob" +
      "uf/wrappers.proto\"\233\001\n\031UpdateUserLocation" +
      "Request\022\020\n\010latitude\030\001 \001(\002\022\021\n\tlongitude\030\002" +
      " \001(\002\022*\n\004name\030\003 \001(\0132\034.google.protobuf.Str" +
      "ingValue\022-\n\007address\030\004 \001(\0132\034.google.proto" +
      "buf.StringValueB$\n im.turms.turms.pojo.r" +
      "equest.userP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.WrappersProto.getDescriptor(),
        });
    internal_static_im_turms_proto_UpdateUserLocationRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_im_turms_proto_UpdateUserLocationRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_im_turms_proto_UpdateUserLocationRequest_descriptor,
        new java.lang.String[] { "Latitude", "Longitude", "Name", "Address", });
    com.google.protobuf.WrappersProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
