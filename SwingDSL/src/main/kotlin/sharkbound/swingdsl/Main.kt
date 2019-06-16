package sharkbound.swingdsl

import sharkbound.swingdsl.dsl.Frame
import sharkbound.swingdsl.dsl.dialog
import sharkbound.swingdsl.dsl.frame
import sharkbound.swingdsl.extensions.*
import sharkbound.swingdsl.util.*
import sharkbound.swingdsl.wrappers.CardLayoutWrapper
import javax.swing.*

private lateinit var card: CardLayoutWrapper
private lateinit var entry: JTextField

fun main() {
    val dialog = dialog<Frame>(show = false) {
        root {
            vBoxLayout {
                textField { columns(20); compactHeight() }
                textField { columns(20); compactHeight() }
            }
        }
    }
    useSystemLookAndFeel()
    frame {

        root {
            gridBag {
                button("open") {
                    action {
                        dialog.display(size = 400 to 400)
                    }
                }
            }
        }

        display(size = 600 to 600)
    }
}
