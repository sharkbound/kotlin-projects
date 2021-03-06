package sharkbound.canvasgame

import sharkbound.commonutils.extensions.len
import sharkbound.swingdsl.extensions.*
import java.awt.BasicStroke
import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.event.KeyEvent
import java.awt.event.MouseWheelEvent
import javax.swing.JComponent
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.KeyStroke


class GameFrame(val frame: JFrame) : JPanel() {
    var mx: Int = 0
    var my: Int = 0
    val lines = mutableListOf<List<Pair<Int, Int>>>()
    val line = mutableListOf<Pair<Int, Int>>()
    var lineWidth = 1f


    init {
        registerKeyboardAction(
            { frame.sendCloseEvent() },
            KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0),
            JComponent.WHEN_IN_FOCUSED_WINDOW
        )
        mouseEvent {
            released {
                lines += line.toList()
                line.clear()
            }
            pressed {
                line.clear()
            }
        }
        mouseMotionEvent {
            mouseWheel {
                lineWidth += if (it!!.preciseWheelRotation < 0) 1 else -1
                if (lineWidth < 0)
                    lineWidth = 1f
            }
            dragged {
                it?.apply {
                    mx = x
                    my = y
                    line += x to y
                }
            }
        }
    }

    override fun paint(g: Graphics?) {
        (g as? Graphics2D)?.apply {
            stroke = BasicStroke(lineWidth)
            fillBackground(size, Color.black)
            withColor(Color.black) {
                fillCircle(mx - 25, my - 25, 50)
            }
            withColor(Color.green) {
                for (line in lines) {
                    drawPolyline(line.map { it.first }.toIntArray(), line.map { it.second }.toIntArray(), line.len)
                }
                drawPolyline(line.map { it.first }.toIntArray(), line.map { it.second }.toIntArray(), line.len)
            }
        }
    }
}
