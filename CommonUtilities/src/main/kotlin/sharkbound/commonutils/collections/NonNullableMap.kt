package sharkbound.commonutils.collections

import java.util.function.BiFunction

open class NonNullableMap<K, V> : LinkedHashMap<K, V>() {
    private val errMsg = "attempt to put a key to a immutable map of type: ${this.javaClass.name}"

    internal fun initialize(map: Map<K, V>) =
        apply { super.putAll(map) }

    override fun putAll(from: Map<out K, V>) =
        throw RuntimeException(errMsg)

    override fun put(key: K, value: V): V? =
        throw RuntimeException(errMsg)

    override fun putIfAbsent(key: K, value: V): V? =
        throw RuntimeException(errMsg)

    override fun compute(key: K, remappingFunction: BiFunction<in K, in V?, out V?>): V? =
        throw RuntimeException(errMsg)

    override fun get(key: K): V =
        super.get(key) ?: throw NoSuchElementException("missing key: $key")

    fun orNull(key: K): V? = super.get(key)
}

fun <K, V> nonNullableMapOf(vararg pairs: Pair<K, V>): NonNullableMap<K, V> =
    NonNullableMap<K, V>().initialize(mapOf(*pairs))

val <K, V> Map<K, V>.toNonNullableMap: NonNullableMap<K, V>
    get() = NonNullableMap<K, V>().initialize(this)
