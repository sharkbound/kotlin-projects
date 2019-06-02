package sharkbound.groupmanager.models

import sharkbound.groupmanager.enums.UserType
import java.io.Serializable

open class Member(
    open var name: String,
    open var email: Email,
    open var phone: Phone,
    open var age: Int,
    open var type: UserType
) : Serializable {
    open override fun toString() = "${name.capitalize()} | $email | $phone | $type"
}
