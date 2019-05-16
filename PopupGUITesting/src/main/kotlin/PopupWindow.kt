import sharkbound.commonutils.enums.GridBagFill
import sharkbound.commonutils.extensions.sendCloseEvent
import sharkbound.commonutils.util.createGridBagContraint
import java.awt.GridBagLayout
import java.awt.Window
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import javax.swing.JButton
import javax.swing.JDialog
import javax.swing.JPanel
import javax.swing.WindowConstants

class PopupWindow(owner: Window) : JDialog(owner) {
    val panel = JPanel(GridBagLayout())

    init {
        add(panel)
        panel.add(JButton(":)").apply {
            addActionListener {
                dispose()
            }
        }, createGridBagContraint(fill = GridBagFill.BOTH))
        modalityType = ModalityType.APPLICATION_MODAL
        defaultCloseOperation = WindowConstants.HIDE_ON_CLOSE

        setLocationRelativeTo(null)
        setSize(300, 300)
        isVisible = true
    }
}