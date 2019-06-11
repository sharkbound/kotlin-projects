package sharkbound.swingdsl.enums

import java.awt.font.TextAttribute

enum class SuperScript(val value: Int) {
    SUPER(TextAttribute.SUPERSCRIPT_SUPER),
    SUB(TextAttribute.SUPERSCRIPT_SUB),
    NONE(0)
}