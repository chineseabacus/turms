// DO NOT EDIT.
//
// Generated by the Swift generator plugin for the protocol buffer compiler.
// Source: constant/message_delivery_status.proto
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

public enum MessageDeliveryStatus: SwiftProtobuf.Enum {
  public typealias RawValue = Int
  case ready // = 0
  case sending // = 1
  case received // = 2
  case recalling // = 3
  case recalled // = 4
  case UNRECOGNIZED(Int)

  public init() {
    self = .ready
  }

  public init?(rawValue: Int) {
    switch rawValue {
    case 0: self = .ready
    case 1: self = .sending
    case 2: self = .received
    case 3: self = .recalling
    case 4: self = .recalled
    default: self = .UNRECOGNIZED(rawValue)
    }
  }

  public var rawValue: Int {
    switch self {
    case .ready: return 0
    case .sending: return 1
    case .received: return 2
    case .recalling: return 3
    case .recalled: return 4
    case .UNRECOGNIZED(let i): return i
    }
  }

}

#if swift(>=4.2)

extension MessageDeliveryStatus: CaseIterable {
  // The compiler won't synthesize support with the UNRECOGNIZED case.
  public static var allCases: [MessageDeliveryStatus] = [
    .ready,
    .sending,
    .received,
    .recalling,
    .recalled,
  ]
}

#endif  // swift(>=4.2)

// MARK: - Code below here is support for the SwiftProtobuf runtime.

extension MessageDeliveryStatus: SwiftProtobuf._ProtoNameProviding {
  public static let _protobuf_nameMap: SwiftProtobuf._NameMap = [
    0: .same(proto: "READY"),
    1: .same(proto: "SENDING"),
    2: .same(proto: "RECEIVED"),
    3: .same(proto: "RECALLING"),
    4: .same(proto: "RECALLED"),
  ]
}