package sharkbound.swingdsl.builders

import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent
import javax.swing.JComponent

class KeyEventBuilder<T : JComponent>(val parent: T, init: KeyEventBuilder<T>.() -> Unit) {
    init {
        init()
    }

    fun keyTyped(block: T.(KeyEvent?) -> Unit) {
        parent.addKeyListener(object : KeyAdapter() {
            override fun keyTyped(e: KeyEvent?) {
                parent.block(e)
            }
        })
    }

    fun keyPressed(block: T.(KeyEvent?) -> Unit) {
        parent.addKeyListener(object : KeyAdapter() {
            override fun keyPressed(e: KeyEvent?) {
                parent.block(e)
            }
        })
    }

    fun keyReleased(block: T.(KeyEvent?) -> Unit) {
        parent.addKeyListener(object : KeyAdapter() {
            override fun keyReleased(e: KeyEvent?) {
                parent.block(e)
            }
        })
    }
}