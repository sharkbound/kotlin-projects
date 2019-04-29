package sharkbound.commonutils

/**
 * returns a boolean indicating if the receiver is null
 */
val Any?.isNull inline get() = this == null

/**
 * returns a boolean indicating if the receiver is not null
 */
val Any?.isNotNull inline get() = this != null