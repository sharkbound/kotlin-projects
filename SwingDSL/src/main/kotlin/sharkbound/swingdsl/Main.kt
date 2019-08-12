package sharkbound.swingdsl

import sharkbound.swingdsl.dsl.frame
import sharkbound.swingdsl.enums.JFrameCloseOperation
import sharkbound.swingdsl.extensions.showFrame
import sharkbound.swingdsl.extensions.useGridBagLayout
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
        }
        showFrame(JFrameCloseOperation.EXIT_ON_CLOSE, Dimension(600, 600), center = true)
    }
}