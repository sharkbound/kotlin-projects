package sharkbound.commonutils.extensions

/**
 *  XOR's both sets, removes elements present in both sets, adds elements in one set but not the other.
 *
 *  mutates the left-hand side [MutableSet]
 *
 *  @param other the set the to XOR the receiver with
 */
infix fun <T> MutableSet<T>.xor(other: Set<T>) {
    for (value in other) {
        if (contains(value)) {
            remove(value)
        } else {
            add(value)
        }
    }
}

/**
 * XOR's two sets and returns a new set that contains elements in one set but not the other
 *
 * @param other the set to XOR with
 * @return new set that contains elements that are in one set but not the other
 */
infix fun <T> Set<T>.xor(other: Set<T>): Set<T> =
    sharkbound.commonutils.util.flatten(this, other)
        .asSequence()
        .filter { (it in this) xor (it in other) }
        .toSet()