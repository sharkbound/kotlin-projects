package sharkbound.swingdsl

import sharkbound.swingdsl.dsl.frame
import sharkbound.swingdsl.enums.GridBagFill
import sharkbound.swingdsl.extensions.*
import sharkbound.swingdsl.util.gridBagContraint
import sharkbound.swingdsl.util.style
import java.awt.Color
import java.awt.Font
import java.awt.event.KeyEvent
import javax.swing.*

lateinit var field: JTextField
lateinit var entered: JLabel
lateinit var setTextBtn: JButton

fun main() {
    frame {
        root.registerKeyboardAction(
            { sendCloseEvent() },
            KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0),
            JComponent.WHEN_IN_FOCUSED_WINDOW
        )

        root {
            north {
                useGridBagLayout()
                field = textField(constraint = gridBagContraint(fill = GridBagFill.BOTH)) {
                    columns(10)
                    center()
                    action {
                        setTextBtn.doClick()
                    }
                }
            }

            center {
                useGridBagLayout()
                entered = label(constraint = gridBagContraint(fill = GridBagFill.BOTH)) {
                    center()
                    fg(Color.blue)
                    font("source code pro", style(bold = true, italic = true), 40)
                }
            }

            south {
                setTextBtn = button("set text") {
                    entered.text(field.text)
                }
            }
        }

        display(size = 600 to 600)
    }
}
