package consolemenudsl.dsl

import consolemenudsl.annotations.Dsl
import consolemenudsl.data.Args
import consolemenudsl.data.Command
import java.lang.NullPointerException

@Dsl
class CommandBuilder {
    var name = "MISSING_NAME"
    var description = "NO DESCRIPTION"
    var onExecute: ((Args) -> Unit)? = null

    fun execute(block: (Args) -> Unit) {
        onExecute = block
    }

    inline fun build(init: CommandBuilder.() -> Unit) = run {
        init()
        Command(
            name, description, onExecute ?: throw NullPointerException("command $name does not have a execute function")
        )
    }
}