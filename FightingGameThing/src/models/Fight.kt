package fighter.models

import fighter.choice

class Fight<T : Entity<T>>(vararg entities: T) {
    private val originalEntities = entities
    private lateinit var entities: List<Entity<T>>
    private val alive get() = entities.filter { it.alive }

    fun fight(): Entity<T> {
        entities = originalEntities.map { it.copy() }.sortedByDescending { it.speed }

        while (alive.count() > 1) {
            doRound()
        }

        val winner = alive[0]

        println(entities.joinToString(", ") { it.hp.toString() })
        return winner
    }

    private fun doRound() {
        for (e in alive) {
            val target = entities.filter { it !== e }.choice()
            val dmg = target.damage(e)

            println("${e.name} hit ${target.name} for $dmg hp")

            if (alive.count() == 1) {
                break
            }
        }
    }
}
