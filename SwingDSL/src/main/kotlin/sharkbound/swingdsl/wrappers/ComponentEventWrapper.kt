package sharkbound.swingdsl.wrappers

import java.awt.event.ComponentAdapter
import java.awt.event.ComponentEvent
import javax.swing.JComponent

class ComponentEventWrapper<T : JComponent>(val parent: T) {
    inline fun moved(crossinline block: T.(ComponentEvent?) -> Unit) {
        parent.addComponentListener(object : ComponentAdapter() {
            override fun componentMoved(e: ComponentEvent?) {
                parent.block(e)
            }
        })
    }

    inline fun resized(crossinline block: T.(ComponentEvent?) -> Unit) {
        parent.addComponentListener(object : ComponentAdapter() {
            override fun componentResized(e: ComponentEvent?) {
                parent.block(e)
            }
        })
    }

    inline fun hidden(crossinline block: T.(ComponentEvent?) -> Unit) {
        parent.addComponentListener(object : ComponentAdapter() {
            override fun componentHidden(e: ComponentEvent?) {
                parent.block(e)
            }
        })
    }

    inline fun shown(crossinline block: T.(ComponentEvent?) -> Unit) {
        parent.addComponentListener(object : ComponentAdapter() {
            override fun componentShown(e: ComponentEvent?) {
                parent.block(e)
            }
        })
    }
}
