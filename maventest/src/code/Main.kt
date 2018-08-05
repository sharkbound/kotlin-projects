@file:JvmName("Main")

fun main(args: Array<String>) {
    val p = Player("sharkbound", 1337)
    println(p)
    p.levelUp()
    println(p)
}

class Player(var name: String, var level: Int) {
    fun levelUp(value: Int = 1) {
        level += value
    }

    override fun toString(): String = "Player $name is level $level"
}