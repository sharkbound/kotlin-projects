package sharkbound.commonutilities.events

import sharkbound.commonutilities.extensions.len

class AsyncEvent<T> {
    val subscribers = mutableListOf<suspend (T) -> Unit>()
    val subscriberCount get() = subscribers.len

    fun add(func: suspend (T) -> Unit): AsyncEvent<T> = apply {
        subscribers.add(func)
    }

    fun remove(func: suspend (T) -> Unit): AsyncEvent<T> = apply {
        if (contains(func)) {
            subscribers.remove(func)
        }
    }

    operator fun contains(func: suspend (T) -> Unit): Boolean =
        func in subscribers

    suspend operator fun invoke(arg: T) {
        subscribers.forEach {
            it(arg)
        }
    }

    operator fun plusAssign(func: suspend (T) -> Unit) {
        add(func)
    }

    operator fun minusAssign(func: suspend (T) -> Unit) {
        remove(func)
    }
}

