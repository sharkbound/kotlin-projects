package adventure.data

import adventure.models.Scene
import adventure.rooms.MainScene

var scenes = mutableMapOf<String, Scene>()

fun sceneExist(id: String): Boolean = id in scenes

fun getScene(id: String): Scene = scenes.getValue(id)

fun addScene(scene: Scene): Scene {
    scenes[scene.id] = scene
    return scene
}

fun addScenes(vararg scenes: Scene) {
    scenes.forEach { addScene(it) }
}

fun tryGetScene(id: String): Maybe<Scene> = Maybe(scenes[id])

fun loadScenes() {
    addScenes(MainScene())
}