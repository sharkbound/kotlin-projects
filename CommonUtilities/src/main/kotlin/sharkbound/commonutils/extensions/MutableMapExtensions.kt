package sharkbound.commonutils.extensions

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