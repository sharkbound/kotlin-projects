package adventure.models

import adventure.data.Maybe
import adventure.enums.Direction
import adventure.util.input

/**
 * @param id the id of the room, this is used in the code
 * @param name the name of the room, this is what the user sees
 */
open class Scene(val id: String, var name: String) {
    /**
     * the rooms intractable items
     */
    open val items: ArrayList<Interactable> = arrayListOf()

    /**
     * called when the scene is entered
     * @return a boolean indicating if the room can be entered, default is true
     */
    open fun onEnter(): Boolean = true

    /**
     * called when the room is exited
     * @return a boolean indicating if the room can be exited, default is true
     */
    open fun onExit(): Boolean = true

    /**
     * asks the user for what they want to do, then returns it
     */
    open fun askInput(): String = input("you are currently in $name\n>>> ")

    open fun goDirection(dir: Direction): Maybe<Scene> = Maybe()

    fun equals(scene: Scene) = scene.name == name
    override fun equals(other: Any?) = other is Scene && other == this
    override fun hashCode(): Int = id.hashCode()
    override fun toString(): String = "<Scene type=${javaClass.name} id=$id name=$name>"
}
