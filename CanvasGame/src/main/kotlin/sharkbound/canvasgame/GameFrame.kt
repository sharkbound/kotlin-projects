package sharkbound.canvasgame

import sharkbound.swingdsl.extensions.*
import java.awt.Color
import java.awt.Graphics
import java.awt.event.KeyEvent
import javax.swing.JComponent
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.KeyStroke

class GameFrame(val frame: JFrame) : JPanel() {
    var mx: Int = 0
    var my: Int = 0
    val points = mutableListOf<Pair<Int, Int>>()

    init {
        registerKeyboardAction(
            { frame.sendCloseEvent() },
            KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0),
            JComponent.WHEN_IN_FOCUSED_WINDOW
        )
        mouseMotionEvent {
            dragged {
                it?.apply {
                    mx = x
                    my = y
                    points += mx to my
                    this@GameFrame.repaint()
                }
            }
            moved {
                it?.apply {
                    println(x to y)
                }
            }
        }
    }

    override fun paint(g: Graphics?) {
        g?.apply {
            withColor(Color.white) {
                fillRect(0, 0, size.width, size.height)
            }
            withColor(Color.black) {
                fillCircle(mx - 25, my - 25, 50)
            }
            withColor(Color.green) {
                if (points.isNotEmpty()) {
                    g.drawPolyline(
                        points.map { it.first }.toIntArray() + intArrayOf(points.first().first),
                        points.map { it.second }.toIntArray() + intArrayOf(points.first().second),
                        points.size + 1
                    )
                }
            }
        }
    }
}
