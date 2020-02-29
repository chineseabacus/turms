// DO NOT EDIT.
//
// Generated by the Swift generator plugin for the protocol buffer compiler.
// Source: notification/turms_notification.proto
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

public struct TurmsNotification {
  // SwiftProtobuf.Message conformance is added in an extension below. See the
  // `Message` and `Message+*Additions` files in the SwiftProtobuf library for
  // methods supported on all messages.

  /// Note: request_id is allowed to be duplicate because
  /// it is used for clients to identify the response of the same request id in a session
  public var requestID: SwiftProtobuf.Google_Protobuf_Int64Value {
    get {return _storage._requestID ?? SwiftProtobuf.Google_Protobuf_Int64Value()}
    set {_uniqueStorage()._requestID = newValue}
  }
  /// Returns true if `requestID` has been explicitly set.
  public var hasRequestID: Bool {return _storage._requestID != nil}
  /// Clears the value of `requestID`. Subsequent reads from it will return its default value.
  public mutating func clearRequestID() {_uniqueStorage()._requestID = nil}

  public var code: SwiftProtobuf.Google_Protobuf_Int32Value {
    get {return _storage._code ?? SwiftProtobuf.Google_Protobuf_Int32Value()}
    set {_uniqueStorage()._code = newValue}
  }
  /// Returns true if `code` has been explicitly set.
  public var hasCode: Bool {return _storage._code != nil}
  /// Clears the value of `code`. Subsequent reads from it will return its default value.
  public mutating func clearCode() {_uniqueStorage()._code = nil}

  public var reason: SwiftProtobuf.Google_Protobuf_StringValue {
    get {return _storage._reason ?? SwiftProtobuf.Google_Protobuf_StringValue()}
    set {_uniqueStorage()._reason = newValue}
  }
  /// Returns true if `reason` has been explicitly set.
  public var hasReason: Bool {return _storage._reason != nil}
  /// Clears the value of `reason`. Subsequent reads from it will return its default value.
  public mutating func clearReason() {_uniqueStorage()._reason = nil}

  public var data: TurmsNotification.DataMessage {
    get {return _storage._data ?? TurmsNotification.DataMessage()}
    set {_uniqueStorage()._data = newValue}
  }
  /// Returns true if `data` has been explicitly set.
  public var hasData: Bool {return _storage._data != nil}
  /// Clears the value of `data`. Subsequent reads from it will return its default value.
  public mutating func clearData() {_uniqueStorage()._data = nil}

  public var relayedRequest: TurmsRequest {
    get {return _storage._relayedRequest ?? TurmsRequest()}
    set {_uniqueStorage()._relayedRequest = newValue}
  }
  /// Returns true if `relayedRequest` has been explicitly set.
  public var hasRelayedRequest: Bool {return _storage._relayedRequest != nil}
  /// Clears the value of `relayedRequest`. Subsequent reads from it will return its default value.
  public mutating func clearRelayedRequest() {_uniqueStorage()._relayedRequest = nil}

  /// requester_id only exists when a requester triggers a notification to its recipients
  /// Note: Do not move requester_id to TurmsRequest because it needs to rebuild a whole TurmsNotification
  /// when recipients need the requester_id.
  public var requesterID: SwiftProtobuf.Google_Protobuf_Int64Value {
    get {return _storage._requesterID ?? SwiftProtobuf.Google_Protobuf_Int64Value()}
    set {_uniqueStorage()._requesterID = newValue}
  }
  /// Returns true if `requesterID` has been explicitly set.
  public var hasRequesterID: Bool {return _storage._requesterID != nil}
  /// Clears the value of `requesterID`. Subsequent reads from it will return its default value.
  public mutating func clearRequesterID() {_uniqueStorage()._requesterID = nil}

  public var unknownFields = SwiftProtobuf.UnknownStorage()

  public struct DataMessage {
    // SwiftProtobuf.Message conformance is added in an extension below. See the
    // `Message` and `Message+*Additions` files in the SwiftProtobuf library for
    // methods supported on all messages.

