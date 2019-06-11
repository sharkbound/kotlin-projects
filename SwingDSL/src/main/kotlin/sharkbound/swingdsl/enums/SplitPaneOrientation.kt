package sharkbound.swingdsl.enums

import javax.swing.JSplitPane

enum class SplitPaneOrientation(val value: Int) {
    VERTICAL(JSplitPane.VERTICAL_SPLIT),
    HORIZONTAL(JSplitPane.HORIZONTAL_SPLIT)
}