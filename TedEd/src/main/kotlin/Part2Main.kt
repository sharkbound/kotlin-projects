import sharkbound.commonutils.extensions.choice
import sharkbound.commonutils.extensions.sample
import sharkbound.commonutils.util.randInt

infix fun Int.has(other: Int) = and(other) == other

fun Int.flags() =
    allFlags.filter { (_, i) -> and(i) == i }.joinToString(" | ") { it.first }

object Features {
    const val RED_HAIR = 1 shl 0
    const val GREEN_EYES = 1 shl 1
    const val GLASSES = 1 shl 2
}

val allFlags =
    listOf("GLASSES" to Features.GLASSES, "GREEN_EYES" to Features.GREEN_EYES, "RED_HAIR" to Features.RED_HAIR)

val reConsecutive = """(\w)\1""".toRegex()
val names = listOf(
    "jimmy",
    "skillar",
    "alaster",
    "kali",
    "olsta"
)

class Person(val name: String, val features: Int = 0) {
    val vowels = name.sumBy { if (it.toLowerCase() in "aeiouy") 1 else 0 }
    val hasConsecutiveLetters = reConsecutive.findAll(name).sumBy { 1 } != 0

    companion object {
        val bits = listOf(Features.GLASSES, Features.RED_HAIR, Features.GREEN_EYES).toList()
        fun random(): Person {
            return Person(names.choice(), bits.sample(randInt(1, 3)).sum())
        }
    }

    infix fun has(flag: Int) = features has flag
    infix fun notHas(flag: Int) = !features.has(flag)

    override fun toString(): String {
        return "[$name: ${features.flags()}, $vowels, $hasConsecutiveLetters]"
    }

    fun isLeader(): Boolean {
        val out = mutableListOf<Boolean>()

        if (!has(Features.GREEN_EYES) && (has(Features.GLASSES) && vowels != 2))
            return false
        if (has(Features.GLASSES))
            out += vowels == 2
        if (notHas(Features.GLASSES))
            out += vowels == 3
        if (has(Features.RED_HAIR))
            out += hasConsecutiveLetters

        return out.all { it }
    }
}

fun main() {
    val people =
        (1..10).map { Person.random() } + listOf(
            Person(
                "vaal",
                Features.GLASSES or Features.RED_HAIR or Features.GREEN_EYES
            )
        )

    val validPeople = people
        .filter { it.isLeader() }

    println(validPeople.first())
}