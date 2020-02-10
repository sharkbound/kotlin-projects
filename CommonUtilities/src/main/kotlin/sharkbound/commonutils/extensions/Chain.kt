package sharkbound.commonutils.extensions

import sharkbound.commonutils.models.Chain
import sharkbound.commonutils.models.IteratorChain

val <T : Iterable<V>, V> T.asChain
    get() = Chain(listOf(this))


val <T : Iterable<V>, V> T.asIteratorChain
    get() = IteratorChain(listOf(this))






