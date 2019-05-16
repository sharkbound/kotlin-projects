import sharkbound.commonutils.enums.GridBagFill
import sharkbound.commonutils.extensions.sendCloseEvent
import sharkbound.commonutils.util.createGridBagContraint
import java.awt.GridBagLayout
import java.awt.event.KeyEvent
import javax.swing.*

class MainForm : JFrame("Popup GUI Test") {
    val pane: JPanel = JPanel(GridBagLayout())
    val click: JButton = JButton("open window").apply {
        addActionListener {
            PopupWindow(this@MainForm)
        }
    }
    val text = JLabel("0")

    init {
        pane.add(click, createGridBagContraint(fill = GridBagFill.BOTH))
        pane.add(text, createGridBagContraint(x = 0, y = 1, fill = GridBagFill.BOTH))

        pane.registerKeyboardAction({
            sendCloseEvent()
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW)

        add(pane)
    }
}