package sharkbound.commonutilities.events

import sharkbound.commonutilities.extensions.len
import kotlin.concurrent.thread

class Event<T> {
    val subscribers = mutableListOf<(T) -> Unit>()
    val subscriberCount get() = subscribers.len

    fun add(func: (T) -> Unit): Event<T> = apply {
        subscribers.add(func)
    }

    fun remove(func: (T) -> Unit): Event<T> = apply {
        if (contains(func)) {
            subscribers.remove(func)
        }
    }

    operator fun contains(func: (T) -> Unit): Boolean =
        func in subscribers

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

    operator fun plusAssign(func: (T) -> Unit) {
        add(func)
    }

    operator fun minusAssign(func: (T) -> Unit) {
        remove(func)
    }
}

