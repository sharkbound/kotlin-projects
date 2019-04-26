package colorfultyper.panels

import java.awt.Color
import java.awt.Dimension

class SizedColorPanel(color: Color, w: Int = 0, h: Int = 0) : ColorPanel(color) {
    init {
        preferredSize = Dimension(w, h)
    }
}