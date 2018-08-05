interface Command {
    val name: String

    suspend fun exec(args: List<String>)
}