package sharkbound.canvasgame

import sharkbound.commonutils.extensions.clampTo
import sharkbound.commonutils.extensions.len
import sharkbound.swingdsl.extensions.*
import java.awt.*
import java.awt.event.KeyEvent
import javax.swing.JComponent
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.KeyStroke


class GameFrame(val frame: JFrame) : JPanel() {
    var mx: Int = 0
    var my: Int = 0
    val lines = mutableListOf<List<Pair<Int, Int>>>()
    val currentLine = mutableListOf<Pair<Int, Int>>()
    var lineWidth = 1f


    init {
        registerKeyboardAction(
            { frame.sendCloseEvent() },
            KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0),
            JComponent.WHEN_IN_FOCUSED_WINDOW
        )
        mouseEvent {
            released {
                lines += currentLine.toList()
                currentLine.clear()
            }
            pressed {
                currentLine.clear()
            }
        }
        mouseMotionEvent {
            mouseWheel {
                lineWidth = (lineWidth + if (it!!.preciseWheelRotation < 0) 1f else -1f).clampTo(1f, 15f)
            }
            dragged {
                it?.apply {
                    mx = x
                    my = y
                    currentLine += x to y
                }
            }
        }
    }

    override fun paint(g: Graphics?) {
        (g as? Graphics2D)?.apply {
            fillBackground(size, Color.black)
            stroke = BasicStroke(lineWidth)

            withColor(Color.black) {
                fillCircle(mx - 25, my - 25, 50)
            }

            withColor(Color.green) {
                for (line in lines) {
                    drawPolyline(line.map { it.first }.toIntArray(), line.map { it.second }.toIntArray(), line.len)
                }
                drawPolyline(
                    currentLine.map { it.first }.toIntArray(),
                    currentLine.map { it.second }.toIntArray(),
                    currentLine.len
                )
            }
        }
    }
}
