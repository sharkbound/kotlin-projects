package sharkbound.commonutils.events

import sharkbound.commonutils.extensions.len
import kotlin.concurrent.thread

class AsyncEvent<T> {
    private val subscribers = mutableListOf<suspend (T) -> Unit>()
    val subscriberCount get() = subscribers.len

    fun add(func: suspend (T) -> Unit) {
        subscribers += func
    }

    fun remove(func: suspend (T) -> Unit) {
        if (func in subscribers) {
            subscribers -= func
        }
    }

    suspend operator fun invoke(arg: T) {
        subscribers.forEach {
            it(arg)
        }
    }

    operator fun plusAssign(func: suspend (T) -> Unit) = add(func)
    operator fun minusAssign(func: suspend (T) -> Unit) = remove(func)
}

