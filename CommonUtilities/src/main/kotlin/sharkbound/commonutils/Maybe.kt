@file:Suppress("unused")

package sharkbound.commonutils

import java.lang.Exception

class Maybe<T>(value: T? = null) {
    private val _value: T? = value
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
     * gets the value if it is present (not null), throws [MaybeValueNotSetException] if the value is absent (null)
     *
     * @throws MaybeValueNotSetException if the value is absent (null)
     */
    val valueOrThrow: T by lazy { _value ?: throw MaybeValueNotSetException() }

    /**
     * checks if the value matches [other]
     *
     * if the value is absent(null) false is returned
     *
     * @return true if the value is not null, and matches [other], else false
     */
    infix fun matches(other: T): Boolean =
        valueOrNull == other

    /**
     * checks if the value matches the predicate lambda [predicate]
     *
     * if the value is absent(null) false is returned
     *
     * @return true if the value is not null, and [predicate] return true, else false
     */
    inline infix fun matches(predicate: (T) -> Boolean): Boolean =
        isPresent && predicate(valueOrThrow)

    /**
     * checks if the value does not match [other]
     *
     * returns false if the value is null
     *
     * @return true if the value does not match or is not equal to [other] else false
     */
    infix fun notMatches(other: T): Boolean =
        isPresent && valueOrThrow != other

    /**
     * checks if the value does not match the predicate lambda [predicate]
     *
     * if the value is absent(null) false is returned
     *
     * @return true if value is present and [predicate] returns false, else false
     */
    inline infix fun notMatches(predicate: (T) -> Boolean): Boolean =
        isPresent && !predicate(valueOrThrow)

    /**
     * calls [ifNull] if the value is absent(null), then returns the current maybe (this)
     *
     * @return the current Maybe (this)
     */
    inline infix fun ifAbsent(ifNull: () -> Unit): Maybe<T> =
        apply { if (isAbsent) ifNull() }


    /**
     * calls [ifNotNull] if the value is present(not null), returns the current maybe (this) afterwards
     *
     * @return the current Maybe instance
     */
    inline infix fun ifPresent(ifNotNull: (T) -> Unit): Maybe<T> =
        apply { if (isPresent) ifNotNull(valueOrThrow) }

    /**
     * calls [block] with the value is present(not null) and it matches [other]
     */
    inline fun ifMatches(other: T, block: (T) -> Unit) {
        if (matches(other)) {
            block(valueOrThrow)
        }
    }

    /**
     * calls [block] if the value is present(not null) and [predicate] returns true
     */
    inline fun ifMatches(predicate: (T) -> Boolean, block: (T) -> Unit) {
        if (isPresent && predicate(valueOrThrow)) {
            block(valueOrThrow)
        }
    }

    /**
     * calls [block] if the value is present(not null) and value does not match [other]
     */
    inline fun ifNotMatches(other: T, block: (T) -> Unit) {
        if (isPresent && !matches(other)) {
            block(valueOrThrow)
        }
    }

    /**
     * calls [block] if the value is present(not null) and [predicate] returns false
     */
    inline fun ifNotMatches(predicate: (T) -> Boolean, block: (T) -> Unit) {
        if (isPresent && !predicate(valueOrThrow)) {
            block(valueOrThrow)
        }
    }

    /**
     *  applies [operation] to the current value if it is present(not null),
     *  then returns it as a new maybe
     *
     *  if the value is absent(null), a empty maybe is returned
     *
     *  @return maybe with the value returned from [operation] if the value is present, else a a empty maybe
     */
    inline infix fun <R> mapIfPresent(operation: (T) -> R): Maybe<R> =
        if (isPresent) operation(valueOrThrow).toMaybe else emptyMaybe()

    /**
     *  if the value is absent(null) a new maybe is returned that contains the value from calling [operation]
     *
     *  if the value is present, a empty maybe is returned
     *
     *  @return maybe with the value returned from [operation] if the value is absent, else a a empty maybe
     */
    inline infix fun <R> mapIfAbsent(operation: () -> R): Maybe<R> =
        if (isAbsent) operation().toMaybe else emptyMaybe()

    /**
     * if the value is absent, a new maybe is returned with the value from calling [default]
     *
     * if the value is present, the current maybe (this) is returned
     *
     * @return current maybe (this) if [isPresent] else a new maybe with the value from [default]
     */
    inline infix fun defaultIfAbsent(default: () -> T): Maybe<T> =
        if (isAbsent) default().toMaybe else this


