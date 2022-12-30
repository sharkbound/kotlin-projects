package sharkbound.commonutilities

import java.lang.NullPointerException
import java.util.concurrent.ThreadLocalRandom
import kotlin.random.asKotlinRandom

val rand by lazy {
    ThreadLocalRandom.current()?.asKotlinRandom()
        ?: throw NullPointerException("could not get current ThreadLocalRandom")
}