package sharkbound.commonutilities.collections

class DefaultMutableMap<K, V>(val default: (K) -> V) : LinkedHashMap<K, V>() {
    override fun get(key: K): V {
        if (contains(key)) {
            return super.get(key)!!
        }

        val value = default(key)
        put(key, value)

        return value
    }

    fun orNull(key: K): V? = super.get(key)
}

fun <K, V> defaultMutableMapOf(vararg pairs: Pair<K, V>, default: (K) -> V): DefaultMutableMap<K, V> =
    DefaultMutableMap(default).apply { putAll(pairs) }

fun <K, V> Map<K, V>.toDefaultMutableMap(default: (K) -> V): DefaultMutableMap<K, V> =
    DefaultMutableMap(default).also { it.putAll(this) }