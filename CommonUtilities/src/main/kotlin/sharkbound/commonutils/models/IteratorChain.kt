package sharkbound.commonutils.models

class IteratorChain<T>(iterables: List<Iterable<T>>) : Iterator<T> {
    private val iterator = iterator {
        yieldAll(iterables.asSequence().flatten())
    }

    operator fun plus(other: Iterable<T>) = IteratorChain(listOf(this.asSequence().asIterable(), other))

    override fun hasNext() = iterator.hasNext()
    override fun next(): T = iterator.next()
}