import java.awt.GridBagLayout
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JPanel

class GridBagLayoutForm : JFrame("Popup GUI Test") {
    val pane: JPanel = JPanel(GridBagLayout())

    init {
        pane.add(JButton("open popup window").apply {
            addActionListener {
                PopupWindow(this@GridBagLayoutForm)
            }
        })
        add(pane)
    }
}