    public var kind: OneOf_Kind? {
      get {return _storage._kind}
      set {_uniqueStorage()._kind = newValue}
    }

    public var ids: Int64Values {
      get {
        if case .ids(let v)? = _storage._kind {return v}
        return Int64Values()
      }
      set {_uniqueStorage()._kind = .ids(newValue)}
    }

    public var idsWithVersion: Int64ValuesWithVersion {
      get {
        if case .idsWithVersion(let v)? = _storage._kind {return v}
        return Int64ValuesWithVersion()
      }
      set {_uniqueStorage()._kind = .idsWithVersion(newValue)}
    }

    public var url: SwiftProtobuf.Google_Protobuf_StringValue {
      get {
        if case .url(let v)? = _storage._kind {return v}
        return SwiftProtobuf.Google_Protobuf_StringValue()
      }
      set {_uniqueStorage()._kind = .url(newValue)}
    }

    public var acknowledge: Acknowledge {
      get {
        if case .acknowledge(let v)? = _storage._kind {return v}
        return Acknowledge()
      }
      set {_uniqueStorage()._kind = .acknowledge(newValue)}
    }

    public var session: Session {
      get {
        if case .session(let v)? = _storage._kind {return v}
        return Session()
      }
      set {_uniqueStorage()._kind = .session(newValue)}
    }

    public var messages: Messages {
      get {
        if case .messages(let v)? = _storage._kind {return v}
        return Messages()
      }
      set {_uniqueStorage()._kind = .messages(newValue)}
    }

    public var messageStatuses: MessageStatuses {
      get {
        if case .messageStatuses(let v)? = _storage._kind {return v}
        return MessageStatuses()
      }
      set {_uniqueStorage()._kind = .messageStatuses(newValue)}
    }

    public var messagesWithTotalList: MessagesWithTotalList {
      get {
        if case .messagesWithTotalList(let v)? = _storage._kind {return v}
        return MessagesWithTotalList()
      }
      set {_uniqueStorage()._kind = .messagesWithTotalList(newValue)}
    }

    public var usersInfosWithVersion: UsersInfosWithVersion {
      get {
        if case .usersInfosWithVersion(let v)? = _storage._kind {return v}
        return UsersInfosWithVersion()
      }
      set {_uniqueStorage()._kind = .usersInfosWithVersion(newValue)}
    }

    public var usersOnlineStatuses: UsersOnlineStatuses {
      get {
        if case .usersOnlineStatuses(let v)? = _storage._kind {return v}
        return UsersOnlineStatuses()
      }
      set {_uniqueStorage()._kind = .usersOnlineStatuses(newValue)}
    }

    public var userFriendRequestsWithVersion: UserFriendRequestsWithVersion {
      get {
        if case .userFriendRequestsWithVersion(let v)? = _storage._kind {return v}
        return UserFriendRequestsWithVersion()
      }
      set {_uniqueStorage()._kind = .userFriendRequestsWithVersion(newValue)}
    }

    public var userRelationshipGroupsWithVersion: UserRelationshipGroupsWithVersion {
      get {
        if case .userRelationshipGroupsWithVersion(let v)? = _storage._kind {return v}
        return UserRelationshipGroupsWithVersion()
      }
      set {_uniqueStorage()._kind = .userRelationshipGroupsWithVersion(newValue)}
    }

    public var userRelationshipsWithVersion: UserRelationshipsWithVersion {
      get {
        if case .userRelationshipsWithVersion(let v)? = _storage._kind {return v}
        return UserRelationshipsWithVersion()
      }
      set {_uniqueStorage()._kind = .userRelationshipsWithVersion(newValue)}
    }

    public var groupInvitationsWithVersion: GroupInvitationsWithVersion {
      get {
        if case .groupInvitationsWithVersion(let v)? = _storage._kind {return v}
        return GroupInvitationsWithVersion()
      }
      set {_uniqueStorage()._kind = .groupInvitationsWithVersion(newValue)}
    }

