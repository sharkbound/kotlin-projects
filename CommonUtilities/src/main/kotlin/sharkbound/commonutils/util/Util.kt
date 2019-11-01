package sharkbound.commonutils.util

inline fun <T> ifElse(value: Boolean, ifTrue: () -> T, ifFalse: () -> T): T =
    if (value) ifTrue() else ifFalse()