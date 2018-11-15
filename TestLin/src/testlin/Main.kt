package testlin

fun main() {
    loadCommands("testlin")

    while (true) {
        print(">>> ")
        val msg = Message(readLine()!!.trim())

        if (msg.command == "exit")
            break

        if (msg.command in commands) {
            val executionResult = commands.getValue(msg.command).exec(msg)
            println("\nRESULT: $executionResult\n")
        }
    }
}

