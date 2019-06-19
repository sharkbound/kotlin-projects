package sharkbound.groupmanagerdsl.data

import kotlinx.serialization.Serializable
import sharkbound.commonutils.Maybe
import sharkbound.commonutils.extensions.len

@Serializable
open class UserGroup(var name: String, val members: MutableList<Member> = mutableListOf()) {
    val len get() = members.len

    fun add(member: Member): Member {
        members.add(member)
        return member
    }

    fun remove(member: Member): Member {
        members.remove(member)
        return member
    }

    operator fun contains(member: String) = members.any { it.name.trim() == member.trim() }
    operator fun iterator() = members.iterator()

    override fun toString(): String {
        return "UserGroup(members=$members)"
    }
}