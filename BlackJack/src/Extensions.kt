import java.util.concurrent.ThreadLocalRandom

val r = ThreadLocalRandom.current()

fun <T> ArrayList<T>.pop(index: Int? = null): T {
    val item = this[index ?: lastIndex]
    removeAt(lastIndex)
    return item
}