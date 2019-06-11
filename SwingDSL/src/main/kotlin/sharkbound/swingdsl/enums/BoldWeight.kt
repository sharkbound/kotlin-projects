package sharkbound.swingdsl.enums

import java.awt.font.TextAttribute

enum class BoldWeight(val weight: Float) {
    BOLD(TextAttribute.WEIGHT_BOLD),
    SEMI(TextAttribute.WEIGHT_SEMIBOLD),
    DEMI(TextAttribute.WEIGHT_DEMIBOLD),
    ULTRA(TextAttribute.WEIGHT_ULTRABOLD),
    EXTRA(TextAttribute.WEIGHT_EXTRABOLD),
    NONE(0f)
}