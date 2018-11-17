open class Command(val name: String, val prefix: String = "!", val help: String = "") {
    open val fullname = prefix + name.toLowerCase()

    open fun execute(msg: Message): ExecutionResult {
        return ExecutionResult.Success
    }
}

val commands = mutableMapOf<String, Command>()


