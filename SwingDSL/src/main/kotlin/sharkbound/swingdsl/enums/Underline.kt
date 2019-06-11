package sharkbound.swingdsl.enums

import java.awt.font.TextAttribute

enum class Underline(val value: Int) {
    DOTTED(TextAttribute.UNDERLINE_LOW_DOTTED),
    DASHED(TextAttribute.UNDERLINE_LOW_DASHED),
    GRAY(TextAttribute.UNDERLINE_LOW_GRAY),
    STANDARD(TextAttribute.UNDERLINE_ON),
    SOLID_ONE_PIXEL(TextAttribute.UNDERLINE_LOW_ONE_PIXEL),
    SOLID_TWO_PIXEL(TextAttribute.UNDERLINE_LOW_TWO_PIXEL),
    NONE(-1)
}