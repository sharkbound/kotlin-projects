package sharkbound.commonutilities.extensions

infix fun <T : Comparable<T>> T.max(other: T) = maxOf(this, other)
infix fun <T : Comparable<T>> T.min(other: T) = minOf(this, other)

fun <T : Comparable<T>> T.clampTo(min: T, max: T): T =
    minOf(max, maxOf(this, min))

fun <T : Comparable<T>> clamp(value: T, min: T, max: T): T =
    minOf(max, maxOf(value, min))