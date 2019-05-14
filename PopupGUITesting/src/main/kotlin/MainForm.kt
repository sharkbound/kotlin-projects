import sharkbound.commonutils.enums.GridBagFill
import sharkbound.commonutils.util.newGridBagContraint
import java.awt.GridBagLayout
import java.awt.Insets
import javax.swing.JButton
import javax.swing.JFrame

class MainForm : JFrame("Popup GUI Test") {
    val click: JButton

    init {
        layout = GridBagLayout()

        click = JButton("click").apply {
            addActionListener {

            }
        }

        add(click, newGridBagContraint(1, 1, fill = GridBagFill.BOTH))
    }
}