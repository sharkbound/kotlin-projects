package sharkbound.groupmanagerdsl.data

import kotlinx.serialization.Serializable

@Serializable
open class Member(var name: String, var age: Int) {
    override fun toString(): String {
        return "Member(name=\"$name\")"
    }
}