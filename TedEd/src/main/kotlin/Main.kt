infix fun Int.has(other: Int) = and(other) == other

object Features {
    const val RED_HAIR = 1 shl 0
    const val GREEN_EYES = 1 shl 1
    const val GLASSES = 1 shl 2
}

val reConsecutive = """(\w)\1""".toRegex()

data class Person(val name: String, val features: Int = 0) {
    val vowels = name.sumBy { if (it.toLowerCase() in "aeiouy") 1 else 0 }
    val hasConsecutive = reConsecutive.findAll(name).sumBy { 1 } != 0

    companion object {
        fun random() = Person()
    }
}

fun main() {
    println(Person("jimm").hasConsecutive)
}