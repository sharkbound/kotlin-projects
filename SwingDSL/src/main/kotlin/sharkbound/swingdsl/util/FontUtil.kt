package sharkbound.swingdsl.util

import java.awt.Font

fun style(bold: Boolean = false, italic: Boolean = false, plain: Boolean = false): Int {
    return 0
        .or(if (bold) Font.BOLD else 0)
        .or(if (italic) Font.ITALIC else 0)
        .or(if (plain) Font.PLAIN else 0)
}
