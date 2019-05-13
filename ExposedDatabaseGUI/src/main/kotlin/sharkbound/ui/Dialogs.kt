package sharkbound.ui

import java.awt.GridBagLayout
import javax.swing.JDialog
import javax.swing.JFrame

class QuestionDialog(source: JFrame) : JDialog(source) {
    init {
        layout = GridBagLayout()
    }
}