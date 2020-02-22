import Constants from '../helper/constants';
import TurmsClient from '../../src/turms-client';
import TurmsStatusCode from '../../src/model/turms-status-code'
import {im} from '../../src/model/proto-bundle';
import UserStatus = im.turms.proto.UserStatus;
import DeviceType = im.turms.proto.DeviceType;
import GroupMemberRole = im.turms.proto.GroupMemberRole;

const GROUP_MEMBER_ID = '3';
const GROUP_INVITATION_INVITEE = '4';
const GROUP_SUCCESSOR = '1';
const GROUP_BLACKLISTED_USER_ID = '5';
let turmsClient: TurmsClient;
let groupId;
let groupJoinQuestionId;
let groupJoinRequestId;
let groupInvitationId;

beforeAll(async () => {
    turmsClient = new TurmsClient(Constants.WS_URL);
    await turmsClient.driver.connect('1', "123", null, UserStatus.BUSY, DeviceType.BROWSER);
});

afterAll(() => {
    if (turmsClient.driver.connected()) {
        turmsClient.driver.disconnect();
    }
});

describe('Constructor', () => {
    it('Constructor', () => {
        expect(turmsClient.groupService).toBeTruthy();
    })
});

describe('Create', () => {
    it('createGroup_shouldReturnGroupId', async () => {
        groupId = await turmsClient.groupService.createGroup("name", "intro", "announcement", null, 10)
        expect(groupId).toBeTruthy();
    });
    it('addGroupJoinQuestion_shouldReturnQuestionId', async () => {
        groupJoinQuestionId = await turmsClient.groupService.addGroupJoinQuestion(groupId, "question", ["answer1", "answer2"], 10);
        expect(groupJoinQuestionId).toBeTruthy();
    });
    it('createJoinRequest_shouldReturnJoinRequestId', async () => {
        groupJoinRequestId = await turmsClient.groupService.createJoinRequest(groupId, "content");
        expect(groupJoinRequestId).toBeTruthy();
    });
    it('addGroupMember_shouldSucceed', async () => {
        const result = await turmsClient.groupService.addGroupMember(groupId, GROUP_MEMBER_ID, "name", GroupMemberRole.MEMBER);
        expect(result).toBeUndefined();
    });
    it('blacklistUser_shouldSucceed', async () => {
        const result = await turmsClient.groupService.blacklistUser(groupId, GROUP_BLACKLISTED_USER_ID);
        expect(result).toBeUndefined();
    });
    it('createInvitation_shouldReturnInvitationId', async () => {
        groupInvitationId = await turmsClient.groupService.createInvitation(groupId, GROUP_INVITATION_INVITEE, "content");
        expect(groupInvitationId).toBeTruthy();
    });
});

describe('Update', () => {
    it('updateGroup_shouldSucceed', async () => {
        const result = await turmsClient.groupService.updateGroup(groupId, "name", "intro", "announcement", null, 10);
        expect(result).toBeUndefined();
    });
    it('muteGroup_shouldSucceed', async () => {
        const result = await turmsClient.groupService.muteGroup(groupId, new Date());
        expect(result).toBeUndefined();
    });
    it('unmuteGroup_shouldSucceed', async () => {
        const result = await turmsClient.groupService.unmuteGroup(groupId);
        expect(result).toBeUndefined();
    });
    it('updateGroupJoinQuestion_shouldSucceed', async () => {
        const result = await turmsClient.groupService.updateGroupJoinQuestion(groupId, "new-question", ["answer"]);
        expect(result).toBeUndefined();
    });
    it('updateGroupMemberInfo_shouldSucceed', async () => {
        const result = await turmsClient.groupService.updateGroupMemberInfo(groupId, GROUP_MEMBER_ID, "myname");
        expect(result).toBeUndefined();
    });
    it('muteGroupMember_shouldSucceed', async () => {
        const result = await turmsClient.groupService.muteGroupMember(groupId, GROUP_MEMBER_ID, new Date(new Date().getTime() + 100000));
        expect(result).toBeUndefined();
    });
    it('unmuteGroupMember_shouldSucceed', async () => {
        const result = await turmsClient.groupService.unmuteGroupMember(groupId, GROUP_MEMBER_ID);
        expect(result).toBeUndefined();
    });
});

