package sharkbound.commonutils.events

import sharkbound.commonutils.extensions.len
import kotlin.concurrent.thread

class Event<T> {
    private val subscribers = mutableListOf<(T) -> Unit>()
    val subscriberCount get() = subscribers.len

    fun add(func: (T) -> Unit) {
        subscribers += func
    }

    fun remove(func: (T) -> Unit) {
        if (func in subscribers) {
            subscribers -= func
        }
    }

    operator fun invoke(arg: T, threaded: Boolean = false) {
        fun trigger() {
            subscribers.forEach {
                it(arg)
            }
        }

        if (threaded) {
            thread { trigger() }
        } else {
            trigger()
        }
    }

    operator fun plusAssign(func: (T) -> Unit) = add(func)
    operator fun minusAssign(func: (T) -> Unit) = remove(func)
}

