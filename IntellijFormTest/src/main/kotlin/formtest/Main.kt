@file:JvmName("Main")

package formtest

import formtest.util.createAbstractAction
import java.awt.event.KeyEvent
import java.awt.event.WindowEvent
import javax.swing.JComponent
import javax.swing.JFrame
import javax.swing.KeyStroke

@JvmName("main")
fun main() {
    val form = MainForm()
    val frame = JFrame()

    with(form) {
        setup()
        addCustomListeners()

        with(panel) {
            getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, true), "quit")
            actionMap.put("quit", createAbstractAction {
                frame.dispatchEvent(WindowEvent(frame, WindowEvent.WINDOW_CLOSING))
            })
        }
    }

    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.contentPane = form.panel
    frame.setSize(600, 600)
    frame.setLocationRelativeTo(null)
    frame.isVisible = true
}

fun MainForm.setup() {
}


fun MainForm.addCustomListeners() {
}