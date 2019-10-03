package sharkbound

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import sharkbound.commonutils.events.AsyncEvent
import sharkbound.commonutils.util.pause

suspend fun main() {
    val asyncEvent = AsyncEvent<String>()
    GlobalScope.launch {
        launch {
            delay(1000)
            println("hi!")
        }
        launch {
            delay(1000)
            println("hi!")
        }
        launch {
            delay(1000)
            println("hi!")
        }
        launch {
            delay(1000)
            println("hi!")
        }
    }
    pause()
}
