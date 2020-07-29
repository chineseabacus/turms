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
// source: request/user/relationship/query_friend_requests_request.proto

package im.turms.common.model.dto.request.user.relationship;

public interface QueryFriendRequestsRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:im.turms.proto.QueryFriendRequestsRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>bool are_sent_by_me = 1;</code>
   * @return The areSentByMe.
   */
  boolean getAreSentByMe();

  /**
   * <code>.google.protobuf.Int64Value last_updated_date = 2;</code>
   * @return Whether the lastUpdatedDate field is set.
   */
  boolean hasLastUpdatedDate();
  /**
   * <code>.google.protobuf.Int64Value last_updated_date = 2;</code>
   * @return The lastUpdatedDate.
   */
  com.google.protobuf.Int64Value getLastUpdatedDate();
  /**
   * <code>.google.protobuf.Int64Value last_updated_date = 2;</code>
   */
  com.google.protobuf.Int64ValueOrBuilder getLastUpdatedDateOrBuilder();
}
