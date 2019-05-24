package sharkbound.groupmanager.constants

import sharkbound.groupmanager.models.GroupManager

const val CONFIG_FILE = "groups.dat"
const val MAIN_WINDOW_TITLE = "Group Editor"
const val GROUP_INFO = "Group Info"
const val MEMBER_INFO = "Member Info"
const val EDIT_GROUP = "Edit Group"
const val EDIT_MEMBER = "Edit Member"
const val ADD_GROUP = "Add Group"
const val ADD_MEMBER = "Add Member"
const val REMOVE_GROUP = "Remove Group"
const val REMOVE_MEMBER = "Remove Member"

val manager by lazy { GroupManager.load() }