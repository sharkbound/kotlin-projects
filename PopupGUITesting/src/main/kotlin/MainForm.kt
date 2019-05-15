import sharkbound.commonutils.extensions.sendCloseEvent
import sharkbound.commonutils.extensions.showFrame
import sharkbound.commonutils.util.createGridBagContraint
import java.awt.Dimension
import java.awt.GridBagLayout
import java.awt.event.KeyEvent
import javax.swing.*

class MainForm : JFrame("Popup GUI Test") {
    val pane: JPanel = JPanel(GridBagLayout())
    val click: JButton = JButton("open window").apply {
        addActionListener {
            println(PopupWindow(this@MainForm).value)
        }
    }

    init {
        pane.add(click, createGridBagContraint(width = 3, height = 3))

        pane.registerKeyboardAction({
            sendCloseEvent()
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW)

        add(pane)
    }
}