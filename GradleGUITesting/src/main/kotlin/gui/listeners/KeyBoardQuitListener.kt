package gui.listeners

import close
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import javax.swing.JFrame

class KeyBoardQuitListener(
    private val frame: JFrame,
    private val exitPredicate: KeyEvent.() -> Boolean = { keyCode == KeyEvent.VK_ESCAPE }
) : KeyListener {
    override fun keyTyped(e: KeyEvent?) {
    }

    override fun keyPressed(e: KeyEvent?) {
        if (e == null) return
        if (e.exitPredicate()) {
            frame.close()
        }
    }

    override fun keyReleased(e: KeyEvent?) {
    }
}