describe('Query', () => {
    it('queryGroup_shouldGroupWithVersion', async () => {
        const groupWithVersion = await turmsClient.groupService.queryGroup(groupId);
        expect(groupWithVersion.group.id).toEqual(groupId);
    });
    it('queryJoinedGroupsIds_shouldEqualNewGroupId', async () => {
        const joinedGroupsIdsWithVersion = await turmsClient.groupService.queryJoinedGroupsIds();
        expect(joinedGroupsIdsWithVersion.ids).toContain(groupId);
    });
    it('queryJoinedGroupsInfos_shouldEqualNewGroupId', async () => {
        const groupWithVersion = await turmsClient.groupService.queryJoinedGroupsInfos();
        let groupIds = groupWithVersion.groups.map(group => group.id);
        expect(groupIds).toContain(groupId);
    });
    it('queryBlacklistedUsersIds_shouldEqualBlacklistedUserId', async () => {
        const blacklistedUsersIdsWithVersion = await turmsClient.groupService.queryBlacklistedUsersIds(groupId);
        expect(blacklistedUsersIdsWithVersion.ids[0]).toEqual(GROUP_BLACKLISTED_USER_ID);
    });
    it('queryBlacklistedUsersInfos_shouldEqualBlacklistedUserId', async () => {
        const usersInfosWithVersion = await turmsClient.groupService.queryBlacklistedUsersInfos(groupId);
        expect(usersInfosWithVersion.userInfos[0].id).toEqual(GROUP_BLACKLISTED_USER_ID);
    });
    it('queryInvitations_shouldEqualNewInvitationId', async () => {
        const groupInvitationsWithVersion = await turmsClient.groupService.queryInvitations(groupId);
        expect(groupInvitationsWithVersion.groupInvitations[0].id).toEqual(groupInvitationId);
    });
    it('queryJoinRequests_shouldEqualNewJoinRequestId', async () => {
        const groupJoinRequestsWithVersion = await turmsClient.groupService.queryJoinRequests(groupId);
        expect(groupJoinRequestsWithVersion.groupJoinRequests[0].id).toEqual(groupJoinRequestId);
    });
    it('queryGroupJoinQuestionsRequest_shouldEqualNewGroupQuestionId', async () => {
        const groupJoinQuestionsWithVersion = await turmsClient.groupService.queryGroupJoinQuestionsRequest(groupId, true);
        expect(groupJoinQuestionsWithVersion.groupJoinQuestions[0].id).toEqual(groupJoinQuestionId);
    });
    it('queryGroupMembers_shouldEqualNewMemberId', async () => {
        const groupMembersWithVersion = await turmsClient.groupService.queryGroupMembers(groupId, true);
        expect(groupMembersWithVersion.groupMembers[1].userId).toEqual(GROUP_MEMBER_ID);
    });
    it('queryGroupMembersByMembersIds_shouldEqualNewMemberId', async () => {
        const groupMembersWithVersion = await turmsClient.groupService.queryGroupMembersByMembersIds(groupId, [GROUP_MEMBER_ID], true);
        expect(groupMembersWithVersion.groupMembers[0].userId).toEqual(GROUP_MEMBER_ID);
    });
    it('answerGroupQuestions_shouldEqualNewQuestionId', async () => {
        const map = {};
        map[groupJoinQuestionId] = "answer";
        try {
            expect(await turmsClient.groupService.answerGroupQuestions(map)).toBeTruthy();
        } catch (e) {
            expect(e.code).toEqual(TurmsStatusCode.ALREADY_GROUP_MEMBER);
        }
    });
});

describe('Delete', () => {
    it('removeGroupMember_shouldSucceed', async () => {
        const result = await turmsClient.groupService.removeGroupMember(groupId, GROUP_MEMBER_ID);
        expect(result).toBeUndefined();
    });
    it('unblacklistUser_shouldSucceed', async () => {
        const result = await turmsClient.groupService.unblacklistUser(groupId, GROUP_BLACKLISTED_USER_ID);
        expect(result).toBeUndefined();
    });
    it('deleteInvitation_shouldSucceedOrThrowDisabledFunction', async () => {
        try {
            expect(await turmsClient.groupService.deleteInvitation(groupInvitationId)).toBeTruthy();
        } catch (e) {
            expect(e.code).toEqual(TurmsStatusCode.DISABLED_FUNCTION);
        }
    });
    it('deleteInvitation_shouldSucceedOrThrowDisabledFunction', async () => {
        try {
            expect(await turmsClient.groupService.deleteJoinRequest(groupJoinRequestId)).toBeTruthy();
        } catch (e) {
            expect(e.code).toEqual(TurmsStatusCode.DISABLED_FUNCTION);
        }
    });
    it('quitGroup_shouldSucceed', async () => {
        const result = await turmsClient.groupService.quitGroup(groupId, null, false);
        expect(result).toBeUndefined();
    });
    it('deleteGroup_shouldSucceed', async () => {
        const readyToDeleteGroupId = await turmsClient.groupService.createGroup('readyToDelete');
        const result = await turmsClient.groupService.deleteGroup(readyToDeleteGroupId)
        expect(result).toBeUndefined();
    });
});

describe('Update - Last', () => {
    it('transferOwnership_shouldSucceed', async () => {
        const result = await turmsClient.groupService.transferOwnership(groupId, GROUP_SUCCESSOR, true);
        expect(result).toBeUndefined();
    });
});