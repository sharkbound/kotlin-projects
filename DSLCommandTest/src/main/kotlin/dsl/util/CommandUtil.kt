package dsl.util

import dsl.impl.CommandBuilder
import dsl.impl.NamedCommandBuilder

fun buildCommand(block: CommandBuilder.() -> Unit) = CommandBuilder().apply(block).build()
val newCommand get() = NamedCommandBuilder()