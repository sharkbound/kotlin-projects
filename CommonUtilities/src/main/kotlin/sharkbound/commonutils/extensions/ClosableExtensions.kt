package sharkbound.commonutils.extensions

/**
 * executes the [block] in a try, closes the obj after [block] executes
 *
 * @throws Throwable if the block throws a exception
 */
inline infix fun <T : AutoCloseable, R> T.closeAfter(block: T.() -> R): R {
    try {
        return block()
    } catch (ex: Throwable) {
        throw ex
    } finally {
        close()
    }
}