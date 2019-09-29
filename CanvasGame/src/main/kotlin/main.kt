import sharkbound.canvasgame.GameFrame
import sharkbound.swingdsl.dsl.frame
import sharkbound.swingdsl.enums.JFrameCloseOperation
import sharkbound.swingdsl.extensions.*
import sharkbound.swingdsl.util.gridFillBoth
import java.awt.Dimension

fun main() {
    frame {
        root {
            menuBar {
                menu("options") {
                    item("quit [Q]") {
                        action {
                            sendCloseEvent()
                        }
                    }
                }
            }
            useGridBagLayout()
            add(gridFillBoth()) { GameFrame(this@frame) }
        }

        showFrame(JFrameCloseOperation.EXIT_ON_CLOSE, Dimension(600, 600), center = true)
        repaintLoop { 10 }
    }
}