package sharkbound.commonutils.extensions

/**
 * if the receiver is null, the block is called
 *
 * @param block the function to call if the reciever is null
 */
inline infix fun Any?.ifNull(block: () -> Unit) {
    if (this == null) {
        block()
    }
}

/**
 * if the reciever is not null, the block is called with the receiver as the only parameter
 *
 * @param block the function to call if the receiver is not null, this function is passed the receiver as the only parameter
 */
inline infix fun <T> T?.ifNotNull(block: (T) -> Unit) {
    if (this != null) {
        block(this)
    }
}

/**
 * calls the block on the receiver if the receiver is not null
 */
inline infix fun <T> T?.use(block: T.() -> Unit) {
    this?.block()
}

/**
 * calls the block with the receiver as the parameter if the receiver is not null
 */
inline infix fun <T> T?.with(block: (T) -> Unit) {
    if (this != null) {
        block(this)
    }
}

