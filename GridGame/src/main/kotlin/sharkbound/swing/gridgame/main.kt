package sharkbound.swing.gridgame

import sharkbound.swingdsl.dsl.frame
import sharkbound.swingdsl.enums.GridBagFill
import sharkbound.swingdsl.enums.JFrameCloseOperation
import sharkbound.swingdsl.extensions.keyEvent
import sharkbound.swingdsl.extensions.showFrame
import sharkbound.swingdsl.extensions.useGridBagLayout
import sharkbound.swingdsl.util.gridBagConstraint
import java.awt.Color
import java.awt.Dimension

fun main() {
    val board = GameBoard(10, 10, Color.gray)
    frame {
        root {
            useGridBagLayout()
            // todo fix key detection
            add(board, gridBagConstraint(fill = GridBagFill.BOTH))
        }
        showFrame(JFrameCloseOperation.EXIT_ON_CLOSE, Dimension(800, 800), center = true)
    }
}