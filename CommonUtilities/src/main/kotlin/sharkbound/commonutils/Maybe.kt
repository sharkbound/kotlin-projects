package sharkbound.commonutils

import sharkbound.commonutils.exceptions.NoValueException
import sharkbound.commonutils.extensions.asMaybe

class Maybe<T>(private val _value: T? = null) {
    val valueOrNull: T? = _value
    val hasValue: Boolean = _value != null
    val value: T by lazy { _value ?: throw NoValueException() }

    infix fun matches(other: T): Boolean = _value == other
    infix fun notMatches(other: T): Boolean = _value != other
    inline fun matches(predicate: (T) -> Boolean): Boolean = valueOrNull != null && predicate(value)

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

    inline infix fun <R> map(operation: (T) -> R): Maybe<R> {
        if (valueOrNull == null) {
            return Maybe()
        }
        return operation(value).asMaybe
    }

    inline fun matchesOrDefault(other: T, default: () -> T): T = if (matches(other)) other else default()
    fun matchesOrDefault(other: T, default: T): T = if (matches(other)) other else default


    infix fun orDefault(default: T) = valueOrNull ?: default
    inline infix fun orDefault(default: () -> T): T = valueOrNull ?: default()
}
