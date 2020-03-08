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

package im.turms.turms.property.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.IdentifiedDataSerializable;
import im.turms.turms.annotation.constraint.CronConstraint;
import im.turms.turms.config.hazelcast.IdentifiedDataFactory;
import im.turms.turms.property.MutablePropertiesView;
import jdk.jfr.Description;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import java.io.IOException;

@Data
public class User implements IdentifiedDataSerializable {
    @Valid
    private Location location = new Location();
    @Valid
    private SimultaneousLogin simultaneousLogin = new SimultaneousLogin();
    @Valid
    private FriendRequest friendRequest = new FriendRequest();
    @JsonView(MutablePropertiesView.class)
    @Description("The cron expression to specify the time to log online users' number")
    @CronConstraint
    public String onlineUsersNumberPersisterCron = "0 0/5 * * * ?";
    @JsonView(MutablePropertiesView.class)
    @Description("Whether to use the operating system class as the device type instead of the agent class")
    private boolean shouldUseOsAsDefaultDeviceType = true;
    @JsonView(MutablePropertiesView.class)
    @Description("Whether to respond to client with the OFFLINE status if a user is in INVISIBLE status")
    private boolean shouldRespondOfflineIfInvisible = false;
    @JsonView(MutablePropertiesView.class)
    @Description("Whether to delete the two-sided relationships when a user requests to delete a relationship")
    private boolean shouldDeleteTwoSidedRelationships = false;
    //TODO
    @JsonView(MutablePropertiesView.class)
    @Description("Whether to delete a user logically")
    private boolean shouldDeleteUserLogically = true;

    @JsonIgnore
    @Override
    public int getFactoryId() {
        return IdentifiedDataFactory.FACTORY_ID;
    }

    @JsonIgnore
    @Override
    public int getClassId() {
        return IdentifiedDataFactory.Type.PROPERTY_USER.getValue();
    }

    @Override
    public void writeData(ObjectDataOutput out) throws IOException {
        location.writeData(out);
        simultaneousLogin.writeData(out);
        friendRequest.writeData(out);
        out.writeUTF(onlineUsersNumberPersisterCron);
        out.writeBoolean(shouldUseOsAsDefaultDeviceType);
        out.writeBoolean(shouldDeleteTwoSidedRelationships);
        out.writeBoolean(shouldDeleteUserLogically);
    }

    @Override
    public void readData(ObjectDataInput in) throws IOException {
        location.readData(in);
        simultaneousLogin.readData(in);
        friendRequest.readData(in);
        onlineUsersNumberPersisterCron = in.readUTF();
        shouldUseOsAsDefaultDeviceType = in.readBoolean();
        shouldDeleteTwoSidedRelationships = in.readBoolean();
        shouldDeleteUserLogically = in.readBoolean();
    }

    @Data
    public static class Location implements IdentifiedDataSerializable {
        @Description("Whether to handle users' locations")
        private boolean enabled = true;
        @JsonView(MutablePropertiesView.class)
        @Description("Whether to persist users' locations")
        private boolean persistent = true;
        @JsonView(MutablePropertiesView.class)
        @Description("The default maximum available number of users nearby records per query request")
        @Min(0)
        private int defaultMaxAvailableUsersNearbyNumberPerQuery = 20;
        @JsonView(MutablePropertiesView.class)
        @Description("The default maximum distance per query request")
        @DecimalMin("0")
        private double defaultMaxDistancePerQuery = 0.1;
        @JsonView(MutablePropertiesView.class)
        @Description("The maximum allowed available number of users nearby records per query request")
        @Min(0)
        private int maxAvailableUsersNearbyNumberLimitPerQuery = Integer.MAX_VALUE;
        @JsonView(MutablePropertiesView.class)
        @Description("The maximum allowed distance per query request")
        @DecimalMin("0")
        private double maxDistanceLimitPerQuery = Double.MAX_VALUE;

        @Description("Whether to treat the pair of user ID and device type as an unique user when querying users nearby. If false, only the user ID is used to identify an unique user")
        private boolean treatUserIdAndDeviceTypeAsUniqueUser = false;

        @JsonIgnore
        @Override
        public int getFactoryId() {
            return IdentifiedDataFactory.FACTORY_ID;
        }

        @JsonIgnore
        @Override
        public int getClassId() {
            return IdentifiedDataFactory.Type.PROPERTY_USER_LOCATION.getValue();
        }

        @Override
        public void writeData(ObjectDataOutput out) throws IOException {
            out.writeBoolean(enabled);
            out.writeBoolean(persistent);
            out.writeInt(defaultMaxAvailableUsersNearbyNumberPerQuery);
            out.writeDouble(defaultMaxDistancePerQuery);
            out.writeInt(maxAvailableUsersNearbyNumberLimitPerQuery);
            out.writeDouble(maxDistanceLimitPerQuery);
        }

        @Override
        public void readData(ObjectDataInput in) throws IOException {
            enabled = in.readBoolean();
            persistent = in.readBoolean();
            defaultMaxAvailableUsersNearbyNumberPerQuery = in.readInt();
            defaultMaxDistancePerQuery = in.readDouble();
            maxAvailableUsersNearbyNumberLimitPerQuery = in.readInt();
            maxDistanceLimitPerQuery = in.readDouble();
        }
    }

