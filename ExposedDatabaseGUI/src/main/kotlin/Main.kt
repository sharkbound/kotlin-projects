import sharkbound.commonutils.enums.JFrameCloseOperation
import sharkbound.commonutils.extensions.registerKeyStroke
import sharkbound.commonutils.extensions.showFrame
import sharkbound.connectToDatabase
import java.awt.Dimension
import java.awt.event.KeyEvent
import java.awt.event.WindowEvent
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.JTextArea
import javax.swing.KeyStroke

class T : JFrame()

fun main() {
    connectToDatabase()
    val frame = T()
    val pane = JPanel()
    pane.add(JTextArea())
    pane.registerKeyStroke("quit", KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, true)) {
        frame.dispatchEvent(WindowEvent(frame, WindowEvent.WINDOW_CLOSING))
    }
    frame.showFrame(JFrameCloseOperation.EXIT_ON_CLOSE, size = Dimension(600, 600), center = true, content = pane)
}