package sharkbound.commonutils.extensions

/**
 * returns null if the the receiver is null,
 *
 * else, it returns the result of calling [block]
 */
inline infix fun <T, R> T?.mapIfNotNull(block: (T) -> R?) =
    if (this == null) null else block(this)

/**
 * returns null if the the receiver is null, or [block] return false
 *
 * else, return [this] if the receiver is not null, and [block] returns true
 */
inline infix fun <T> T?.filterIfNotNull(block: (T) -> Boolean) =
    if (this != null && block(this)) this else null


/**
 * returns null if the the receiver is null, or block returns true
 *
 * else, return [this] if the receiver is not null, and [block] returns false
 */
inline infix fun <T> T?.filterNotIfNotNull(block: (T) -> Boolean) =
    if (this != null && !block(this)) this else null

inline infix fun <T> T?.defaultIfNull(block: () -> T) =
    this ?: block()

infix fun <T> T?.defaultIfNull(value: T) =
    this ?: value

inline infix fun <T> T?.notNullAndMatches(match: (T) -> Boolean) =
    if (this != null && match(this)) this else null

inline infix fun <T> T?.notNullAndNotMatches(match: (T) -> Boolean) =
    if (this != null && !match(this)) this else null
