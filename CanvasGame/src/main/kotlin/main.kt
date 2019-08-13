import sharkbound.canvasgame.GameFrame
import sharkbound.swingdsl.dsl.frame
import sharkbound.swingdsl.enums.JFrameCloseOperation
import sharkbound.swingdsl.extensions.add
import sharkbound.swingdsl.extensions.showFrame
import sharkbound.swingdsl.extensions.useGridBagLayout
import sharkbound.swingdsl.util.gridFillBoth
import java.awt.Dimension

fun main() {
    frame {
        root {
            useGridBagLayout()
            add(gridFillBoth()) { GameFrame(this@frame) }
        }
        showFrame(JFrameCloseOperation.EXIT_ON_CLOSE, Dimension(600, 600), center = true)

        while (true) {
            repaint()
            Thread.sleep(10)
        }
    }
}