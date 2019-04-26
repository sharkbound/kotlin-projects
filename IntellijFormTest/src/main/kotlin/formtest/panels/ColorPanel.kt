package formtest.panels

import java.awt.Color
import javax.swing.JPanel

open class ColorPanel(val color: Color) : JPanel() {
    init {
        background = color
        foreground = color
    }
}