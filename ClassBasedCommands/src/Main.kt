fun main() {
    registerCommands(
        pkg = "commands",
        root = Thread.currentThread().contextClassLoader.getResource("commands").path
    )
    commands["!echo"]!!.execute(Message("hi"))
}