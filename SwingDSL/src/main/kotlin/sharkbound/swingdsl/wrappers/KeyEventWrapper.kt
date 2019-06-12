package sharkbound.swingdsl.wrappers

import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent
import javax.swing.JComponent

class KeyEventWrapper<T : JComponent>(val parent: T) {
    inline fun keyTyped(crossinline block: T.(KeyEvent?) -> Unit) {
        parent.addKeyListener(object : KeyAdapter() {
            override fun keyTyped(e: KeyEvent?) {
                parent.block(e)
            }
        })
    }

    inline fun keyPressed(crossinline block: T.(KeyEvent?) -> Unit) {
        parent.addKeyListener(object : KeyAdapter() {
            override fun keyPressed(e: KeyEvent?) {
                parent.block(e)
            }
        })
    }

    inline fun keyReleased(crossinline block: T.(KeyEvent?) -> Unit) {
        parent.addKeyListener(object : KeyAdapter() {
            override fun keyReleased(e: KeyEvent?) {
                parent.block(e)
            }
        })
    }
}