package experiments

import gui.util.centerJFrame
import gui.util.configure
import gui.util.exitOnClose
import java.awt.Dimension
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import javax.swing.*


class TutorialFrame : JFrame() {
    val textField = JTextArea()
    val input = JTextField()

    init {
        layout = GridBagLayout()

        add(
            textField,
            GridBagConstraints().configure(fill = GridBagConstraints.BOTH)
        )
        add(
            input,
            GridBagConstraints().configure(weightY = 0.0, fill = GridBagConstraints.HORIZONTAL, y = 1)
        )

        pack()
        setSize(600, 600)
        location = centerJFrame(this)
    }
}

fun main() {
    TutorialFrame().exitOnClose().isVisible = true
}