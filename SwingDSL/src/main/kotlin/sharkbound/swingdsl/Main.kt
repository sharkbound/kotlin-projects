package sharkbound.swingdsl

import sharkbound.swingdsl.dsl.frame
import sharkbound.swingdsl.extensions.*
import sharkbound.swingdsl.util.gridBagContraint
import java.awt.Color
import java.awt.event.KeyEvent
import javax.swing.*

fun main() {
    frame {
        root.registerKeyboardAction(
            { sendCloseEvent() },
            KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0),
            JComponent.WHEN_IN_FOCUSED_WINDOW
        )

        root {
            gridBag {
                textArea(constraint = gridBagContraint(1, 1)) {
                    size(100, 10)
                }
            }
        }

        display(size = 600 to 600)
    }
}
