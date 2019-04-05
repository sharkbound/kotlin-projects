class MissingValueException(override val message: String) : Exception(message)

class Store<TKey, TValue>(vararg _pairs: Pair<TKey, TValue>) {
    private val pairs = mutableMapOf<TKey, TValue>()
    private val _values = mutableSetOf<TValue>()

    val values get() = _values.iterator()
    val keys get() = pairs.keys.iterator()

    init {
        for ((key, value) in _pairs) {
            pairs[key] = value
            _values.add(value)
        }
    }

    operator fun contains(key: TKey) = key in pairs

    fun containsKey(key: TKey) = key in pairs
    fun containsValue(value: TValue) = value in _values

    operator fun set(key: TKey, value: TValue) {
        pairs[key] = value
    }

    operator fun get(key: TKey) = pairs.getValue(key)
    operator fun iterator() = pairs.iterator()

    fun addAll(vararg pairs_: Pair<TKey, TValue>) {
        for ((key, value) in pairs_) {
            set(key, value)
        }
    }

    /**
     * @throws MissingValueException
     */
    fun getKeyFromValue(value: TValue): TKey {
        return pairs.asSequence()
            .filter { it.value == value }
            .ifEmpty { throw MissingValueException("cannot find value $value") }
            .first().key
    }
}


fun main() {
    val store = Store(
        1 to "p@ssw0rd",
        100 to "L0L"
    )

    println(store.getKeyFromValue("p@ssw0rd"))
}