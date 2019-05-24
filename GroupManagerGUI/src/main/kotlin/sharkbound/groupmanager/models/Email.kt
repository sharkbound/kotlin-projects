package sharkbound.groupmanager.models

import java.io.Serializable

class Email(var nick: String, var host: String, var domain: String) : Serializable {
    val full get() = "$nick@$host.$domain"
    override fun toString() = full
}
