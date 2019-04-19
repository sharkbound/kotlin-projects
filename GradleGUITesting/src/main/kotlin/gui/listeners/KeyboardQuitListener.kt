package gui.listeners

import close
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import javax.swing.JComponent
import javax.swing.JFrame

class KeyboardQuitListener(
    private val quitFrame: JFrame,
    private val exitPredicate: KeyEvent.() -> Boolean = { keyCode == KeyEvent.VK_ESCAPE }
) : KeyListener {
    override fun keyTyped(e: KeyEvent?) {
    }

    override fun keyPressed(e: KeyEvent?) {
        if (e?.exitPredicate() == true) {
            quitFrame.close()
        }
    }

    override fun keyReleased(e: KeyEvent?) {
    }
}