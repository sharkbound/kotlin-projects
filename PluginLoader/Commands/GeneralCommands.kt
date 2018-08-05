class EchoCommand : Command {
    override val name: String
        get() = "echo"

    override suspend fun exec(args: List<String>) {

    }
}

class BanCommand : Command {
    override val name = "ban"

    override suspend fun exec(args: List<String>) {

    }
}

class CustomCommand : Command {
    override val name: String
        get() = "asdsa"

    override suspend fun exec(args: List<String>) {
        TODO("not implemented")
    }
}