import adventure.SceneManager
import adventure.data.loadScenes

fun main(vararg args: String) {
    loadScenes()

    SceneManager.run("starting_room")
}