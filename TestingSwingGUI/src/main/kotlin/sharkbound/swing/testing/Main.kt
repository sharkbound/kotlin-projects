package sharkbound.swing.testing

import sharkbound.swingdsl.dsl.frame
import sharkbound.swingdsl.enums.JFrameCloseOperation
import sharkbound.swingdsl.extensions.*
import java.awt.Dimension
import java.awt.GridBagLayout
import javax.swing.JOptionPane

fun main() {
    frame("Useless Application") {
        root {
            gridBag {
            }
        }
        showFrame(size = Dimension(100, 100), center = true, closeOperation = JFrameCloseOperation.EXIT_ON_CLOSE)
    }
}