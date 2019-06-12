package sharkbound.swingdsl.wrappers

import java.awt.event.*
import javax.swing.JComponent

class MouseEventWrapper<T : JComponent>(val parent: T) {
    inline fun released(crossinline block: T.(MouseEvent?) -> Unit) {
        parent.addMouseListener(object : MouseAdapter() {
            override fun mouseReleased(e: MouseEvent?) {
                parent.block(e)
            }
        })
    }

    inline fun entered(crossinline block: T.(MouseEvent?) -> Unit) {
        parent.addMouseListener(object : MouseAdapter() {
            override fun mouseEntered(e: MouseEvent?) {
                parent.block(e)
            }
        })
    }

    inline fun clicked(crossinline block: T.(MouseEvent?) -> Unit) {
        parent.addMouseListener(object : MouseAdapter() {
            override fun mouseClicked(e: MouseEvent?) {
                parent.block(e)
            }
        })
    }

    inline fun exited(crossinline block: T.(MouseEvent?) -> Unit) {
        parent.addMouseListener(object : MouseAdapter() {
            override fun mouseExited(e: MouseEvent?) {
                parent.block(e)
            }
        })
    }

    inline fun pressed(crossinline block: T.(MouseEvent?) -> Unit) {
        parent.addMouseListener(object : MouseAdapter() {
            override fun mousePressed(e: MouseEvent?) {
                parent.block(e)
            }
        })
    }
}