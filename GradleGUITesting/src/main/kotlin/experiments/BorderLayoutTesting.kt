package experiments

import gui.util.centerJFrame
import gui.util.exitOnClose
import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.FlowLayout
import javax.swing.*

class BorderLayoutTestingFrame : JFrame() {
    private val nameField = JTextField()
    private val emailField = JTextField()
    private val doneButton = JButton("done")

    init {
        size = Dimension(600, 600)
        layout = BorderLayout()

        nameField.preferredSize = Dimension(130, 20)
        emailField.preferredSize = Dimension(130, 20)

        var panel = JPanel()
        panel.layout = FlowLayout(0)
        panel.add(JLabel("name:"))
        panel.add(nameField)
        add(BorderLayout.PAGE_START, panel)

        panel = JPanel()
        panel.layout = FlowLayout(0)
        panel.add(JLabel("email:"))
        panel.add(emailField)
        add(BorderLayout.PAGE_END, panel)

        panel = JPanel()
        panel.layout = FlowLayout(0)
        panel.add(BorderLayout.SOUTH, doneButton)
        add(BorderLayout.CENTER, panel)

        pack()
    }
}

fun main() {
    val frame = BorderLayoutTestingFrame()
    frame.exitOnClose()
    frame.location = centerJFrame(frame)
    frame.isVisible = true
}