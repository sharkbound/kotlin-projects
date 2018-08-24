package fighter.models

interface Entity {
    val canBeDamaged: Boolean get() = true
    val baseHp: Double get() = hp
    val name: String
    val alive: Boolean get() = hp > 0

    var defence: Double
    var attack: Double
    var hp: Double

    /**
     * @param [dmg] the base damage to base damage calculations off of
     * @param [src] the source of the damage
     * @return the final damage as a [Double] after calculations are applied
     *
     * calculates how much damage [dmg] would do to the current [Entity], then returns it
     */
    fun calculateDamage(dmg: Double, src: Entity): Double = dmg

    /**
     * @param [dmg] the base damage to be applied after doing calculations
     * @param [src] the source of the damage
     *
     * applies [dmg] to the current [Entity] after it is calculated using [calculateDamage]
     */
    fun damage(dmg: Double, src: Entity) {
        hp -= calculateDamage(dmg, src)
    }

    /**
     * @param [dmg] the raw damage to be applied
     * @param [src] the damage source
     *
     * applies the raw [dmg] to the current [Entity]
     */
    fun damageRaw(dmg: Double, src: Entity) {
        hp -= dmg
    }
}