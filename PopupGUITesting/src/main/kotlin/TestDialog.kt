import java.awt.GridBagLayout
import javax.swing.JDialog
import javax.swing.JPanel

class TestDialog(init: TestDialog.() -> Unit) : JDialog() {
    val panel = JPanel(GridBagLayout())

    init {
        contentPane = panel
        init()
    }

}