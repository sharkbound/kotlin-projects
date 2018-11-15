package testlin.commands

import testlin.Command
import testlin.ExecutionResult
import testlin.Message

@Command("!", "echo")
fun cmdEcho(args: Message): ExecutionResult {
    println("ECHO ${args.args.joinToString(", ")}")

    return ExecutionResult.Success
}

@Command("!", "echo2")
fun cmdEcho2(args: Message): ExecutionResult {
    println("ECHO ${args.args.joinToString(", ")}")

    return ExecutionResult.Success
}