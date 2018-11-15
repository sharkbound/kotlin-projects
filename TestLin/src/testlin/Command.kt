package testlin

@Target(AnnotationTarget.FUNCTION)
annotation class Command(val prefix: String, val name: String)

val commandArgsSplitRegex: Regex = """["].+?["]|[^ ]+""".toRegex()
val commands: MutableMap<String, RunnableCommand> = mutableMapOf()

data class Message(val body: String) {
    var args: List<String>
        private set

    val command: String
    val hasArgs get() = args.isNotEmpty()

    init {
        val parts = commandArgsSplitRegex.findAll(body).values('"')

        args = parts.drop(1)
        command = parts[0]
    }

    operator fun get(i: Int): String = args[i]
}

class RunnableCommand(val command: Command, val handler: (Message) -> ExecutionResult) {
    val fullName = (command.prefix + command.name).trim()

    fun exec(args: Message): ExecutionResult = handler(args)
}
