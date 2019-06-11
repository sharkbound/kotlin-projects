package sharkbound.swingdsl

import sharkbound.swingdsl.dsl.frame
import sharkbound.swingdsl.enums.*
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
            tabPane(TabPlacement.valueOf("BOTTOM")) {
                splitPane {
                    left {
                        useGridBagLayout()
                        button("LEFT", constraint = gridFillBoth()) {}
                    }
                    right {
                        useGridBagLayout()
                        button("RIGHT", constraint = gridFillBoth()) {}
                    }
                }
            }
        }

        display(size = 600 to 600)
    }
}