    public var groupJoinQuestionAnswerResult: GroupJoinQuestionsAnswerResult {
      get {
        if case .groupJoinQuestionAnswerResult(let v)? = _storage._kind {return v}
        return GroupJoinQuestionsAnswerResult()
      }
      set {_uniqueStorage()._kind = .groupJoinQuestionAnswerResult(newValue)}
    }

    public var groupJoinRequestsWithVersion: GroupJoinRequestsWithVersion {
      get {
        if case .groupJoinRequestsWithVersion(let v)? = _storage._kind {return v}
        return GroupJoinRequestsWithVersion()
      }
      set {_uniqueStorage()._kind = .groupJoinRequestsWithVersion(newValue)}
    }

    public var groupJoinQuestionsWithVersion: GroupJoinQuestionsWithVersion {
      get {
        if case .groupJoinQuestionsWithVersion(let v)? = _storage._kind {return v}
        return GroupJoinQuestionsWithVersion()
      }
      set {_uniqueStorage()._kind = .groupJoinQuestionsWithVersion(newValue)}
    }

    public var groupMembersWithVersion: GroupMembersWithVersion {
      get {
        if case .groupMembersWithVersion(let v)? = _storage._kind {return v}
        return GroupMembersWithVersion()
      }
      set {_uniqueStorage()._kind = .groupMembersWithVersion(newValue)}
    }

    public var groupsWithVersion: GroupsWithVersion {
      get {
        if case .groupsWithVersion(let v)? = _storage._kind {return v}
        return GroupsWithVersion()
      }
      set {_uniqueStorage()._kind = .groupsWithVersion(newValue)}
    }

    public var unknownFields = SwiftProtobuf.UnknownStorage()

    public enum OneOf_Kind: Equatable {
      case ids(Int64Values)
      case idsWithVersion(Int64ValuesWithVersion)
      case url(SwiftProtobuf.Google_Protobuf_StringValue)
      case acknowledge(Acknowledge)
      case session(Session)
      case messages(Messages)
      case messageStatuses(MessageStatuses)
      case messagesWithTotalList(MessagesWithTotalList)
      case usersInfosWithVersion(UsersInfosWithVersion)
      case usersOnlineStatuses(UsersOnlineStatuses)
      case userFriendRequestsWithVersion(UserFriendRequestsWithVersion)
      case userRelationshipGroupsWithVersion(UserRelationshipGroupsWithVersion)
      case userRelationshipsWithVersion(UserRelationshipsWithVersion)
      case groupInvitationsWithVersion(GroupInvitationsWithVersion)
      case groupJoinQuestionAnswerResult(GroupJoinQuestionsAnswerResult)
      case groupJoinRequestsWithVersion(GroupJoinRequestsWithVersion)
      case groupJoinQuestionsWithVersion(GroupJoinQuestionsWithVersion)
      case groupMembersWithVersion(GroupMembersWithVersion)
      case groupsWithVersion(GroupsWithVersion)

    #if !swift(>=4.1)
      public static func ==(lhs: TurmsNotification.DataMessage.OneOf_Kind, rhs: TurmsNotification.DataMessage.OneOf_Kind) -> Bool {
        switch (lhs, rhs) {
        case (.ids(let l), .ids(let r)): return l == r
        case (.idsWithVersion(let l), .idsWithVersion(let r)): return l == r
        case (.url(let l), .url(let r)): return l == r
        case (.acknowledge(let l), .acknowledge(let r)): return l == r
        case (.session(let l), .session(let r)): return l == r
        case (.messages(let l), .messages(let r)): return l == r
        case (.messageStatuses(let l), .messageStatuses(let r)): return l == r
        case (.messagesWithTotalList(let l), .messagesWithTotalList(let r)): return l == r
        case (.usersInfosWithVersion(let l), .usersInfosWithVersion(let r)): return l == r
        case (.usersOnlineStatuses(let l), .usersOnlineStatuses(let r)): return l == r
        case (.userFriendRequestsWithVersion(let l), .userFriendRequestsWithVersion(let r)): return l == r
        case (.userRelationshipGroupsWithVersion(let l), .userRelationshipGroupsWithVersion(let r)): return l == r
        case (.userRelationshipsWithVersion(let l), .userRelationshipsWithVersion(let r)): return l == r
        case (.groupInvitationsWithVersion(let l), .groupInvitationsWithVersion(let r)): return l == r
        case (.groupJoinQuestionAnswerResult(let l), .groupJoinQuestionAnswerResult(let r)): return l == r
        case (.groupJoinRequestsWithVersion(let l), .groupJoinRequestsWithVersion(let r)): return l == r
        case (.groupJoinQuestionsWithVersion(let l), .groupJoinQuestionsWithVersion(let r)): return l == r
        case (.groupMembersWithVersion(let l), .groupMembersWithVersion(let r)): return l == r
        case (.groupsWithVersion(let l), .groupsWithVersion(let r)): return l == r
        default: return false
        }
      }
    #endif
    }

