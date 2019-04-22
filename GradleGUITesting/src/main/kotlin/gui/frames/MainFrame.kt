package gui.frames

import gui.listeners.KeyboardQuitListener
import gui.util.addKeyboardQuitListener
import gui.util.centerJFrame
import gui.util.configure
import gui.util.exitOnClose
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.JTextField
import javax.swing.JTextPane
import javax.swing.border.EmptyBorder
import javax.swing.text.DefaultStyledDocument

class MainFrame(w: Int = 600, h: Int = 600, title: String = "Hello World!") : JFrame(title) {
    private val doc = DefaultStyledDocument()
    private val inputField = JTextField()
    private val textField = JTextPane(doc)
    private val contentPanel = JPanel(GridBagLayout())

    init {
        exitOnClose()
        setSize(w, h)
        layout = GridBagLayout()
        location = centerJFrame(this, w, h)
    }

    private fun setup() {
        addAllComponents()
        configureComponents()
        addAllComponentListeners()
    }

    private fun configureComponents() {
        textField.border = EmptyBorder(0, 10, 0, 10)
        textField.isEditable = false
//        textField.addKeyboardQuitListener(this)
//        inputField.addKeyboardQuitListener(this)
    }

    private fun addAllComponentListeners() {
        inputField.addActionListener {
            textField.text = "${inputField.text}\n"
            inputField.text = ""
        }
        /* todo
        *       add global key listener:
        *       https://stackoverflow.com/questions/100123/application-wide-keyboard-shortcut-java-swing
        * */
    }

    private fun addAllComponents() {
        contentPanel.add(textField, GridBagConstraints().configure())
        contentPanel.add(
            inputField,
            GridBagConstraints().apply { weightx = 1.0; weightx = .0; gridy = 1; fill = GridBagConstraints.HORIZONTAL }
        )
        add(contentPanel, GridBagConstraints().apply { weightx = 1.0; weighty = 1.0; fill = GridBagConstraints.BOTH })
    }

    fun run() {
        setup()
        isVisible = true
    }
}
