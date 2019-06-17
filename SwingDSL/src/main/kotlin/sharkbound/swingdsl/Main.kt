package sharkbound.swingdsl

import sharkbound.swingdsl.dsl.frame
import sharkbound.swingdsl.extensions.*
import sharkbound.swingdsl.util.useSystemLookAndFeel
import sharkbound.swingdsl.wrappers.CardLayoutWrapper
import javax.swing.JTextField

private lateinit var card: CardLayoutWrapper
private lateinit var entry: JTextField

fun main() {
    useSystemLookAndFeel()

    frame {
        root {
            gridBag {
                button("open", action = {
                    println(":D")
                })
            }
        }

        display(size = 600 to 600)
    }
}
