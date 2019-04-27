package dsl.impl

import dsl.data.Args

class CommandBuilder {
    val command = Command()

    fun onExecute(handler: Args.() -> Unit) {
        command.handler = handler
    }

    var name
        get() = command.name
        set(value) {
            command.name = value
        }

    var prefix
        get() = command.prefix
        set(value) {
            command.prefix = value
        }

    fun build() = command
}