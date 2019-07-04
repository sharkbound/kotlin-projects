package sharkbound.commonutils.collections

class DefaultMutableMap<K, V>(val default: (K) -> V) : LinkedHashMap<K, V>() {
    override fun get(key: K): V = super.get(key) ?: default(key)
}

fun <K, V> defaultMutableMapOf(vararg pairs: Pair<K, V>, default: (K) -> V): DefaultMutableMap<K, V> =
    DefaultMutableMap(default).apply { putAll(pairs) }

fun <K, V> Map<K, V>.toDefaultMutableMap(default: (K) -> V): DefaultMutableMap<K, V> =
    DefaultMutableMap(default).also { it.putAll(this) }