    public init() {}

    fileprivate var _storage = _StorageClass.defaultInstance
  }

  public init() {}

  fileprivate var _storage = _StorageClass.defaultInstance
}

// MARK: - Code below here is support for the SwiftProtobuf runtime.

fileprivate let _protobuf_package = "im.turms.proto"

extension TurmsNotification: SwiftProtobuf.Message, SwiftProtobuf._MessageImplementationBase, SwiftProtobuf._ProtoNameProviding {
  public static let protoMessageName: String = _protobuf_package + ".TurmsNotification"
  public static let _protobuf_nameMap: SwiftProtobuf._NameMap = [
    1: .standard(proto: "request_id"),
    2: .same(proto: "code"),
    3: .same(proto: "reason"),
    4: .same(proto: "data"),
    5: .standard(proto: "relayed_request"),
    6: .standard(proto: "requester_id"),
  ]

  fileprivate class _StorageClass {
    var _requestID: SwiftProtobuf.Google_Protobuf_Int64Value? = nil
    var _code: SwiftProtobuf.Google_Protobuf_Int32Value? = nil
    var _reason: SwiftProtobuf.Google_Protobuf_StringValue? = nil
    var _data: TurmsNotification.DataMessage? = nil
    var _relayedRequest: TurmsRequest? = nil
    var _requesterID: SwiftProtobuf.Google_Protobuf_Int64Value? = nil

    static let defaultInstance = _StorageClass()

    private init() {}

    init(copying source: _StorageClass) {
      _requestID = source._requestID
      _code = source._code
      _reason = source._reason
      _data = source._data
      _relayedRequest = source._relayedRequest
      _requesterID = source._requesterID
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
        case 1: try decoder.decodeSingularMessageField(value: &_storage._requestID)
        case 2: try decoder.decodeSingularMessageField(value: &_storage._code)
        case 3: try decoder.decodeSingularMessageField(value: &_storage._reason)
        case 4: try decoder.decodeSingularMessageField(value: &_storage._data)
        case 5: try decoder.decodeSingularMessageField(value: &_storage._relayedRequest)
        case 6: try decoder.decodeSingularMessageField(value: &_storage._requesterID)
        default: break
        }
      }
    }
  }

  public func traverse<V: SwiftProtobuf.Visitor>(visitor: inout V) throws {
    try withExtendedLifetime(_storage) { (_storage: _StorageClass) in
      if let v = _storage._requestID {
        try visitor.visitSingularMessageField(value: v, fieldNumber: 1)
      }
      if let v = _storage._code {
        try visitor.visitSingularMessageField(value: v, fieldNumber: 2)
      }
      if let v = _storage._reason {
        try visitor.visitSingularMessageField(value: v, fieldNumber: 3)
      }
      if let v = _storage._data {
        try visitor.visitSingularMessageField(value: v, fieldNumber: 4)
      }
      if let v = _storage._relayedRequest {
        try visitor.visitSingularMessageField(value: v, fieldNumber: 5)
      }
      if let v = _storage._requesterID {
        try visitor.visitSingularMessageField(value: v, fieldNumber: 6)
      }
    }
    try unknownFields.traverse(visitor: &visitor)
  }

  public static func ==(lhs: TurmsNotification, rhs: TurmsNotification) -> Bool {
    if lhs._storage !== rhs._storage {
      let storagesAreEqual: Bool = withExtendedLifetime((lhs._storage, rhs._storage)) { (_args: (_StorageClass, _StorageClass)) in
        let _storage = _args.0
        let rhs_storage = _args.1
        if _storage._requestID != rhs_storage._requestID {return false}
        if _storage._code != rhs_storage._code {return false}
        if _storage._reason != rhs_storage._reason {return false}
        if _storage._data != rhs_storage._data {return false}
        if _storage._relayedRequest != rhs_storage._relayedRequest {return false}
        if _storage._requesterID != rhs_storage._requesterID {return false}
        return true
      }
      if !storagesAreEqual {return false}
    }
    if lhs.unknownFields != rhs.unknownFields {return false}
    return true
  }
}

