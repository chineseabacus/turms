// DO NOT EDIT.
//
// Generated by the Swift generator plugin for the protocol buffer compiler.
// Source: model/file/video_file.proto
//
// For information on using the generated types, please see the documentation:
//   https://github.com/apple/swift-protobuf/

import Foundation
import SwiftProtobuf

// If the compiler emits an error on this type, it is because this file
// was generated by a version of the `protoc` Swift plug-in that is
// incompatible with the version of SwiftProtobuf to which you are linking.
// Please ensure that your are building against the same version of the API
// that was used to generate this file.
fileprivate struct _GeneratedWithProtocGenSwiftVersion: SwiftProtobuf.ProtobufAPIVersionCheck {
  struct _2: SwiftProtobuf.ProtobufAPIVersion_2 {}
  typealias Version = _2
}

public struct VideoFile {
  // SwiftProtobuf.Message conformance is added in an extension below. See the
  // `Message` and `Message+*Additions` files in the SwiftProtobuf library for
  // methods supported on all messages.

  public var description_p: VideoFile.Description {
    get {return _storage._description_p ?? VideoFile.Description()}
    set {_uniqueStorage()._description_p = newValue}
  }
  /// Returns true if `description_p` has been explicitly set.
  public var hasDescription_p: Bool {return _storage._description_p != nil}
  /// Clears the value of `description_p`. Subsequent reads from it will return its default value.
  public mutating func clearDescription_p() {_uniqueStorage()._description_p = nil}

  public var data: SwiftProtobuf.Google_Protobuf_BytesValue {
    get {return _storage._data ?? SwiftProtobuf.Google_Protobuf_BytesValue()}
    set {_uniqueStorage()._data = newValue}
  }
  /// Returns true if `data` has been explicitly set.
  public var hasData: Bool {return _storage._data != nil}
  /// Clears the value of `data`. Subsequent reads from it will return its default value.
  public mutating func clearData() {_uniqueStorage()._data = nil}

  public var unknownFields = SwiftProtobuf.UnknownStorage()

  public struct Description {
    // SwiftProtobuf.Message conformance is added in an extension below. See the
    // `Message` and `Message+*Additions` files in the SwiftProtobuf library for
    // methods supported on all messages.

    public var url: String {
      get {return _storage._url}
      set {_uniqueStorage()._url = newValue}
    }

    public var duration: SwiftProtobuf.Google_Protobuf_Int32Value {
      get {return _storage._duration ?? SwiftProtobuf.Google_Protobuf_Int32Value()}
      set {_uniqueStorage()._duration = newValue}
    }
    /// Returns true if `duration` has been explicitly set.
    public var hasDuration: Bool {return _storage._duration != nil}
    /// Clears the value of `duration`. Subsequent reads from it will return its default value.
    public mutating func clearDuration() {_uniqueStorage()._duration = nil}

    public var size: SwiftProtobuf.Google_Protobuf_Int32Value {
      get {return _storage._size ?? SwiftProtobuf.Google_Protobuf_Int32Value()}
      set {_uniqueStorage()._size = newValue}
    }
    /// Returns true if `size` has been explicitly set.
    public var hasSize: Bool {return _storage._size != nil}
    /// Clears the value of `size`. Subsequent reads from it will return its default value.
    public mutating func clearSize() {_uniqueStorage()._size = nil}

    public var format: SwiftProtobuf.Google_Protobuf_StringValue {
      get {return _storage._format ?? SwiftProtobuf.Google_Protobuf_StringValue()}
      set {_uniqueStorage()._format = newValue}
    }
    /// Returns true if `format` has been explicitly set.
    public var hasFormat: Bool {return _storage._format != nil}
    /// Clears the value of `format`. Subsequent reads from it will return its default value.
    public mutating func clearFormat() {_uniqueStorage()._format = nil}

    public var unknownFields = SwiftProtobuf.UnknownStorage()

    public init() {}

    fileprivate var _storage = _StorageClass.defaultInstance
  }

  public init() {}

  fileprivate var _storage = _StorageClass.defaultInstance
}

// MARK: - Code below here is support for the SwiftProtobuf runtime.

fileprivate let _protobuf_package = "im.turms.proto"

extension VideoFile: SwiftProtobuf.Message, SwiftProtobuf._MessageImplementationBase, SwiftProtobuf._ProtoNameProviding {
  public static let protoMessageName: String = _protobuf_package + ".VideoFile"
  public static let _protobuf_nameMap: SwiftProtobuf._NameMap = [
    1: .same(proto: "description"),
    2: .same(proto: "data"),
  ]

  fileprivate class _StorageClass {
    var _description_p: VideoFile.Description? = nil
    var _data: SwiftProtobuf.Google_Protobuf_BytesValue? = nil

    static let defaultInstance = _StorageClass()

    private init() {}

    init(copying source: _StorageClass) {
      _description_p = source._description_p
      _data = source._data
    }
  }

  fileprivate mutating func _uniqueStorage() -> _StorageClass {
    if !isKnownUniquelyReferenced(&_storage) {
      _storage = _StorageClass(copying: _storage)
    }
    return _storage
  }

