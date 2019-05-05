package sharkbound.menu

import sharkbound.commonutils.util.ask
import sharkbound.toArguments
import java.util.*

object Manager {
    var running = false
    val history = LinkedList<Menu>()
    var current
        get() = history.peekLast() ?: throw NoMenuException()
        set(value) {
            history.add(value)
        }

    fun back() {
        if (history.size > 1) {
            history.removeLast()
        }
    }

    suspend fun run(initialMenu: Menu) {
        running = true
        current = initialMenu

        while (running) {
            println("\n${current.description}\n")
            current.options.forEach {
                println("${it.key} -> ${it.value.desc}")
            }
            println("\nx -> previous menu")


            val args = ask("\n>>> ").toArguments()
            if (args.first.toLowerCase() == "x") {
                back()
                continue
            }

            if (args.first !in current.options) {
                println("\ninvalid option : ${args.first}")
                ask("press enter to continue\n\n\n")
                continue
            }


            current.options.getValue(args.first).onExecute(args)
        }
    }
}

val currentMenu get() = Manager.current
