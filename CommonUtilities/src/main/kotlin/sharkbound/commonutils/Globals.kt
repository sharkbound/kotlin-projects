package sharkbound.commonutils

import java.lang.NullPointerException
import java.util.concurrent.ThreadLocalRandom

val rand by lazy {
    ThreadLocalRandom.current() ?: throw NullPointerException("could not get current ThreadLocalRandom")
}