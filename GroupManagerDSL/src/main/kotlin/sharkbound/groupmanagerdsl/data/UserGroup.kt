package sharkbound.groupmanagerdsl.data

import kotlinx.serialization.Serializable

@Serializable
open class UserGroup(var name: String, val members: MutableList<Member> = mutableListOf()) {
    override fun toString(): String {
        return "UserGroup(members=$members)"
    }
}