    /**
     * if the value is absent, a new maybe is returned with the value from [default]
     *
     * if the value is present, the current maybe (this) is returned
     *
     * @return current maybe (this) if [isPresent] else a new maybe with the value from [default]
     */
    infix fun defaultIfAbsent(default: T): Maybe<T> =
        if (isAbsent) default.toMaybe else this

    /**
     * returns a new maybe from the result of calling [operation] with [valueOrNull]
     *
     * if [operation] returns null, a empty maybe is returned
     *
     * @return [emptyMaybe] if [operation] returns null, else maybe with the result from calling [operation] with [valueOrNull]
     */
    inline infix fun <R> map(operation: (T?) -> R?): Maybe<R> =
        operation(valueOrNull)?.toMaybe ?: emptyMaybe()

    /**
     * tries to execute [operation], returns emptyMaybe if a error is raised, or it returns null
     *
     * @return emptyMaybe if value [isAbsent] or [operation] throws a exception / returns null
     */
    infix fun <R> tryMap(operation: (T) -> R?): Maybe<R> {
        if (isAbsent) {
            return emptyMaybe()
        }

        return try {
            operation(valueOrThrow).toMaybe
        } catch (e: Exception) {
            emptyMaybe()
        }
    }

    /**
     * tries to execute [operation], if operation throws a exception or return null, [default] is returned
     *
     * @return return from [operation] if it returns non-null, and does not throw any exceptions, else [default]
     */
    inline fun <R> tryOrDefault(operation: (T) -> R?, default: () -> R): R {
        if (isAbsent) {
            return default()
        }

        return try {
            operation(valueOrThrow) ?: return default()
        } catch (e: Exception) {
            default()
        }
    }

    /**
     * tries to execute [operation], if operation throws a exception or return null, [default] is returned
     *
     * @return return from [operation] if it returns non-null, and does not throw any exceptions, else [default]
     */
    inline fun <R> tryOrDefault(operation: (T) -> R?, default: R): R {
        if (isAbsent) {
            return default
        }

        return try {
            operation(valueOrThrow) ?: return default
        } catch (e: Exception) {
            default
        }
    }

    /**
     * applies [operation] to [valueOrNull], if it returns a non-null value, that value is returned as a maybe
     *
     * if [operation] returns null, [default] is called, and its value is returned as a new maybe
     *
     * @return maybe containing the return value from [operation] if it it was not null, else a maybe containing the value returned from [default]
     */
    inline fun <R> mapOrDefault(default: () -> R, operation: (T?) -> R?): Maybe<R> =
        (operation(valueOrNull) ?: default()).toMaybe

    /**
     * applies [operation] to [valueOrNull], if it returns a non-null value, that value is returned as a maybe
     *
     * if [operation] returns null, [default] is returned as a new maybe
     *
     * @return maybe containing the return value from [operation] if it it was not null, else a maybe containing the [default]
     */
    inline fun <R> mapOrDefault(default: R, operation: (T?) -> R?): Maybe<R> =
        (operation(valueOrNull) ?: default).toMaybe

    /**
     * returns the current maybe if the [predicate] returns True, else a empty maybe
     *
     * @return current maybe if value is present and [predicate] returns true else a empty maybe
     */
    inline infix fun filter(predicate: (T) -> Boolean): Maybe<T> =
        if (isPresent && predicate(valueOrThrow)) this else emptyMaybe()

    /**
     * returns the current maybe if the value is present(not null) and the predicate returns true
     * else returns a new maybe with the value returned from [default]
     *
     * @return current maybe if value is present and [predicate] returns true, else a maybe containing the value returned from [default]
     */
    inline fun filterOrDefault(predicate: (T) -> Boolean, default: () -> T): Maybe<T> =
        if (isPresent && predicate(valueOrThrow)) this else default().toMaybe

    /**
     * returns the current maybe if the filter returns false, else a empty maybe
     *
     * @return current maybe if value is present and [predicate] returns false, else a empty maybe
     */
    inline infix fun filterNot(predicate: (T) -> Boolean): Maybe<T> =
        if (isPresent && !predicate(valueOrThrow)) this else emptyMaybe()

    /**
     * returns the current maybe if the value is present(not null) and the predicate returns false
     * else returns a new maybe with the value returned from [default]
     *
     * @return current maybe if value is present and [predicate] returns false, else a maybe that contains the value returned from [default]
     */
    inline fun filterNotOrDefault(predicate: (T) -> Boolean, default: () -> T): Maybe<T> =
        if (isPresent && !predicate(valueOrThrow)) this else default().toMaybe

