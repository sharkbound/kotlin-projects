package sharkbound.commonutils.collections


class Counter<T>(val collection: Collection<T>) {
    private val counts = mutableMapOf<T, Int>()
    private val sorted = mutableListOf<T>()

    init {
        collection.forEach {
            counts.compute(it) { k_, value -> (value ?: 0) + 1 }
            if (it !in sorted) {
                sorted += it
            }
        }
        sorted.sortByDescending { counts[it] }
    }

    fun mostCommon(n: Int) = sorted.slice(0 until n)

    operator fun get(key: T) = counts.getOrDefault(key, 0)
    override fun toString() = counts.toString()
}

val <T> Collection<T>.toCounter get() = Counter(this)