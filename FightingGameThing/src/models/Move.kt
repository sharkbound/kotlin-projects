package fighter.models

interface Move {
    var baseDamage: Double
    fun calculateDamage(caster: Entity, target: Entity): Double
}