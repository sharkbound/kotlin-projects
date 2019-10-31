package sharkbound.commonutils.extensions

import sharkbound.commonutils.rand
import sharkbound.commonutils.util.randRange
import java.util.*

val Collection<*>.len get() = size
val Array<*>.len get() = size
val Map<*, *>.len get() = size
val Set<*>.len get() = size
val String.len get() = length
val Vector<*>.len get() = size
val Vector<*>.cap get() = capacity()

inline fun <T> Iterator<T>.forEachApply(operation: T.() -> Unit) {
    for (item in this) {
        item.operation()
    }
}

inline fun <T> Iterable<T>.forEachApply(operation: T.() -> Unit) =
    iterator().forEachApply(operation)

inline fun <T> Sequence<T>.forEachApply(operation: T.() -> Unit) =
    iterator().forEachApply(operation)

fun <T> Collection<T>.choice(): T = elementAt(rand.nextInt(len))
fun <T> Collection<T>.choices(count: Int): List<T> = (1..count).map { choice() }.toList()
fun <T> Collection<T>.sample(count: Int): List<T> {
    require(count <= len) { "count must be <= the length of the collection" }
    if (count == len - 1) {
        return shuffled()
    }

    val seen = mutableSetOf<Int>()
    val out = mutableListOf<T>()

    while (seen.len < count) {
        val index = randRange(len)
        if (index in seen) {
            continue
        }

        val value = elementAt(index)
        seen.add(index)
        out.add(value)
    }

    return out
}