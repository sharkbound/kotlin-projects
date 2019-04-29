import sharkbound.commonutils.ensureKey
import sharkbound.commonutils.xor

fun main() {
    val m = mutableMapOf(1 to 12, 12 to 1)

    fun addOrInc(key: Int) {
        m.ensureKey(
            key,
            { println("setting $it");it },
            { println("increasing $it"); it + 1 }
        )
    }

    addOrInc(17)
    addOrInc(17)
    addOrInc(17)
    addOrInc(17)
    addOrInc(17)

    println()
}