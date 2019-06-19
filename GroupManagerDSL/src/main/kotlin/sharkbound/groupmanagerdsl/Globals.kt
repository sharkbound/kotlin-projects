package sharkbound.groupmanagerdsl

import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json
import sharkbound.groupmanagerdsl.data.Manager
import java.nio.file.Files
import java.nio.file.Path

var nextGroupID: Int = -1
    get() = ++field

var nextMemberID: Int = -1
    get() = ++field

@UnstableDefault
val json = Json.indented

object FilePaths {
    val config = Path.of("groups.json")
}

object Menus {
    const val groupInfo = "group info"
    const val memberInfo = "member info"
    const val addGroup = "add group"
    val all = listOf(groupInfo, addGroup)
}

@UnstableDefault
val mgr by lazy {
    if (Files.exists(FilePaths.config))
        json.parse(Manager.serializer(), Files.readString(FilePaths.config))
    else
        Manager()
}

@UnstableDefault
inline fun saveAfter(block: Manager.() -> Unit) {
    mgr.block()
    mgr.save()
}