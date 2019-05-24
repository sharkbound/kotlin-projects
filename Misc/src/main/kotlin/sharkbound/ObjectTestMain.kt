package sharkbound

fun main() {
    println(items)
}

val items = mutableMapOf<String, Item>()

open class Item(val name: String) {
    init {
        items[name] = this
        println("init: $name")
    }
}

object Potion : Item("sharkbound.Potion") {

}