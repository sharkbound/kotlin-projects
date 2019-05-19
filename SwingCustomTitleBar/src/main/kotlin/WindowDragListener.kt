import sharkbound.commonutils.extensions.use
import sharkbound.commonutils.extensions.with
import java.awt.Point
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import java.awt.event.MouseMotionListener
import javax.swing.JFrame

class WindowDragListener(private val frame: JFrame) : MouseListener, MouseMotionListener {
    init {
        frame.addMouseMotionListener(this)
        frame.addMouseListener(this)
    }

    private lateinit var pos: Point
    override fun mouseReleased(e: MouseEvent?) {
        pos = Point(0, 0)
    }

    override fun mouseEntered(e: MouseEvent?) {}
    override fun mouseClicked(e: MouseEvent?) {}
    override fun mouseExited(e: MouseEvent?) {}
    override fun mousePressed(e: MouseEvent?) {
        pos = e?.point ?: return
    }

    override fun mouseMoved(e: MouseEvent?) {}
    override fun mouseDragged(e: MouseEvent?) {
        e use {
            frame.location = Point(locationOnScreen.x - pos.x, locationOnScreen.y - pos.y)
        }
    }
}


val Point.asCoordString get() = "($x, $y)"