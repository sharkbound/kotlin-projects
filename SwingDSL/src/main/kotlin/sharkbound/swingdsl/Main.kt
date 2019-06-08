package sharkbound.swingdsl

import sharkbound.swingdsl.dsl.frame
import sharkbound.swingdsl.extensions.*
import sharkbound.swingdsl.util.createGridBagContraint
import java.awt.Color
import java.awt.event.KeyEvent
import javax.swing.JButton
import javax.swing.JComponent
import javax.swing.JPanel
import javax.swing.KeyStroke
import javax.swing.text.JTextComponent

fun main() {
    frame {
        root.registerKeyboardAction(
            { sendCloseEvent() },
            KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0),
            JComponent.WHEN_IN_FOCUSED_WINDOW
        )

        root {
            gridBag {
                textField {
                }
            }
        }

        display(size = 600 to 600)
    }
}