extension TurmsNotification.DataMessage: SwiftProtobuf.Message, SwiftProtobuf._MessageImplementationBase, SwiftProtobuf._ProtoNameProviding {
  public static let protoMessageName: String = TurmsNotification.protoMessageName + ".Data"
  public static let _protobuf_nameMap: SwiftProtobuf._NameMap = [
    1: .same(proto: "ids"),
    2: .standard(proto: "ids_with_version"),
    3: .same(proto: "url"),
    4: .same(proto: "acknowledge"),
    5: .same(proto: "session"),
    6: .same(proto: "messages"),
    7: .standard(proto: "message_statuses"),
    8: .standard(proto: "messages_with_total_list"),
    9: .standard(proto: "users_infos_with_version"),
    10: .standard(proto: "users_online_statuses"),
    11: .standard(proto: "user_friend_requests_with_version"),
    12: .standard(proto: "user_relationship_groups_with_version"),
    13: .standard(proto: "user_relationships_with_version"),
    14: .standard(proto: "group_invitations_with_version"),
    15: .standard(proto: "group_join_question_answer_result"),
    16: .standard(proto: "group_join_requests_with_version"),
    17: .standard(proto: "group_join_questions_with_version"),
    18: .standard(proto: "group_members_with_version"),
    19: .standard(proto: "groups_with_version"),
  ]

