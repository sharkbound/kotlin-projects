package consolemenudsl.data

import sharkbound.commonutils.collections.NonNullableMutableMap

open class Scene(val mgr: Manager, val id: String) {
    val commands = NonNullableMutableMap<String, Command>()

    fun hasCommand(string: String) = string.toLowerCase() in commands
    fun hasCommand(command: Command) = command.name.toLowerCase() in commands

    fun addCommand(command: Command): Boolean {
        if (hasCommand(command)) {
            return false
        }
        commands[command.name] = command
        return true
    }

    open val description get() = ""
    open val prompt get() = "\n>>> "
    open val options get() = commands.values.joinToString("\n") { "${it.name} -> ${it.description}" }
}