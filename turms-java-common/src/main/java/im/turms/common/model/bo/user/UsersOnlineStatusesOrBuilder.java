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
// source: model/user/users_online_statuses.proto

package im.turms.common.model.bo.user;

public interface UsersOnlineStatusesOrBuilder extends
    // @@protoc_insertion_point(interface_extends:im.turms.proto.UsersOnlineStatuses)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .im.turms.proto.UserStatusDetail user_statuses = 1;</code>
   */
  java.util.List<im.turms.common.model.bo.user.UserStatusDetail> 
      getUserStatusesList();
  /**
   * <code>repeated .im.turms.proto.UserStatusDetail user_statuses = 1;</code>
   */
  im.turms.common.model.bo.user.UserStatusDetail getUserStatuses(int index);
  /**
   * <code>repeated .im.turms.proto.UserStatusDetail user_statuses = 1;</code>
   */
  int getUserStatusesCount();
  /**
   * <code>repeated .im.turms.proto.UserStatusDetail user_statuses = 1;</code>
   */
  java.util.List<? extends im.turms.common.model.bo.user.UserStatusDetailOrBuilder> 
      getUserStatusesOrBuilderList();
  /**
   * <code>repeated .im.turms.proto.UserStatusDetail user_statuses = 1;</code>
   */
  im.turms.common.model.bo.user.UserStatusDetailOrBuilder getUserStatusesOrBuilder(
      int index);
}
