package sharkbound.swingdsl.util

import java.awt.Font

fun style(bold: Boolean = false, italic: Boolean = false): Int =
    0 or (if (bold) Font.BOLD else 0) or (if (italic) Font.ITALIC else 0)

