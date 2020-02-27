package sharkbound.commonutils.extensions

import sharkbound.commonutils.util.randBoolean

/**
 * if the receiver is null, the block is called
 *
 * @param block the function to call if the reciever is null
 */
inline infix fun <T> T?.ifNull(block: () -> Unit): T? {
    if (this == null) {
        block()
    }
    return this
}

/**
 * if the reciever is not null, the block is called with the receiver as the only parameter
 *
 * @param block the function to call if the receiver is not null, this function is passed the receiver as the only parameter
 */
inline infix fun <T> T?.ifNotNull(block: (T) -> Unit): T? {
    if (this != null) {
        block(this)
    }
    return this
}

inline infix fun <T> T?.orElse(defaultIfNull: () -> T): T =
    this ?: defaultIfNull()

infix fun <T> T?.orElse(defaultIfNull: T): T =
    this ?: defaultIfNull

inline infix fun <T> T?.orElseNull(defaultIfNull: () -> T?): T? =
    this ?: defaultIfNull()

infix fun <T> T?.orElseNull(defaultIfNull: T?): T? =
    this ?: defaultIfNull

infix fun <T> T.choice(other: T): T =
    if (randBoolean()) this else other