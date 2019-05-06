import sharkbound.commonutils.enums.JFrameCloseOperation
import sharkbound.commonutils.extensions.registerKeyStroke
import sharkbound.commonutils.extensions.sendCloseEvent
import sharkbound.commonutils.extensions.showFrame
import sharkbound.connectToDatabase
import java.awt.Dimension
import java.awt.event.KeyEvent
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.JTextArea
import javax.swing.KeyStroke


fun main() {
    connectToDatabase()
    val frame = JFrame()
    val pane = JPanel()
    pane.add(JTextArea())
    pane.registerKeyStroke("quit", KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, true)) {
        frame.sendCloseEvent()
    }
    frame.showFrame(JFrameCloseOperation.EXIT_ON_CLOSE, size = Dimension(600, 600), center = true, content = pane)
}