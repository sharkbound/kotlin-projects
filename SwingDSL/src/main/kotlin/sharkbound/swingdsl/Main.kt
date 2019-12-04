package sharkbound.swingdsl

import sharkbound.swingdsl.dsl.frame
import sharkbound.swingdsl.enums.JFrameCloseOperation
import sharkbound.swingdsl.extensions.button
import sharkbound.swingdsl.extensions.showFrame
import sharkbound.swingdsl.extensions.textArea
import sharkbound.swingdsl.extensions.useGridBagLayout
import sharkbound.swingdsl.util.gridFillBoth
import sharkbound.swingdsl.util.useSystemLookAndFeel
import sharkbound.swingdsl.wrappers.CardLayoutWrapper
import java.awt.Dimension
import javax.swing.JTextField

private lateinit var card: CardLayoutWrapper
private lateinit var entry: JTextField

fun main() {
    useSystemLookAndFeel()

    frame {
        root {
            useGridBagLayout()
            gridFillBoth()

            button("test")
            button("test 2")
            button("test 3")
            textArea {

            }
        }
        showFrame(JFrameCloseOperation.EXIT_ON_CLOSE, Dimension(600, 600), center = true)
    }
}