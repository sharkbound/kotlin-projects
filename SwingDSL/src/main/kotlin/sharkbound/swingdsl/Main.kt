package sharkbound.swingdsl

import sharkbound.swingdsl.dsl.frame
import sharkbound.swingdsl.enums.*
import sharkbound.swingdsl.extensions.*
import sharkbound.swingdsl.util.buildFont
import sharkbound.swingdsl.util.gridBagContraint
import sharkbound.swingdsl.util.gridFillBoth
import sharkbound.swingdsl.util.useSystemLookAndFeel
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
            borderPanel {
                center {
                    card = cardPane {
                        vBoxLayout(constraint = "1") {
                            centerFlowLayout {
                                label("name: ") { }
                                textField() { columns(10) }
                            }
                        }
                        vBoxLayout(constraint = "2") {
                            centerFlowLayout {
                                label("age: ") { }
                                textField() { columns(10) }
                            }
                        }
                    }
                }
                north {
                    list<String> {
                        size(300, 50)
                        model {
                            addAllItems("1", "2")
                        }
                        itemSelected { _, value ->
                            card?.current = value
                        }
                    }
                }
            }
        }

        display(size = 600 to 600)
    }
}
