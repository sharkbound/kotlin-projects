package sharkbound.ui

import java.awt.BorderLayout
import java.awt.FlowLayout
import javax.swing.JButton
import javax.swing.JLabel
import javax.swing.JPanel

class ChoicePanel(private val text: String, private val buttons: List<JButton>) : JPanel() {
    private val content = JPanel(BorderLayout())
    private val buttonPanel = JPanel(FlowLayout(FlowLayout.CENTER))

    init {
        buttons.forEach {
            buttonPanel.add(it)
        }

        content.add(JPanel(FlowLayout(FlowLayout.CENTER).apply { add(JLabel(text)) }), BorderLayout.NORTH)
        content.add(buttonPanel, BorderLayout.SOUTH)
        add(content, BorderLayout.CENTER)
    }
}