  fileprivate class _StorageClass {
    var _kind: TurmsNotification.DataMessage.OneOf_Kind?

    static let defaultInstance = _StorageClass()

    private init() {}

    init(copying source: _StorageClass) {
      _kind = source._kind
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
        case 1:
          var v: Int64Values?
          if let current = _storage._kind {
            try decoder.handleConflictingOneOf()
            if case .ids(let m) = current {v = m}
          }
          try decoder.decodeSingularMessageField(value: &v)
          if let v = v {_storage._kind = .ids(v)}
        case 2:
          var v: Int64ValuesWithVersion?
          if let current = _storage._kind {
            try decoder.handleConflictingOneOf()
            if case .idsWithVersion(let m) = current {v = m}
          }
          try decoder.decodeSingularMessageField(value: &v)
          if let v = v {_storage._kind = .idsWithVersion(v)}
        case 3:
          var v: SwiftProtobuf.Google_Protobuf_StringValue?
          if let current = _storage._kind {
            try decoder.handleConflictingOneOf()
            if case .url(let m) = current {v = m}
          }
          try decoder.decodeSingularMessageField(value: &v)
          if let v = v {_storage._kind = .url(v)}
        case 4:
          var v: Acknowledge?
          if let current = _storage._kind {
            try decoder.handleConflictingOneOf()
            if case .acknowledge(let m) = current {v = m}
          }
          try decoder.decodeSingularMessageField(value: &v)
          if let v = v {_storage._kind = .acknowledge(v)}
        case 5:
          var v: Session?
          if let current = _storage._kind {
            try decoder.handleConflictingOneOf()
            if case .session(let m) = current {v = m}
          }
          try decoder.decodeSingularMessageField(value: &v)
          if let v = v {_storage._kind = .session(v)}
        case 6:
          var v: Messages?
          if let current = _storage._kind {
            try decoder.handleConflictingOneOf()
            if case .messages(let m) = current {v = m}
          }
          try decoder.decodeSingularMessageField(value: &v)
          if let v = v {_storage._kind = .messages(v)}
        case 7:
          var v: MessageStatuses?
          if let current = _storage._kind {
            try decoder.handleConflictingOneOf()
            if case .messageStatuses(let m) = current {v = m}
          }
          try decoder.decodeSingularMessageField(value: &v)
          if let v = v {_storage._kind = .messageStatuses(v)}
        case 8:
          var v: MessagesWithTotalList?
          if let current = _storage._kind {
            try decoder.handleConflictingOneOf()
            if case .messagesWithTotalList(let m) = current {v = m}
          }
          try decoder.decodeSingularMessageField(value: &v)
          if let v = v {_storage._kind = .messagesWithTotalList(v)}
        case 9:
          var v: UsersInfosWithVersion?
          if let current = _storage._kind {
            try decoder.handleConflictingOneOf()
            if case .usersInfosWithVersion(let m) = current {v = m}
          }
          try decoder.decodeSingularMessageField(value: &v)
          if let v = v {_storage._kind = .usersInfosWithVersion(v)}
        case 10:
          var v: UsersOnlineStatuses?
          if let current = _storage._kind {
            try decoder.handleConflictingOneOf()
            if case .usersOnlineStatuses(let m) = current {v = m}
          }
          try decoder.decodeSingularMessageField(value: &v)
          if let v = v {_storage._kind = .usersOnlineStatuses(v)}
        case 11:
          var v: UserFriendRequestsWithVersion?
          if let current = _storage._kind {
            try decoder.handleConflictingOneOf()
            if case .userFriendRequestsWithVersion(let m) = current {v = m}
          }
          try decoder.decodeSingularMessageField(value: &v)
          if let v = v {_storage._kind = .userFriendRequestsWithVersion(v)}
        case 12:
          var v: UserRelationshipGroupsWithVersion?
          if let current = _storage._kind {
            try decoder.handleConflictingOneOf()
            if case .userRelationshipGroupsWithVersion(let m) = current {v = m}
          }
          try decoder.decodeSingularMessageField(value: &v)
          if let v = v {_storage._kind = .userRelationshipGroupsWithVersion(v)}
        case 13:
          var v: UserRelationshipsWithVersion?
          if let current = _storage._kind {
            try decoder.handleConflictingOneOf()
            if case .userRelationshipsWithVersion(let m) = current {v = m}
          }
          try decoder.decodeSingularMessageField(value: &v)
          if let v = v {_storage._kind = .userRelationshipsWithVersion(v)}
        case 14:
          var v: GroupInvitationsWithVersion?
          if let current = _storage._kind {
            try decoder.handleConflictingOneOf()
            if case .groupInvitationsWithVersion(let m) = current {v = m}
          }
          try decoder.decodeSingularMessageField(value: &v)
          if let v = v {_storage._kind = .groupInvitationsWithVersion(v)}
        case 15:
          var v: GroupJoinQuestionsAnswerResult?
          if let current = _storage._kind {
            try decoder.handleConflictingOneOf()
            if case .groupJoinQuestionAnswerResult(let m) = current {v = m}
          }
          try decoder.decodeSingularMessageField(value: &v)
          if let v = v {_storage._kind = .groupJoinQuestionAnswerResult(v)}
        case 16:
          var v: GroupJoinRequestsWithVersion?
          if let current = _storage._kind {
            try decoder.handleConflictingOneOf()
            if case .groupJoinRequestsWithVersion(let m) = current {v = m}
          }
          try decoder.decodeSingularMessageField(value: &v)
          if let v = v {_storage._kind = .groupJoinRequestsWithVersion(v)}
        case 17:
          var v: GroupJoinQuestionsWithVersion?
          if let current = _storage._kind {
            try decoder.handleConflictingOneOf()
            if case .groupJoinQuestionsWithVersion(let m) = current {v = m}
          }
          try decoder.decodeSingularMessageField(value: &v)
          if let v = v {_storage._kind = .groupJoinQuestionsWithVersion(v)}
        case 18:
          var v: GroupMembersWithVersion?
          if let current = _storage._kind {
            try decoder.handleConflictingOneOf()
            if case .groupMembersWithVersion(let m) = current {v = m}
          }
          try decoder.decodeSingularMessageField(value: &v)
          if let v = v {_storage._kind = .groupMembersWithVersion(v)}
        case 19:
          var v: GroupsWithVersion?
          if let current = _storage._kind {
            try decoder.handleConflictingOneOf()
            if case .groupsWithVersion(let m) = current {v = m}
          }
          try decoder.decodeSingularMessageField(value: &v)
          if let v = v {_storage._kind = .groupsWithVersion(v)}
        default: break
        }
      }
    }
  }

  public func traverse<V: SwiftProtobuf.Visitor>(visitor: inout V) throws {
    try withExtendedLifetime(_storage) { (_storage: _StorageClass) in
      switch _storage._kind {
      case .ids(let v)?:
        try visitor.visitSingularMessageField(value: v, fieldNumber: 1)
      case .idsWithVersion(let v)?:
        try visitor.visitSingularMessageField(value: v, fieldNumber: 2)
      case .url(let v)?:
        try visitor.visitSingularMessageField(value: v, fieldNumber: 3)
      case .acknowledge(let v)?:
        try visitor.visitSingularMessageField(value: v, fieldNumber: 4)
      case .session(let v)?:
        try visitor.visitSingularMessageField(value: v, fieldNumber: 5)
      case .messages(let v)?:
        try visitor.visitSingularMessageField(value: v, fieldNumber: 6)
      case .messageStatuses(let v)?:
        try visitor.visitSingularMessageField(value: v, fieldNumber: 7)
      case .messagesWithTotalList(let v)?:
        try visitor.visitSingularMessageField(value: v, fieldNumber: 8)
      case .usersInfosWithVersion(let v)?:
        try visitor.visitSingularMessageField(value: v, fieldNumber: 9)
      case .usersOnlineStatuses(let v)?:
        try visitor.visitSingularMessageField(value: v, fieldNumber: 10)
      case .userFriendRequestsWithVersion(let v)?:
        try visitor.visitSingularMessageField(value: v, fieldNumber: 11)
      case .userRelationshipGroupsWithVersion(let v)?:
        try visitor.visitSingularMessageField(value: v, fieldNumber: 12)
      case .userRelationshipsWithVersion(let v)?:
        try visitor.visitSingularMessageField(value: v, fieldNumber: 13)
      case .groupInvitationsWithVersion(let v)?:
        try visitor.visitSingularMessageField(value: v, fieldNumber: 14)
      case .groupJoinQuestionAnswerResult(let v)?:
        try visitor.visitSingularMessageField(value: v, fieldNumber: 15)
      case .groupJoinRequestsWithVersion(let v)?:
        try visitor.visitSingularMessageField(value: v, fieldNumber: 16)
      case .groupJoinQuestionsWithVersion(let v)?:
        try visitor.visitSingularMessageField(value: v, fieldNumber: 17)
      case .groupMembersWithVersion(let v)?:
        try visitor.visitSingularMessageField(value: v, fieldNumber: 18)
      case .groupsWithVersion(let v)?:
        try visitor.visitSingularMessageField(value: v, fieldNumber: 19)
      case nil: break
      }
    }
    try unknownFields.traverse(visitor: &visitor)
  }

  public static func ==(lhs: TurmsNotification.DataMessage, rhs: TurmsNotification.DataMessage) -> Bool {
    if lhs._storage !== rhs._storage {
      let storagesAreEqual: Bool = withExtendedLifetime((lhs._storage, rhs._storage)) { (_args: (_StorageClass, _StorageClass)) in
        let _storage = _args.0
        let rhs_storage = _args.1
        if _storage._kind != rhs_storage._kind {return false}
        return true
      }
      if !storagesAreEqual {return false}
    }
    if lhs.unknownFields != rhs.unknownFields {return false}
    return true
  }
}
