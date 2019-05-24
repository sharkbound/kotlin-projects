package sharkbound.groupmanager.models

import java.io.Serializable

class Phone(var areaCode: String, var prefix: String, var line: String) : Serializable {
    val full get() = "($areaCode)$prefix-$line"
    override fun toString() = full
}
