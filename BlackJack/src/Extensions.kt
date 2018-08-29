import java.util.concurrent.ThreadLocalRandom

val r = ThreadLocalRandom.current()

fun <T> ArrayList<T>.pop(index: Int? = null): T {
    val item = get(index ?: r.nextInt(size))
    remove(item)
    return item
}