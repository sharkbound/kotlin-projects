package adventure

import adventure.data.getScene
import adventure.enums.Direction
import adventure.enums.GotoResult
import adventure.models.Scene

object SceneManager {
    var history = arrayListOf<Scene>()

    var running = false

    val current: Scene
        get() = history.last()

    fun goto(scene: Scene): GotoResult {
        if (history.isNotEmpty() && scene == current) {
            return GotoResult.FailedSameRoom
        }

        if (!scene.onEnter()) {
            return GotoResult.FailedEnterNotAllowed
        }

        history.add(scene)
        return GotoResult.Success
    }

    fun run(initialScene: Scene) {
        init(initialScene)

        while (running) {
            val cmd = current.askInput().trim().toLowerCase()

            if (cmd == "quit") {
                running = false
                println("seeya later!")
            }

            val dir = cmd.toDirection()
            if (dir.isNotNull && goInDirection(dir.value)) {
                continue
            }
        }
    }

    private fun goInDirection(dir: Direction): Boolean {
        val newScene = current.goDirection(dir)
        if (newScene.isNull) {
            println("you cannot go ${dir.name} in ${current.name}")
            return false
        }

        goto(newScene.value)
        return true
    }

    private fun init(initialScene: Scene) {
        history.add(initialScene)
        initialScene.onEnter()
        running = true
    }

    fun run(initialSceneName: String) = run(getScene(initialSceneName))
}