package sharkbound.groupmanager.models

import sharkbound.commonutils.extensions.len
import java.io.Serializable

open class Group(var name: String, val members: MutableList<Member> = mutableListOf()) : Serializable {
    override fun toString() = "<${this::class.simpleName} len=${members.len}>"
}