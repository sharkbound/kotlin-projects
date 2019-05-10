@file:Suppress("unused")

package sharkbound.commonutils

import sharkbound.commonutils.exceptions.ValueNotSetException
import sharkbound.commonutils.extensions.asMaybe

class Maybe<T>(private val _value: T? = null) {
    val valueOrNull: T? = _value
    val hasValue: Boolean = _value != null
    val value: T by lazy { _value ?: throw ValueNotSetException() }

    infix fun matches(other: T): Boolean =
        hasValue && value == other

    inline infix fun matches(predicate: (T) -> Boolean): Boolean =
        hasValue && predicate(value)

    infix fun notMatches(other: T): Boolean =
        hasValue && value != other

    inline infix fun notMatches(predicate: (T) -> Boolean): Boolean =
        hasValue && !predicate(value)

    inline infix fun ifAbsent(ifNull: () -> Unit) {
        if (!hasValue) {
            ifNull()
        }
    }

    inline infix fun ifPresent(ifNotNull: (T) -> Unit) {
        if (hasValue) {
            ifNotNull(value)
        }
    }

    inline fun ifMatches(other: T, block: (T) -> Unit) {
        if (matches(other)) {
            block(value)
        }
    }


    inline fun ifMatches(predicate: (T) -> Boolean, block: (T) -> Unit) {
        if (hasValue && predicate(value)) {
            block(value)
        }
    }

    inline fun ifNotMatches(other: T, block: () -> Unit) {
        if (!matches(other)) {
            block()
        }
    }

    inline fun ifNotMatches(predicate: (T) -> Boolean, block: (T) -> Unit) {
        if (hasValue && !predicate(value)) {
            block(value)
        }
    }

    inline infix fun <R> mapIfPresent(operation: (T) -> R): Maybe<R> =
        if (hasValue)
            operation(value).asMaybe
        else
            nullMaybe()

    inline infix fun <R> mapIfAbsent(operation: () -> R): Maybe<R> =
        if (!hasValue)
            Maybe(operation())
        else
            nullMaybe()

    inline infix fun <R> map(operation: (T?) -> R): Maybe<R> = operation(valueOrNull).asMaybe

    inline fun filter(predicate: (T) -> Boolean): Maybe<T> =
        if (hasValue && predicate(value))
            this
        else
            nullMaybe()

    inline fun filterNot(predicate: (T) -> Boolean): Maybe<T> =
        if (hasValue && !predicate(value))
            this
        else
            nullMaybe()

    inline fun matchesOrDefault(other: T, default: () -> T): T =
        if (matches(other)) value else default()

    inline fun matchesOrDefault(predicate: (T) -> Boolean, default: () -> T): T =
        if (hasValue && predicate(value))
            value
        else
            default()

    fun matchesOrDefault(other: T, default: T): T =
        if (matches(other)) value else default

    fun notMatchesOrDefault(other: T, default: T): T =
        if (!matches(other)) value else default

    inline fun notMatchesOrDefault(other: T, default: () -> T): T =
        if (!matches(other)) value else default()

    inline fun notMatchesOrDefault(predicate: (T) -> Boolean, default: () -> T): T =
        if (hasValue && !predicate(value))
            value
        else
            default()


    infix fun orDefault(default: T): T = valueOrNull ?: default
    inline infix fun orDefault(default: () -> T): T = valueOrNull ?: default()

    override fun toString(): String = "Maybe<$_value>"
    override fun equals(other: Any?): Boolean {
        if (other == null) {
            return false
        }
        if (other is Maybe<*>) {
            return hasValue && other.hasValue && value == other.value
        }
        return hasValue && value == other
    }

    override fun hashCode(): Int {
        var result = valueOrNull?.hashCode() ?: 0
        result = 31 * result + hasValue.hashCode()
        return result
    }

}

fun <T> maybeOf(value: T): Maybe<T> = Maybe(value)
fun <T> nullMaybe(): Maybe<T> = Maybe()
fun <T> nullMaybe(ignored: T): Maybe<T> = Maybe()