package experiments

import gui.util.centerJFrame
import gui.util.exitOnClose
import java.awt.Dimension
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JTextField


fun JTextField.configurePreferredSize() = apply { preferredSize = Dimension(100, 30) }

class GridBagLayoutTesting : JFrame("experiments.GridBagLayoutTesting") {
    private val nameField = JTextField().configurePreferredSize()
    private val emailField = JTextField().configurePreferredSize()
    private val doneButton = JButton("done")

    init {
        exitOnClose()
        layout = GridBagLayout()

        add(doneButton, GridBagConstraints().apply { gridx = 0; gridy = 0; fill = GridBagConstraints.BOTH })
        add(nameField, GridBagConstraints().apply { gridx = 0; gridy = 1; fill = GridBagConstraints.BOTH })

        pack()
        location = centerJFrame(this)
    }
}

fun main() {
    GridBagLayoutTesting().isVisible = true
}