package sharkbound.swingdsl.enums

import javax.swing.JTabbedPane

enum class TabPlacement(val alignment: Int) {
    TOP(JTabbedPane.TOP),
    BOTTOM(JTabbedPane.BOTTOM),
    RIGHT(JTabbedPane.RIGHT),
    LEFT(JTabbedPane.LEFT)
}