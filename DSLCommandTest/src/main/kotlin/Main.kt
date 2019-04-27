import dsl.util.buildCommand
import dsl.util.newCommand

fun main() {
    val cmd1 = buildCommand {
        name = "test"
        prefix = "!"
        onExecute {

        }
    }

    val cmd2 = newCommand named "echo" does {

    }
}