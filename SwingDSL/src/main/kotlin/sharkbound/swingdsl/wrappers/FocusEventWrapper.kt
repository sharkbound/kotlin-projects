package sharkbound.swingdsl.wrappers

import java.awt.event.*
import javax.swing.JComponent

class FocusEventWrapper<T : JComponent>(val parent: T) {
    inline fun gained(crossinline block: T.(FocusEvent?) -> Unit) {
        parent.addFocusListener(object : FocusAdapter() {
            override fun focusGained(e: FocusEvent?) {
                parent.block(e)
            }
        })
    }

    inline fun lost(crossinline block: T.(FocusEvent?) -> Unit) {
        parent.addFocusListener(object : FocusAdapter() {
            override fun focusLost(e: FocusEvent?) {
                parent.block(e)
            }
        })
    }
}