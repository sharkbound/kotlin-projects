package adventure.rooms

import adventure.data.Maybe
import adventure.enums.Direction
import adventure.models.Scene

class MainScene : Scene("starting_room", "starting room") {
    override fun goDirection(dir: Direction): Maybe<Scene> {
        return Maybe()
    }

    override fun onEnter(): Boolean {
        println("entered! :D")
        return true
    }
}