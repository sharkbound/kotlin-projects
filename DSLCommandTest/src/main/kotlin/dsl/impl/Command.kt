package dsl.impl

import dsl.data.Args

open class Command {
    open lateinit var handler: Args.() -> Unit
    open var name: String = throw NotImplementedError()
    open var prefix = "!"

    open val fullName get() = prefix + name

    open fun execute(args: Args) = args.handler()

    override fun toString(): String = fullName
}