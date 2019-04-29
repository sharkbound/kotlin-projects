package sharkbound.commonutils.util

fun <T> flatten(vararg iterables: Iterable<T>) = sequence {
    iterables.forEach { yieldAll(it) }
}

fun <T> flatten(vararg sequences: Sequence<T>) = sequence {
    sequences.forEach { yieldAll(it) }
}

fun <T> flattenToList(vararg iterables: Iterable<T>): List<T> = iterables.flatMap { it }

fun <T> flattenToList(vararg sequences: Sequence<T>): List<T> = sequences.flatMap { it.asIterable() }