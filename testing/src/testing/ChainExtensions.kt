package testing

val <T : Iterable<V>, V> T.toChain
    get() = Chain(listOf(this))


val <T : Iterable<V>, V> T.toIteratorChain
    get() = IteratorChain(listOf(this))