import sharkbound.commonutils.enums.GridBagFill
import sharkbound.commonutils.extensions.sendCloseEvent
import sharkbound.commonutils.util.createGridBagContraint
import java.awt.Dialog
import java.awt.GridBagLayout
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JPanel

class PopupWindow(init: PopupWindow.() -> Unit = {}) : JFrame() {
    val panel = JPanel(GridBagLayout())
    val btn = JButton("CLOSE").apply { addActionListener { sendCloseEvent() } }

    init {
        init()
        modalExclusionType = Dialog.ModalExclusionType.NO_EXCLUDE

        panel.add(btn, createGridBagContraint(fill = GridBagFill.BOTH))
        add(panel)

        addWindowListener(object : WindowAdapter() {
            override fun windowClosing(e: WindowEvent?) {
                dispose()
            }
        })
    }

}