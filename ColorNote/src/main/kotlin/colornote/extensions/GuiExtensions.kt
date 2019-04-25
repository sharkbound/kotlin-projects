import java.awt.event.WindowEvent
import javax.swing.JFrame

fun JFrame.close() {
    dispatchEvent(WindowEvent(this, WindowEvent.WINDOW_CLOSING))
}
