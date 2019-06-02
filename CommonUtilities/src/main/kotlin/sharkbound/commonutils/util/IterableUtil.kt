package sharkbound.commonutils.util

/**
 *  flattens a series of iterable to a single lazy sequence
 *
 *  @param iterables the series of iterables to fatten
 *  @return sequence of flattened values [T] from [iterables]
 */
fun <T> flatten(vararg iterables: Iterable<T>) = sequence {
    iterables.forEach { yieldAll(it) }
}

/**
 *  flattens a series of sequences to a single lazy sequence
 *
 *  @param sequences the series of sequences to fatten
 *  @return sequence of flattened values [T] from [sequences]
 */
fun <T> flatten(vararg sequences: Sequence<T>) = sequence {
    sequences.forEach { yieldAll(it) }
}

/**
 *  flattens a series of iterables to a single lazy sequence
 *
 *  @param iterators the series of iterators to fatten
 *  @return sequence of flattened values [T] from [iterators]
 */
fun <T> flatten(vararg iterators: Iterator<T>) = sequence {
    iterators.forEach { yieldAll(it) }
}