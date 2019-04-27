package dsl.impl

import dsl.data.Args

class NamedCommandBuilder {
    private val command = Command()

    infix fun withPrefix(prefix: String) = apply { command.prefix = prefix }
    infix fun named(name: String) = apply { command.name = name }
    infix fun does(handler: Args.() -> Unit): Command = command.apply { this.handler = handler }
}