package sharkbound.commonutils.extensions

inline infix fun <T, R> T?.mapIfNotNull(block: (T) -> R?) =
    if (this == null) null else block(this)

inline infix fun <T> T?.filterIfNotNull(block: (T) -> Boolean) =
    if (this != null && block(this)) this else null

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
