package consolemenudsl.dsl

import consolemenudsl.annotations.Dsl
import consolemenudsl.data.Command
import consolemenudsl.data.Manager
import consolemenudsl.data.Scene
import sharkbound.commonutils.collections.NonNullableMutableMap
import java.lang.NullPointerException

@Dsl
class SceneBuilder {
    val commands = NonNullableMutableMap<String, Command>()
    var mgr: Manager? = null
    var id: String? = null

    inline fun command(block: CommandBuilder.() -> Unit) {
        val command = CommandBuilder().build(block)
        commands[command.name] = command
    }

    inline fun build(init: SceneBuilder.() -> Unit) = run {
        init()
        Scene(
            mgr
                ?: throw NullPointerException("SceneBuilder with id $id must be assigned a Manager, do so with `mgr = ...`"),
            id
                ?: throw NullPointerException("SceneBuilder with $id must have a id assigned, do so with `id = \"...\"`")

        ).also { scene ->
            commands.values.forEach {
                scene.addCommand(it)
            }
        }
    }
}