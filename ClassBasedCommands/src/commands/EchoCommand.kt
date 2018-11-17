package commands

import Command
import ExecutionResult
import Message

class EchoCommand : Command("echo") {
    override fun execute(msg: Message): ExecutionResult {
        println("hello world!")
        return ExecutionResult.Success
    }
}