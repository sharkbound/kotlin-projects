package sharkbound.swingdsl

import sharkbound.swingdsl.dsl.frame
import sharkbound.swingdsl.enums.BoldWeight
import sharkbound.swingdsl.enums.GridBagFill
import sharkbound.swingdsl.enums.Underline
import sharkbound.swingdsl.extensions.*
import sharkbound.swingdsl.util.buildFont
import sharkbound.swingdsl.util.gridBagContraint
import java.awt.Color
import java.awt.GradientPaint
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
                    text("long text to test styles")
                    font = buildFont {
                        strikeThrough = true
                        bold = BoldWeight.EXTRA
                        name = "Source Code Pro"
                        size = 30
                        underline = Underline.DASHED
                        italic = true
                    }
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
