package sharkbound.swingdsl.util

import sharkbound.swingdsl.builders.FontBuilder
import java.awt.Font

inline fun buildFont(block: FontBuilder.() -> Unit): Font =
    FontBuilder().apply(block).font