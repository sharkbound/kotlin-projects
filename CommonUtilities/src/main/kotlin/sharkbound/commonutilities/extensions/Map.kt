package sharkbound.commonutilities.extensions

/**
 * takes a key and [block], if the key is present the block is called with the value associated with the key as its parameter,
 *
 * @param key the key to use
 * @param block a function called with [V] as its parameter
 */
inline fun <K, V> Map<K, V>.ifKeyPresent(key: K, block: (V) -> Unit) {
    if (!contains(key)) return
    block(getValue(key))
}

/**
 * takes a key and [block], if the key is present the block is called with the value associated with the key as its receiver
 *
 * @param key the key to use
 * @param block a function called with [V] as its receiver
 */
inline fun <K, V> Map<K, V>.useIfKeyPresent(key: K, block: V.() -> Unit) {
    if (!contains(key)) return
    getValue(key).block()
}