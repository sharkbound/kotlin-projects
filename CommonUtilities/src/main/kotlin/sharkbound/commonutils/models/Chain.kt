package sharkbound.commonutils.models

class Chain<T>(iterables: List<Iterable<T>>) : Iterable<T> {
    private val values = iterables.flatten()

    operator fun plus(other: Iterable<T>) = Chain(listOf(this, other))
    override operator fun iterator() = values.iterator()
    operator fun get(index: Int) = values[index]
    override fun toString() = "[${values.joinToString(", ")}]"
}