package sharkbound.commonutils.extensions

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