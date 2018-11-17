val commandArgsRegex = """["](.+?)["]|([^ ]+)""".toRegex()

fun parseMessageArgs(raw: String): List<String> =
    commandArgsRegex.findAll(raw).map { it.value.trim('"') }.toList()

class Message(val raw: String) {
    val args: List<String>
    val command: String

    val isCommand get() = command.isRegisteredCommand
    val hasArgs get() = args.isNotEmpty()

    init {
        val tmpArgs = parseMessageArgs(raw)
        command = tmpArgs[0]
        args = tmpArgs.drop(1)
    }
}
