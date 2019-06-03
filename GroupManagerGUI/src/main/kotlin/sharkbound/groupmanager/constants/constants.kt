@file:Suppress("MemberVisibilityCanBePrivate")

package sharkbound.groupmanager.constants

import sharkbound.groupmanager.models.GroupManager

enum class Screen(val key: String) {
    GROUP_INFO("Group Info"),
    MEMBER_INFO("Member Info"),
    EDIT_GROUP("Edit Group"),
    EDIT_MEMBER("Edit Member"),
    ADD_GROUP("Add Group"),
    ADD_MEMBER("Add Member"),
    REMOVE_GROUP("Remove Group"),
    REMOVE_MEMBER("Remove Member");

    override fun toString() = key
}

object Data {
    const val CONFIG_FILE = "groups.dat"
    const val MAIN_WINDOW_TITLE = "Group Editor"
    val allPanelNames = Screen.values().asSequence().map { it.key }.toSet()
}

val manager by lazy { GroupManager.load() }

fun session(block: GroupManager.() -> Unit): Unit =
    manager.saveAfter(block)