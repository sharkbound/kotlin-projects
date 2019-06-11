package sharkbound.swingdsl

import sharkbound.swingdsl.dsl.frame
import sharkbound.swingdsl.enums.GridBagFill
import sharkbound.swingdsl.enums.Underline
import sharkbound.swingdsl.extensions.*
import sharkbound.swingdsl.util.buildFont
import sharkbound.swingdsl.util.gridBagContraint
import sharkbound.swingdsl.util.gridFillBoth
import sharkbound.swingdsl.util.useSystemLookAndFeel
import java.awt.Color
import java.awt.event.KeyEvent
import javax.swing.*

lateinit var field: JTextField
lateinit var entered: JLabel
lateinit var setTextBtn: JButton

fun main() {
    useSystemLookAndFeel()
    frame {
        root.registerKeyboardAction(
            { sendCloseEvent() },
            KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0),
            JComponent.WHEN_IN_FOCUSED_WINDOW
        )

        root {
            tabPane {
                tab("test typer") {
                    north {
                        useGridBagLayout()
                        field = textField(constraint = gridBagContraint(fill = GridBagFill.BOTH)) {
                            columns(10)
                            leftAlign()
                            action {
                                setTextBtn.doClick()
                            }
                        }
                    }

                    center {
                        useGridBagLayout()
                        entered = label(constraint = gridFillBoth()) {
                            center()
                            text("long text to test styles")
                            font = buildFont {
                                size = 30
                                fg = Color.yellow
                                bg = Color.gray
                                underline = Underline.GRAY
                            }
                        }
                    }

                    south {
                        setTextBtn = button("set text") {
                            entered.text(field.text)
                        }
                    }
                }

                tab("button") {
                    useGridBagLayout()
                    button(":D", constraint = gridFillBoth()) {
                        selectedIndex = 0
                    }
                }
            }
        }

        display(size = 600 to 600)
    }
}