  public mutating func decodeMessage<D: SwiftProtobuf.Decoder>(decoder: inout D) throws {
    _ = _uniqueStorage()
    try withExtendedLifetime(_storage) { (_storage: _StorageClass) in
      while let fieldNumber = try decoder.nextFieldNumber() {
        switch fieldNumber {
        case 1: try decoder.decodeSingularMessageField(value: &_storage._description_p)
        case 2: try decoder.decodeSingularMessageField(value: &_storage._data)
        default: break
        }
      }
    }
  }

  public func traverse<V: SwiftProtobuf.Visitor>(visitor: inout V) throws {
    try withExtendedLifetime(_storage) { (_storage: _StorageClass) in
      if let v = _storage._description_p {
        try visitor.visitSingularMessageField(value: v, fieldNumber: 1)
      }
      if let v = _storage._data {
        try visitor.visitSingularMessageField(value: v, fieldNumber: 2)
      }
    }
    try unknownFields.traverse(visitor: &visitor)
  }

  public static func ==(lhs: VideoFile, rhs: VideoFile) -> Bool {
    if lhs._storage !== rhs._storage {
      let storagesAreEqual: Bool = withExtendedLifetime((lhs._storage, rhs._storage)) { (_args: (_StorageClass, _StorageClass)) in
        let _storage = _args.0
        let rhs_storage = _args.1
        if _storage._description_p != rhs_storage._description_p {return false}
        if _storage._data != rhs_storage._data {return false}
        return true
      }
      if !storagesAreEqual {return false}
    }
    if lhs.unknownFields != rhs.unknownFields {return false}
    return true
  }
}

extension VideoFile.Description: SwiftProtobuf.Message, SwiftProtobuf._MessageImplementationBase, SwiftProtobuf._ProtoNameProviding {
  public static let protoMessageName: String = VideoFile.protoMessageName + ".Description"
  public static let _protobuf_nameMap: SwiftProtobuf._NameMap = [
    1: .same(proto: "url"),
    2: .same(proto: "duration"),
    3: .same(proto: "size"),
    4: .same(proto: "format"),
  ]

  fileprivate class _StorageClass {
    var _url: String = String()
    var _duration: SwiftProtobuf.Google_Protobuf_Int32Value? = nil
    var _size: SwiftProtobuf.Google_Protobuf_Int32Value? = nil
    var _format: SwiftProtobuf.Google_Protobuf_StringValue? = nil

    static let defaultInstance = _StorageClass()

    private init() {}

    init(copying source: _StorageClass) {
      _url = source._url
      _duration = source._duration
      _size = source._size
      _format = source._format
    }
  }

  fileprivate mutating func _uniqueStorage() -> _StorageClass {
    if !isKnownUniquelyReferenced(&_storage) {
      _storage = _StorageClass(copying: _storage)
    }
    return _storage
  }

  public mutating func decodeMessage<D: SwiftProtobuf.Decoder>(decoder: inout D) throws {
    _ = _uniqueStorage()
    try withExtendedLifetime(_storage) { (_storage: _StorageClass) in
      while let fieldNumber = try decoder.nextFieldNumber() {
        switch fieldNumber {
        case 1: try decoder.decodeSingularStringField(value: &_storage._url)
        case 2: try decoder.decodeSingularMessageField(value: &_storage._duration)
        case 3: try decoder.decodeSingularMessageField(value: &_storage._size)
        case 4: try decoder.decodeSingularMessageField(value: &_storage._format)
        default: break
        }
      }
    }
  }

  public func traverse<V: SwiftProtobuf.Visitor>(visitor: inout V) throws {
    try withExtendedLifetime(_storage) { (_storage: _StorageClass) in
      if !_storage._url.isEmpty {
        try visitor.visitSingularStringField(value: _storage._url, fieldNumber: 1)
      }
      if let v = _storage._duration {
        try visitor.visitSingularMessageField(value: v, fieldNumber: 2)
      }
      if let v = _storage._size {
        try visitor.visitSingularMessageField(value: v, fieldNumber: 3)
      }
      if let v = _storage._format {
        try visitor.visitSingularMessageField(value: v, fieldNumber: 4)
      }
    }
    try unknownFields.traverse(visitor: &visitor)
  }

  public static func ==(lhs: VideoFile.Description, rhs: VideoFile.Description) -> Bool {
    if lhs._storage !== rhs._storage {
      let storagesAreEqual: Bool = withExtendedLifetime((lhs._storage, rhs._storage)) { (_args: (_StorageClass, _StorageClass)) in
        let _storage = _args.0
        let rhs_storage = _args.1
        if _storage._url != rhs_storage._url {return false}
        if _storage._duration != rhs_storage._duration {return false}
        if _storage._size != rhs_storage._size {return false}
        if _storage._format != rhs_storage._format {return false}
        return true
      }
      if !storagesAreEqual {return false}
    }
    if lhs.unknownFields != rhs.unknownFields {return false}
    return true
  }
}
