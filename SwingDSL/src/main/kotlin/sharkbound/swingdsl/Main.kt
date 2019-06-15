package sharkbound.swingdsl

import sharkbound.swingdsl.dsl.frame
import sharkbound.swingdsl.extensions.*
import sharkbound.swingdsl.util.*
import sharkbound.swingdsl.wrappers.CardLayoutWrapper
import java.awt.event.MouseEvent
import javax.swing.*

private lateinit var card: CardLayoutWrapper
private lateinit var entry: JTextField

fun main() {
    useSystemLookAndFeel()
    frame {
        root {
            gridBag {
                button(":D") {
                }
            }
        }

        display(size = 600 to 600)
    }
}
