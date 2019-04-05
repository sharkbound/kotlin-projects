package testing.extensions

import testing.chain.Chain
import testing.chain.IteratorChain

val <T : Iterable<V>, V> T.toChain
    get() = Chain(listOf(this))


val <T : Iterable<V>, V> T.toIteratorChain
    get() = IteratorChain(listOf(this))