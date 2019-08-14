package sharkbound.commonutils.extensions

fun <T : Comparable<T>> T.clampTo(min: T, max: T): T =
    minOf(max, maxOf(this, min))

fun <T : Comparable<T>> clamp(value: T, min: T, max: T): T =
    minOf(max, maxOf(value, min))

