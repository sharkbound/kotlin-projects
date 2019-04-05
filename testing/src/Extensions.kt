infix fun <T> Set<T>.xor(other: Set<T>): Set<T> {
    return (this + other)
        .asSequence()
        .filter { (it in this) xor (it in other) }
        .toSet()
}

infix fun <T> Set<T>.mutableXor(other: Set<T>): MutableSet<T> {
    return (this + other)
        .asSequence()
        .filter { (it in this) xor (it in other) }
        .toMutableSet()
}