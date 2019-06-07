package sharkbound.swingdsl

import sharkbound.swingdsl.dsl.frame
import sharkbound.swingdsl.extensions.*
import java.awt.Color
import java.awt.event.KeyEvent
import javax.swing.JComponent
import javax.swing.KeyStroke

fun main() {
    frame {
        root.registerKeyboardAction(
            { sendCloseEvent() },
            KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0),
            JComponent.WHEN_IN_FOCUSED_WINDOW
        )

        root {

        }

        display(size = 600 to 600)
    }
}
