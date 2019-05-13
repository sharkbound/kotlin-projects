package sharkbound.ui

import java.awt.BorderLayout
import java.awt.FlowLayout
import javax.swing.JButton
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JTextArea

class ChoicePanel(private val header: String, private val buttons: List<JButton>) : JPanel(BorderLayout()) {
    private val content = JPanel(BorderLayout()).dark
    private val buttonPanel = JPanel(FlowLayout()).dark
    private val text = JTextArea().apply { isEditable = false }.dark

    init {
        dark

        buttons.forEach {
            buttonPanel.add(it)
        }

        content.add(buttonPanel, BorderLayout.SOUTH)
        content.add(text, BorderLayout.CENTER)
        content.add(
            JLabel(header, JLabel.CENTER).dark,
            BorderLayout.NORTH
        )

        add(content, BorderLayout.CENTER)
    }
}