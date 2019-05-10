@file:Suppress("unused")

package sharkbound.commonutils

import sharkbound.commonutils.exceptions.ValueNotSetException
import sharkbound.commonutils.extensions.toMaybe

class Maybe<T>(private val _value: T? = null) {
    /**
     * returns the value if it is present, else null
     */
    val valueOrNull: T? = _value

    /**
     * returns if the value is not null
     *
     * true = value is not null
     * false = value is null
     */
    val isPresent: Boolean = _value != null

    /**
     * returns if the value is null
     *
     * true = value is null
     * false = value is not null
     */
    val isAbsent: Boolean = _value == null

    /**
     * gets the value if it is present (not null), throws [ValueNotSetException] if the value is absent (null)
     *
     * @throws ValueNotSetException if the value is absent (null)
     */
    val value: T by lazy { _value ?: throw ValueNotSetException() }

    /**
     * checks if the value matches [other]
     *
     * if the value is absent(null) false is returned
     *
     * @return true if the value is not null, and matches [other], else false
     */
    infix fun matches(other: T): Boolean =
        isPresent && value == other

    /**
     * checks if the value matches the predicate lambda [predicate]
     *
     * if the value is absent(null) false is returned
     *
     * @return true if the value is not null, and [predicate] return true, else false
     */
    inline infix fun matches(predicate: (T) -> Boolean): Boolean =
        isPresent && predicate(value)

    /**
     * checks if the value does not match [other]
     *
     * returns false if the value is null
     *
     * @return true if the value does not match or is not equal to [other] else false
     */
    infix fun notMatches(other: T): Boolean =
        isPresent && value != other

    /**
     * checks if the value does not match the predicate lambda [predicate]
     *
     * if the value is absent(null) false is returned
     *
     * @return true if the value does not match or is not equal to [predicate] else false
     */
    inline infix fun notMatches(predicate: (T) -> Boolean): Boolean =
        isPresent && !predicate(value)

    /**
     * calls [ifNull] if the value is absent(null)
     */
    inline infix fun ifAbsent(ifNull: () -> Unit) {
        if (isAbsent) {
            ifNull()
        }
    }

    /**
     * calls [ifNotNull] if the value is present(not null)
     */
    inline infix fun ifPresent(ifNotNull: (T) -> Unit) {
        if (isPresent) {
            ifNotNull(value)
        }
    }

    /**
     * calls [block] with the value is present(not null) and it matches [other]
     */
    inline fun ifMatches(other: T, block: (T) -> Unit) {
        if (matches(other)) {
            block(value)
        }
    }

    /**
     * calls [block] if the value is present(not null) and [predicate] returns true
     */
    inline fun ifMatches(predicate: (T) -> Boolean, block: (T) -> Unit) {
        if (isPresent && predicate(value)) {
            block(value)
        }
    }

    /**
     * calls [block] if the value is present(not null) and value does not match [other]
     */
    inline fun ifNotMatches(other: T, block: (T) -> Unit) {
        if (isPresent && !matches(other)) {
            block(value)
        }
    }

    /**
     * calls [block] if the value is present(not null) and [predicate] returns false
     */
    inline fun ifNotMatches(predicate: (T) -> Boolean, block: (T) -> Unit) {
        if (isPresent && !predicate(value)) {
            block(value)
        }
    }

    /**
     *  applies [operation] to the current value if it is present(not null),
     *  then returns it as a new maybe
     *
     *  if the value is absent(null), a empty maybe is returned
     */
    inline infix fun <R> mapIfPresent(operation: (T) -> R?): Maybe<R?> =
        if (isPresent) operation(value).toMaybe else emptyMaybe()

    /**
     *  if the value is absent(null) a new maybe is returned that contains the value from calling [operation]
     *
     *  if the value is present, a empty maybe is returned
     */
    inline infix fun <R> mapIfAbsent(operation: () -> R?): Maybe<R?> =
        if (isAbsent) operation().toMaybe else emptyMaybe()

    /**
     * returns a new maybe from the result of calling [operation] with [valueOrNull]
     */
    inline infix fun <R> map(operation: (T?) -> R?): Maybe<R?> = operation(valueOrNull).toMaybe

    /**
     * returns the current maybe if the filter returns True, else a empty maybe
     */
    inline fun filter(predicate: (T) -> Boolean): Maybe<T> =
        if (isPresent && predicate(value)) this else emptyMaybe()

    /**
     * returns the current maybe if the value is present(not null) and the predicate returns true
     * else returns a new maybe with the value returned from [default]
     */
    inline fun filterOrDefault(predicate: (T) -> Boolean, default: () -> T): Maybe<T> =
        if (isPresent && predicate(value)) this else default().toMaybe

    /**
     * returns the current maybe if the filter returns false, else a empty maybe
     */
    inline fun filterNot(predicate: (T) -> Boolean): Maybe<T> =
        if (isPresent && !predicate(value)) this else emptyMaybe()

    /**
     * returns the current maybe if the value is present(not null) and the predicate returns false
     * else returns a new maybe with the value returned from [default]
     */
    inline fun filterNotOrDefault(predicate: (T) -> Boolean, default: () -> T): Maybe<T> =
        if (isPresent && !predicate(value)) this else default().toMaybe

    /**
     * if the value is present(not null) and the value matches [other], the current value is returned
     * else the return value from [default] is returned
     */
    inline fun matchesOrDefault(other: T, default: () -> T): T =
        if (matches(other)) value else default()

    /**
     * if the value is present(not null) and [predicate] returns true, the current value is returned
     * else the return value from [default] is returned
     */
    inline fun matchesOrDefault(predicate: (T) -> Boolean, default: () -> T): T =
        if (isPresent && predicate(value)) value else default()

    /**
     * if the value is present(not null) and the value matches [other], the current value is returned
     * else [default] is returned
     */
    fun matchesOrDefault(other: T, default: T): T =
        if (matches(other)) value else default

    /**
     * if the value is present(not null) and the value does not match [other], the current value is returned,
     * else [default] is returned
     */
    fun notMatchesOrDefault(other: T, default: T): T =
        if (isPresent && !matches(other)) value else default

    /**
     * if the value is present(not null) and the value does not match [other], the current value is returned,
     * else return value from [default] is returned
     */
    inline fun notMatchesOrDefault(other: T, default: () -> T): T =
        if (isPresent && !matches(other)) value else default()

    /**
     * if the value is present(not null) and [predicate] return false, the current value is returned,
     * else return value from [default] is returned
     */
    inline fun notMatchesOrDefault(predicate: (T) -> Boolean, default: () -> T): T =
        if (isPresent && !predicate(value)) value else default()

    /**
     * if the value is present(not null) the current value is returned,
     * else [default] is returned
     */
    infix fun orDefault(default: T): T =
        valueOrNull ?: default

    /**
     * if the value is present(not null) the current value is returned,
     * else the return value from [default] is returned
     */
    inline infix fun orDefault(default: () -> T): T =
        valueOrNull ?: default()

    override fun toString(): String = "Maybe($_value)"
    override fun equals(other: Any?): Boolean = when (other) {
        null -> false
        is Maybe<*> -> isPresent && other.isPresent && value == other.value
        else -> isPresent && value == other
    }

    override fun hashCode(): Int {
        var result = valueOrNull?.hashCode() ?: 0
        result = 31 * result + isPresent.hashCode()
        return result
    }

}

fun <T> maybeOf(value: T): Maybe<T> = Maybe(value)
fun <T> emptyMaybe(): Maybe<T> = Maybe()
fun <T> emptyMaybe(type: T): Maybe<T> = Maybe()