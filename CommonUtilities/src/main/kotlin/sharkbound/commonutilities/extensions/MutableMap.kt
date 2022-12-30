package sharkbound.commonutilities.extensions

/**
 *  ensures a key exists before doing any operations
 *
 *  if the key is missing, the key is passed to [ifMissing] and the new value is set from [ifMissing]'s return value
 *
 *  if the key is present, the old value is passed to [ifPresent] and the new value is set from [ifPresent]'s return value
 *
 *  @param key the key to put the value into
 *  @param ifMissing the value to insert into the map if the key is missing
 *  @param ifPresent the value to insert into the map if the key is present
 */
inline fun <K, V> MutableMap<K, V>.ensureKey(
    key: K,
    ifMissing: (K) -> V,
    ifPresent: (V) -> V
) {
    if (key !in this) {
        put(key, ifMissing(key))
    } else {
        put(key, ifPresent(getValue(key)))
    }
}

/**
 * takes a key and [block], if the key is present the block is called with the value associated with the key as its parameter,
 *  if the [block] returns a non-null value, the key is set to the [block]'s return value
 *
 *  @param key the key to use
 *  @param block a function that takes [V] as its parameter, and returns a nullable [V]
 */
inline fun <K, V> MutableMap<K, V>.ifKeyPresent(key: K, block: (V) -> V?) {
    if (key !in this) return
    this[key] = block(getValue(key)) ?: return
}

/**
 * takes a key and [block], if the key is present the block is called with the value associated with the key as its receiver,
 *  if the [block] returns a non-null value, the key is set to the [block]'s return value
 *
 *  @param key the key to use
 *  @param block a function called with [V] as its receiver, and returns a nullable [V]
 */
inline fun <K, V> MutableMap<K, V>.useIfKeyPresent(key: K, block: V.() -> V?) {
    if (key !in this) return
    this[key] = getValue(key).block() ?: return
}

/**
 * takes a key and [block], if the key is absent the block is called with the absent key as its parameter,
 *  if the [block] returns a non-null value, the key is set to the [block]'s return value
 *
 *  @param key the key to use
 *  @param block a function called with [K] as its parameter, and returns a nullable [V]
 */
inline fun <K, V> MutableMap<K, V>.ifKeyAbsent(key: K, block: (K) -> V?) {
    if (key in this) return
    this[key] = block(key) ?: return
}