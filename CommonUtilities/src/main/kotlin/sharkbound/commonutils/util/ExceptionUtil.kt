package sharkbound.commonutils.util

import java.lang.Exception

/**
 * runs [block] and suppresses [T] if that exception is throw
 *
 * @throws Exception if a exception other than [T] is thrown, the thrown exception can be anything other than [T]
 */
inline fun <reified T : Throwable> suppressException(block: () -> Unit) {
    try {
        block()
    } catch (ex: Exception) {
        if (ex !is T) {
            throw ex
        }
    }
}