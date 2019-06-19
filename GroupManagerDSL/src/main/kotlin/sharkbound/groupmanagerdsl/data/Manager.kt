package sharkbound.groupmanagerdsl.data

import kotlinx.serialization.Serializable
import kotlinx.serialization.UnstableDefault
import sharkbound.commonutils.Maybe
import sharkbound.commonutils.extensions.len
import sharkbound.commonutils.toMaybe
import sharkbound.groupmanagerdsl.FilePaths
import sharkbound.groupmanagerdsl.json
import java.lang.IllegalArgumentException
import java.nio.file.Files
import java.nio.file.Path

@Serializable
class Manager(val groups: MutableList<UserGroup> = mutableListOf()) {
    val members: Sequence<Member>
        get() = groups.asSequence().flatMap { it.members.asSequence() }

    @UnstableDefault
    fun save() {
        Files.write(FilePaths.config, json.stringify(serializer(), this).toByteArray())
    }

    inline fun groupMatches(block: (UserGroup) -> Boolean): Boolean =
        groups.any(block)

    inline fun memberMatches(block: (Member) -> Boolean): Boolean =
        members.any(block)

    inline fun findGroup(block: (UserGroup) -> Boolean): Maybe<UserGroup> =
        groups.firstOrNull(block).toMaybe

    fun findGroupByName(name: String): Maybe<UserGroup> =
        findGroup { it.name == name }

    inline fun findMember(block: (Member) -> Boolean): Maybe<Member> =
        members.firstOrNull(block).toMaybe

    fun findMemberByName(name: String): Maybe<Member> =
        findMember { it.name == name }

    fun add(group: UserGroup): Boolean =
        groups.add(group)

    fun remove(group: UserGroup): Boolean =
        groups.remove(group)

    operator fun iterator(): MutableIterator<UserGroup> =
        groups.iterator()

    operator fun contains(value: Any): Boolean = when (value) {
        is String -> groupMatches { it.name == value }
        is UserGroup -> groupMatches { it.name == value.name }
        else -> throw IllegalArgumentException("`value` must be ether of type $String or $UserGroup")
    }

    override fun toString(): String {
        return "Manager(len=${groups.len})"
    }
}