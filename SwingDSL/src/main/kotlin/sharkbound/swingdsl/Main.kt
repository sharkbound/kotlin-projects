package sharkbound.swingdsl

import sharkbound.swingdsl.dsl.frame
import sharkbound.swingdsl.enums.*
import sharkbound.swingdsl.extensions.*
import sharkbound.swingdsl.util.*
import sharkbound.swingdsl.wrappers.CardLayoutWrapper
import java.awt.Color
import java.awt.event.KeyEvent
import javax.swing.*


fun main() {
    useSystemLookAndFeel()
    frame {
        root.registerKeyboardAction(
            { sendCloseEvent() },
            KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0),
            JComponent.WHEN_IN_FOCUSED_WINDOW
        )

        var card: CardLayoutWrapper? = null
        root {
            useBorderLayout()
            north {
                comboBox<String> {
                    model {
                        addAllItems("1", "2", "3")
                    }
                    itemSelected { _, v ->
                        println(v)
                    }
                }
            }
        }

        display(size = 600 to 600)
    }
}
