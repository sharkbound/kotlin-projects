package sharkbound.commonutilities.extensions

import sharkbound.commonutilities.models.Chain
import sharkbound.commonutilities.models.IteratorChain

val <T : Iterable<V>, V> T.asChain
    get() = Chain(listOf(this))


val <T : Iterable<V>, V> T.asIteratorChain
    get() = IteratorChain(listOf(this))






