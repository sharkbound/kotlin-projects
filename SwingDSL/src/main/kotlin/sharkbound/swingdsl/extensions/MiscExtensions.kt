package sharkbound.swingdsl.extensions

import java.awt.Dimension

val Pair<Int, Int>.toDimension: Dimension
    get() = Dimension(first, second)