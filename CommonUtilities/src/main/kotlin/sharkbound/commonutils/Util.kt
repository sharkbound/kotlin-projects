package sharkbound.commonutils

fun <T> flatten(vararg iterables: Iterable<T>) = sequence {
    iterables.forEach { yieldAll(it) }
}

fun <T> flattenToList(vararg iterables: Iterable<T>): List<T> = iterables.flatMap { it }