import net.miginfocom.swing.MigLayout
import sharkbound.commonutils.enums.JFrameCloseOperation
import sharkbound.commonutils.extensions.sendCloseEvent
import sharkbound.commonutils.extensions.showFrame
import java.awt.Dimension
import java.awt.event.KeyEvent
import javax.swing.*

class MainWindow : JFrame() {
    val pane = JPanel(MigLayout())

    init {
        val b1 = JButton("name: ")
        val f1 = JTextField(15)
        val t1 = JTextArea().apply {
            preferredSize = Dimension(100, 100)
        }

        pane.add(b1)
        pane.add(f1, "span, wrap")
        pane.add(t1)
        pane.add(JButton("..."))

        add(pane)

        pane.registerKeyboardAction(
            { sendCloseEvent() },
            KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
            JComponent.WHEN_IN_FOCUSED_WINDOW
        )
    }

    fun display() {
        showFrame(JFrameCloseOperation.EXIT_ON_CLOSE, center = true, pack = true)
    }
}