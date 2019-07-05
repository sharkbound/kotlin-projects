package sharkbound.commonutils.collections

open class NonNullableMutableMap<K, V> : LinkedHashMap<K, V>() {
    /**
     * @throws NoSuchElementException if the key is absent (missing)
     */
    override fun get(key: K): V =
        super.get(key) ?: throw NoSuchElementException("missing key: $key")

    fun orNull(key: K): V? = super.get(key)
}

fun <K, V> nonNullableMutableMapOf(vararg pairs: Pair<K, V>): NonNullableMutableMap<K, V> =
    NonNullableMutableMap<K, V>().apply { putAll(pairs) }

val <K, V> Map<K, V>.toNonNullableMutableMap: NonNullableMutableMap<K, V>
    get() = NonNullableMutableMap<K, V>().also { it.putAll(this) }
