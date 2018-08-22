package adventure.data

class Maybe<T>(private val nullableValue: T? = null) {
    val isNull
        get() = nullableValue == null

    val isNotNull
        get() = !isNull

    val value
        get() = nullableValue!!

    fun valueOrDefault(default: T): T = nullableValue ?: default

    operator fun component1(): Boolean = isNotNull
    operator fun component2(): T? = nullableValue
    operator fun not(): Boolean = isNull

    override fun toString(): String = "Maybe { isNull? $isNull }"
}