    @Data
    public static class FriendRequest implements IdentifiedDataSerializable {
        /**
         * if 0, there is no length limit.
         */
        @JsonView(MutablePropertiesView.class)
        @Description("The maximum allowed length for the text of a friend request")
        private int contentLimit = 200;
        @JsonView(MutablePropertiesView.class)
        @Description("Whether to delete expired automatically")
        private boolean shouldDeleteExpiredRequestsAutomatically = false;
        @JsonView(MutablePropertiesView.class)
        @Description("Whether to allow resending a friend request after the previous request has been declined, ignored, or expired")
        private boolean allowResendingRequestAfterDeclinedOrIgnoredOrExpired = false;
        @JsonView(MutablePropertiesView.class)
        @Description("A friend request will become expired after the TTL has elapsed. 0 means infinite")
        private int friendRequestTimeToLiveHours = 30 * 24;

        @JsonIgnore
        @Override
        public int getFactoryId() {
            return IdentifiedDataFactory.FACTORY_ID;
        }

        @JsonIgnore
        @Override
        public int getClassId() {
            return IdentifiedDataFactory.Type.PROPERTY_USER_FRIEND_REQUEST.getValue();
        }

        @Override
        public void writeData(ObjectDataOutput out) throws IOException {
            out.writeInt(contentLimit);
            out.writeBoolean(shouldDeleteExpiredRequestsAutomatically);
            out.writeBoolean(allowResendingRequestAfterDeclinedOrIgnoredOrExpired);
            out.writeInt(friendRequestTimeToLiveHours);
        }

        @Override
        public void readData(ObjectDataInput in) throws IOException {
            contentLimit = in.readInt();
            shouldDeleteExpiredRequestsAutomatically = in.readBoolean();
            allowResendingRequestAfterDeclinedOrIgnoredOrExpired = in.readBoolean();
            friendRequestTimeToLiveHours = in.readInt();
        }
    }

    @Data
    public static class SimultaneousLogin implements IdentifiedDataSerializable {
        @JsonView(MutablePropertiesView.class)
        @Description("The simultaneous login strategy to control which devices can be online at the same time")
        private SimultaneousLoginStrategy strategy = SimultaneousLoginStrategy.ALLOW_ONE_DEVICE_OF_DESKTOP_AND_ONE_DEVICE_OF_MOBILE_ONLINE;
        @JsonView(MutablePropertiesView.class)
        @Description("The conflict strategy handles what should do if a device is ready to be online while its conflicted devices have been online")
        private ConflictStrategy conflictStrategy = ConflictStrategy.FORCE_LOGGED_IN_DEVICES_OFFLINE;
        @JsonView(MutablePropertiesView.class)
        @Description("Whether to allow unknown devices coexist with known devices")
        private boolean allowUnknownDeviceCoexistsWithKnownDevice = false;

        @JsonIgnore
        @Override
        public int getFactoryId() {
            return IdentifiedDataFactory.FACTORY_ID;
        }

        @JsonIgnore
        @Override
        public int getClassId() {
            return IdentifiedDataFactory.Type.PROPERTY_USER_SIMULTANEOUS_LOGIN.getValue();
        }

        @Override
        public void writeData(ObjectDataOutput out) throws IOException {
            out.writeInt(strategy.ordinal());
            out.writeInt(conflictStrategy.ordinal());
            out.writeBoolean(allowUnknownDeviceCoexistsWithKnownDevice);
        }

        @Override
        public void readData(ObjectDataInput in) throws IOException {
            strategy = SimultaneousLoginStrategy.values()[in.readInt()];
            conflictStrategy = ConflictStrategy.values()[in.readInt()];
            allowUnknownDeviceCoexistsWithKnownDevice = in.readBoolean();
        }

        public enum SimultaneousLoginStrategy {
            ALLOW_ONE_DEVICE_OF_ONE_DEVICE_TYPE_ONLINE,
            ALLOW_ONE_DEVICE_OF_EVERY_DEVICE_TYPE_ONLINE,
            ALLOW_ONE_DEVICE_OF_DESKTOP_AND_ONE_DEVICE_OF_MOBILE_ONLINE,
            ALLOW_ONE_DEVICE_OF_DESKTOP_OR_WEB_AND_ONE_DEVICE_OF_MOBILE_ONLINE,
            ALLOW_ONE_DEVICE_OF_DESKTOP_AND_ONE_DEVICE_OF_WEB_AND_ONE_DEVICE_OF_MOBILE_ONLINE,
            ALLOW_ONE_DEVICE_OF_DESKTOP_OR_MOBILE_ONLINE,
            ALLOW_ONE_DEVICE_OF_DESKTOP_OR_WEB_OR_MOBILE_ONLINE
        }

        public enum ConflictStrategy {
            FORCE_LOGGED_IN_DEVICES_OFFLINE,
            // ACQUIRE_LOGGED_IN_DEVICES_PERMISSION,
            LOGGING_IN_DEVICE_OFFLINE
        }
    }
}