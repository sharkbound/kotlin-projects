import sharkbound.commonutils.extensions.choice
import sharkbound.commonutils.extensions.choices
import sharkbound.commonutils.extensions.sample

infix fun Int.has(other: Int) = and(other) == other

object Features {
    const val RED_HAIR = 1 shl 0
    const val GREEN_EYES = 1 shl 1
    const val GLASSES = 1 shl 2
}


val reConsecutive = """(\w)\1""".toRegex()
val names = listOf(
    "jimmy",
    "skillar",
    "alaster",
    "kali",
    "olsta"
)

data class Person(val name: String, val features: Int = 0) {
    val vowels = name.sumBy { if (it.toLowerCase() in "aeiouy") 1 else 0 }
    val hasConsecutive = reConsecutive.findAll(name).sumBy { 1 } != 0

    companion object {
        val bits = listOf(1, 2, 4).toList()
        fun random(): Person {
            return Person(names.choice(), bits.sample(2).sum())
        }
    }
}

fun main() {
    val people = (1..10).map { Person.random() }
    println(people)
}