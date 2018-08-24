package fighter.models

interface Entity<T> {
    val canBeDamaged: Boolean get() = true
    val maxHp: Double get() = hp
    val alive: Boolean get() = hp > 0
    val attack: Double get() = baseAttack
    val name: String

    var baseDefence: Double
    var baseAttack: Double
    var hp: Double
    var speed: Double

    fun calculateDamage(dmg: Double, src: Entity<T>): Double = dmg

    fun damage(dmg: Double, src: Entity<T>): Double {
        val dmgDealt = calculateDamage(dmg, src)
        hp -= dmgDealt
        return dmgDealt
    }

    fun damage(src: Entity<T>) = damage(src.attack, src)

    fun damageRaw(dmg: Double, src: Entity<T>): Double {
        hp -= dmg
        return dmg
    }

    fun damageRaw(src: Entity<T>) = damageRaw(src.attack, src)

    fun copy(): T
}

class Fighter(override val name: String,
              override var baseDefence: Double,
              override var baseAttack: Double,
              override val maxHp: Double = 100.0,
              override var speed: Double = 1.0) : Entity<Fighter> {

    override var hp = maxHp

    override fun copy() = Fighter(name, baseDefence, baseAttack, maxHp)

    override fun toString() = "Fighter { $name $hp }"
}

class Dummy : Entity<Dummy> {
    override val name: String
        get() = "Dummy"

    override var baseDefence: Double
        get() = -1.0
        set(value) {}

    override var baseAttack: Double
        get() = -1.0
        set(value) {}

    override var hp: Double
        get() = -1.0
        set(value) {}

    override var speed: Double
        get() = -1.0
        set(value) {}

    override fun copy(): Dummy = Dummy()
}