package fighter

import fighter.models.Fight
import fighter.models.Fighter

fun main(args: Array<String>) {
    val f1 = Fighter("player", 100.0, 5.0)
    val f2 = Fighter("cpu", 100.0, 5.0, speed = 2.0)

    val fight = Fight(f1, f2)
    println(fight.fight())
    println(fight.fight())
    println(fight.fight())
}