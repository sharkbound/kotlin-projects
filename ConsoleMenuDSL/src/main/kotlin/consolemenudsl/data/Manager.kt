package consolemenudsl.data

import consolemenudsl.utils.parseArgs
import sharkbound.commonutils.collections.NonNullableMutableMap
import sharkbound.commonutils.extensions.len
import sharkbound.commonutils.extensions.orElse
import sharkbound.commonutils.util.ask
import java.util.*
import kotlin.NoSuchElementException


class Manager {
    val history = LinkedList<Scene>()
    val scenes = NonNullableMutableMap<String, Scene>()
    val current get() = history.last ?: throw NoSuchElementException("history of scenes is empty")
    var running = false

    fun hasScene(id: String) = id.toLowerCase() in scenes
    fun addScene(scene: Scene) {
        scenes[scene.id] = scene
    }

    fun gotoScene(id: String) {
        require(hasScene(id)) { "could not find scene by id: $id" }
        history.add(scenes[id])
    }

    fun gotoPrevious() {
        if (history.len > 1) {
            history.removeLast()
        }
    }

    fun run(initialScene: String) {
        running = true
        gotoScene(initialScene)
        while (running) {
            println(current.description)
            println(current.options)
            val input = ask(current.prompt)
            val args = input.parseArgs(this)

            if (!args.hasCommand) {
                continue
            }

            current.commands.orNull(args.command)?.execute(args).orElse {
                println("no command")
            }
        }
    }
}