    /**
     * if the value is present(not null) and the value matches [other], the current value is returned
     * else the return value from [default] is returned
     *
     * @return [valueOrThrow] if value is present and it equals [other], else [default]
     */
    inline fun matchesOrDefault(other: T, default: () -> T): T =
        if (matches(other)) valueOrThrow else default()

    /**
     * if the value is present(not null) and [predicate] returns true, the current value is returned
     * else the return value from [default] is returned
     *
     *  @return [valueOrThrow] if value is present and [predicate] returns true, else [default]
     */
    inline fun matchesOrDefault(predicate: (T) -> Boolean, default: () -> T): T =
        if (isPresent && predicate(valueOrThrow)) valueOrThrow else default()

    /**
     * if the value is present(not null) and the value matches [other], the current value is returned
     * else [default] is returned
     *
     *  @return [valueOrThrow] if value is present and it equals [other], else [default]
     */
    fun matchesOrDefault(other: T, default: T): T =
        if (matches(other)) valueOrThrow else default

    /**
     * if the value is present(not null) and the value does not match [other], the current value is returned,
     * else [default] is returned
     *
     *  @return [valueOrThrow] if value is present and it does not equals [other], else [default]
     */
    fun notMatchesOrDefault(other: T, default: T): T =
        if (isPresent && !matches(other)) valueOrThrow else default

    /**
     * if the value is present(not null) and the value does not match [other], the current value is returned,
     * else return value from [default] is returned
     *
     * @return [valueOrThrow] if value is present and it does not equals [other], else [default]
     */
    inline fun notMatchesOrDefault(other: T, default: () -> T): T =
        if (isPresent && !matches(other)) valueOrThrow else default()

    /**
     * if the value is present(not null) and [predicate] return false, the current value is returned,
     * else return value from [default] is returned
     *
     * @return [valueOrThrow] if value is present and [predicate] returns false, else [default]
     */
    inline fun notMatchesOrDefault(predicate: (T) -> Boolean, default: () -> T): T =
        if (isPresent && !predicate(valueOrThrow)) valueOrThrow else default()

    /**
     * if the value is present(not null) the current value is returned,
     * else [defaultValue] is returned
     *
     * @return [valueOrThrow] if [valueOrThrow] is [isPresent] else [defaultValue]
     */
    infix fun default(defaultValue: T): T =
        valueOrNull ?: defaultValue

    /**
     * if the value is present(not null) the current value is returned,
     * else the return value from [defaultValue] is returned
     *
     * @return [valueOrThrow] if [valueOrThrow] is [isPresent] else [defaultValue]
     */
    inline infix fun default(defaultValue: () -> T): T =
        valueOrNull ?: defaultValue()

    /**
     * operator (*) alias to [filter]
     *
     * @see filter
     */
    operator fun times(predicate: (T) -> Boolean): Maybe<T> = filter(predicate)

    /**
     * operator (+) alias to [mapIfPresent]
     *
     * @see mapIfPresent
     */
    operator fun <R> plus(operation: (T) -> R): Maybe<R> = mapIfPresent(operation)

    /**
     * operator (/) alias to [map]
     *
     * @see map
     */
    operator fun <R> div(operation: (T?) -> R?): Maybe<R> = map(operation)

    /**
     * operator (-) alias to [default]
     *
     * @see default
     */
    operator fun minus(default: () -> T): T = default(default)

    /**
     * operator (-) alias to [default]
     *
     * @see default
     */
    operator fun minus(default: T): T = default(default)


    override fun toString(): String = "Maybe($_value)"

    override fun equals(other: Any?): Boolean = when (other) {
        null -> false
        is Maybe<*> -> isPresent && other.isPresent && valueOrThrow == other.valueOrThrow
        else -> isPresent && valueOrThrow == other
    }

    override fun hashCode(): Int {
        var result = valueOrNull?.hashCode() ?: 0
        result = 31 * result + isPresent.hashCode()
        return result
    }

}

fun <T> maybeOf(value: T?): Maybe<T> = Maybe(value)
fun <T> emptyMaybe(): Maybe<T> = Maybe()

class MaybeValueNotSetException :
    Exception(
        "Maybe has no value set, " +
                "use <maybe>.valueOrNull or `<maybe> default <default>` / `<maybe>.default(<default>) " +
                "to avoid this exception"
    )

val <T> T?.toMaybe get() = Maybe(this)