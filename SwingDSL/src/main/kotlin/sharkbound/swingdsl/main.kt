package sharkbound.swingdsl

import sharkbound.swingdsl.dsl.frame
import sharkbound.swingdsl.extensions.button
import sharkbound.swingdsl.extensions.sendCloseEvent
import java.awt.BorderLayout
import java.awt.FlowLayout
import java.awt.event.KeyEvent
import javax.swing.JButton
import javax.swing.JComponent
import javax.swing.KeyStroke

fun main() {
    frame {
        flow(FlowLayout.RIGHT)

        root.registerKeyboardAction(
            { sendCloseEvent() },
            KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0),
            JComponent.WHEN_IN_FOCUSED_WINDOW
        )

        button("click") {
            println("click")
        }

        button("click") {
            println("click")
        }

        display(size = 600 to 600)
    }
}
