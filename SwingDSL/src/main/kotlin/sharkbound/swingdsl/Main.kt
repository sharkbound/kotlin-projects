package sharkbound.swingdsl

import sharkbound.swingdsl.dsl.frame
import sharkbound.swingdsl.extensions.button
import sharkbound.swingdsl.extensions.gridBag
import sharkbound.swingdsl.extensions.useGridBagLayout
import sharkbound.swingdsl.util.useSystemLookAndFeel
import sharkbound.swingdsl.wrappers.CardLayoutWrapper
import javax.swing.JTextField
import javax.swing.plaf.metal.MetalBorders

private lateinit var card: CardLayoutWrapper
private lateinit var entry: JTextField

fun main() {
    useSystemLookAndFeel()

    frame {
        root {
            useGridBagLayout()
        }

        display(size = 600 to 600)
    }
}
