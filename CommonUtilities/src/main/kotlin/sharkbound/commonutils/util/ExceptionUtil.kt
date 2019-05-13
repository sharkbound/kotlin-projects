package sharkbound.commonutils.util

import java.lang.Exception

/**
 * runs [block] and suppresses [T] if that exception is throw
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