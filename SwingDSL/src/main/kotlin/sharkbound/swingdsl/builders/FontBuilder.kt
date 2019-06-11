package sharkbound.swingdsl.builders

import sharkbound.swingdsl.enums.BoldWeight
import sharkbound.swingdsl.enums.SuperScript
import sharkbound.swingdsl.enums.Underline
import java.awt.Color
import java.awt.Font
import java.awt.Paint
import java.awt.font.TextAttribute

class FontBuilder {
    private var attribs = mutableMapOf<TextAttribute, Any?>()

    var name = "arial"
        set(value) {
            attribs[TextAttribute.FAMILY] = value
            field = value
        }
    var size = 12
        set(value) {
            attribs[TextAttribute.SIZE] = value
            field = value
        }
    var bold = BoldWeight.NONE
        set(value) {
            attribs[TextAttribute.WEIGHT] = value.weight
            field = value
        }
    var strikeThrough = false
        set(value) {
            attribs[TextAttribute.STRIKETHROUGH] = value
            field = value
        }
    var superscript: SuperScript = SuperScript.NONE
        set(value) {
            attribs[TextAttribute.SUPERSCRIPT] = value.value
            field = value
        }
    var underline: Underline = Underline.NONE
        set(value) {
            attribs[TextAttribute.UNDERLINE] = value.value
            field = value
        }
    var italic: Boolean = false
        set(value) {
            attribs[TextAttribute.POSTURE] = if (value) TextAttribute.POSTURE_OBLIQUE else TextAttribute.POSTURE_REGULAR
            field = value
        }
    var fg: Paint = Color.black
        set(value) {
            attribs[TextAttribute.FOREGROUND] = value
            field = value
        }
    var bg: Paint = Color.white
        set(value) {
            attribs[TextAttribute.BACKGROUND] = value
            field = value
        }


    val font: Font
        get() {
            if (TextAttribute.SIZE !in attribs) {
                size = size
            }
            if (TextAttribute.FAMILY !in attribs) {
                name = name
            }
            return Font(attribs)
        }
}