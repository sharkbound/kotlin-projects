package sharkbound.swingdsl.wrappers

import java.awt.event.*
import javax.swing.JComponent

class MouseMotionEventWrapper<T : JComponent>(val parent: T) {
    inline fun moved(crossinline block: T.(MouseEvent?) -> Unit) {
        parent.addMouseMotionListener(object : MouseAdapter() {
            override fun mouseMoved(e: MouseEvent?) {
                parent.block(e)
            }
        })
    }

    inline fun dragged(crossinline block: T.(MouseEvent?) -> Unit) {
        parent.addMouseMotionListener(object : MouseAdapter() {
            override fun mouseDragged(e: MouseEvent?) {
                parent.block(e)
            }
        })
    }

    inline fun mouseWheel(crossinline block: T.(MouseWheelEvent?) -> Unit) {
        parent.addMouseMotionListener(object : MouseAdapter() {
            override fun mouseWheelMoved(e: MouseWheelEvent?) {
                parent.block(e)
            }
        })
    }
}