import sharkbound.commonutils.extensions.use
import java.awt.Point
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import java.awt.event.MouseMotionListener
import javax.swing.JFrame

class TitleBarListener(private val frame: JFrame) : MouseListener, MouseMotionListener {
    private lateinit var pos: Point

    init {
        frame.addMouseMotionListener(this)
        frame.addMouseListener(this)
    }

    override fun mouseReleased(e: MouseEvent?) {
        pos = Point(0, 0)
    }

    override fun mousePressed(e: MouseEvent?) {
        pos = e?.point ?: return
    }

    override fun mouseDragged(e: MouseEvent?) {
        e use {
            frame.location = Point(locationOnScreen.x - pos.x, locationOnScreen.y - pos.y)
        }
    }

    override fun mouseEntered(e: MouseEvent?) {}
    override fun mouseClicked(e: MouseEvent?) {}
    override fun mouseExited(e: MouseEvent?) {}
    override fun mouseMoved(e: MouseEvent?) {}
}