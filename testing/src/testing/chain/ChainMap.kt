package testing.chain

class ChainMap<K, V>(val maps: List<Map<K, V>>) : Map<K, V> {
    override val entries: Set<Map.Entry<K, V>>
        get() = maps.flatMap { it.entries }.toSet()

    override val keys: Set<K>
        get() = maps.flatMap { it.keys }.toSet()

    override val size: Int
        get() = maps.size

    override val values: Collection<V>
        get() = maps.flatMap { it.values }

    override fun containsKey(key: K) = maps.any { key in it }

    override fun containsValue(value: V) = maps.any { it.containsValue(value) }

    override fun isEmpty() = maps.isEmpty() || maps.all { it.isEmpty() }

    override operator fun get(key: K): V {
        for (map in maps) {
            if (key in map) {
                return map.getValue(key)
            }
        }
        throw NoSuchElementException(key.toString())
    }
}