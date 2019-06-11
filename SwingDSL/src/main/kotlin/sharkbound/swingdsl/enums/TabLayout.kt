package sharkbound.swingdsl.enums

import javax.swing.JTabbedPane

enum class TabLayout(val value: Int) {
    SCROLL(JTabbedPane.SCROLL_TAB_LAYOUT),
    WRAP(JTabbedPane.WRAP_TAB_LAYOUT)
}