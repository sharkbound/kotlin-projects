package sharkbound.commonutils

import sharkbound.commonutils.exceptions.NoValueException

class Maybe<T>(private val _value: T? = null) {
    val valueOrNull: T? = _value
    val hasValue: Boolean = _value != null
    val value: T by lazy { _value ?: throw NoValueException() }

    infix fun matches(other: T) = _value == other
    infix fun notMatches(other: T) = _value != other

    inline infix fun ifValueIsNull(ifNull: () -> Unit) {
        if (valueOrNull == null) {
            ifNull()
        }
    }

    inline infix fun ifValueIsNotNull(ifNotNull: (T) -> Unit) {
        if (valueOrNull != null) {
            ifNotNull(value)
        }
    }

    inline fun ifMatches(other: T, block: (T) -> Unit) {
        if (matches(other)) {
            block(value)
        }
    }


    inline fun ifNotMatches(other: T, block: () -> Unit) {
        if (!matches(other)) {
            block()
        }
    }

    inline fun matchesOrDefault(other: T, default: () -> T): T = if (matches(other)) other else default()
    fun matchesOrDefault(other: T, default: T): T = if (matches(other)) other else default


    infix fun orDefault(default: T) = valueOrNull ?: default
    inline infix fun orDefault(default: () -> T): T = valueOrNull ?: default()
}
