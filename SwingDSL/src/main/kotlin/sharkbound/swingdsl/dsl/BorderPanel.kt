package sharkbound.swingdsl.dsl

import java.awt.BorderLayout
import java.lang.UnsupportedOperationException
import javax.swing.JComponent
import javax.swing.JPanel

class BorderPanel(hGap: Int = 0, vGap: Int = 0) : JPanel(BorderLayout(hGap, vGap)) {
    private val ids = mutableMapOf<String, Any>()

    var center: JComponent
        get() = throw UnsupportedOperationException()
        set(value) {
            add(value, BorderLayout.CENTER)
        }

    var west: JComponent
        get() = throw UnsupportedOperationException()
        set(value) {
            add(value, BorderLayout.WEST)
        }

    var east: JComponent
        get() = throw UnsupportedOperationException()
        set(value) {
            add(value, BorderLayout.EAST)
        }

    var north: JComponent
        get() = throw UnsupportedOperationException()
        set(value) {
            add(value, BorderLayout.NORTH)
        }

    var south: JComponent
        get() = throw UnsupportedOperationException()
        set(value) {
            add(value, BorderLayout.SOUTH)
        }
}

inline fun borderPanel(hGap: Int = 0, vGap: Int = 0, block: BorderPanel.() -> Unit): BorderPanel =
    BorderPanel(hGap, vGap).apply(block)

