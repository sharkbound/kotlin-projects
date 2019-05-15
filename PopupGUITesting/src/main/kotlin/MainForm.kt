import sharkbound.commonutils.enums.GridBagFill
import sharkbound.commonutils.extensions.sendCloseEvent
import sharkbound.commonutils.util.newGridBagContraint
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.Insets
import java.awt.event.KeyEvent
import javax.swing.*

class MainForm : JFrame("Popup GUI Test") {
    val click: JButton
    val pane: JPanel

    init {
        pane = JPanel(GridBagLayout())


        click = JButton("click").apply {
            addActionListener {

            }
        }

        pane.add(click)
        GridBagConstraints().let {
            it.fill
        }

        pane.registerKeyboardAction({
            sendCloseEvent()
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW)

        add(pane)
    }
}