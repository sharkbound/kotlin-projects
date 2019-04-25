package colornote.frames

import close
import colornote.data.Globals
import colornote.util.configure
import colornote.util.exitOnClose
import colornote.util.r
import colornote.util.randomColor
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.event.ActionEvent
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.*
import javax.swing.border.EmptyBorder
import javax.swing.event.DocumentEvent
import javax.swing.event.DocumentListener
import javax.swing.text.SimpleAttributeSet
import javax.swing.text.StyleConstants

class MainFrame(w: Int = 600, h: Int = 600, title: String = "ColorNote++") : JFrame(title) {
    private val inputField = JTextField()
    private val textField = JTextPane()
    private val doc = textField.styledDocument
    private val contentPanel = JPanel(GridBagLayout())
    private val popupMenu = JPopupMenu("Popup Menu")

    init {
        exitOnClose()
        setSize(w, h)
        layout = GridBagLayout()
    }

    private fun setup() {
        addAllComponents()
        configureComponents()
        addAllComponentListeners()
        setLocationRelativeTo(null)
    }

    private fun configureComponents() {
        textField.border = EmptyBorder(0, 3, 0, 10)
        textField.isEditable = false
    }

    private fun addAllComponentListeners() {
        inputField.addActionListener {
            doc.insertString(doc.length, "${inputField.text}\n", null)
            inputField.text = ""
        }

        popupMenu.add("Clear").addActionListener {
            textField.text = ""
        }

        val inMap = contentPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
        inMap.put(Globals.escapeKeyStroke, Globals.escapeKeyStrokeName)
        contentPanel.actionMap.put(Globals.escapeKeyStrokeName, object : AbstractAction() {
            override fun actionPerformed(e: ActionEvent?) {
                close()
            }
        })

        doc.addDocumentListener(object : DocumentListener {
            override fun changedUpdate(e: DocumentEvent?) {}
            override fun removeUpdate(e: DocumentEvent?) {}
            override fun insertUpdate(e: DocumentEvent?) {
                requireNotNull(e)
                SwingUtilities.invokeLater {
                    repeat(e.length) {
                        doc.setCharacterAttributes(
                            e.offset + it,
                            1,
                            SimpleAttributeSet().also { set ->
                                StyleConstants.setForeground(set, randomColor())
                                StyleConstants.setBackground(set, randomColor())
                                StyleConstants.setFontFamily(set, "Source Code Pro")
                                StyleConstants.setFontSize(set, r.nextInt(1, 100))
                                StyleConstants.setBold(set, r.nextBoolean())
                                StyleConstants.setItalic(set, r.nextBoolean())
                                StyleConstants.setStrikeThrough(set, r.nextBoolean())
                                StyleConstants.setSuperscript(set, r.nextBoolean())
                                StyleConstants.setSubscript(set, r.nextBoolean())
                                StyleConstants.setUnderline(set, r.nextBoolean())
                            }, true
                        )

                    }
                }

            }

        })

    }

    private fun addAllComponents() {
        add(contentPanel, GridBagConstraints().apply { weightx = 1.0; weighty = 1.0; fill = GridBagConstraints.BOTH })
        contentPanel.add(JScrollPane(textField), GridBagConstraints().configure())
        contentPanel.add(
            inputField,
            GridBagConstraints().apply { weightx = 1.0; weightx = .0; gridy = 1; fill = GridBagConstraints.HORIZONTAL }
        )

        textField.addMouseListener(object : MouseAdapter() {
            override fun mousePressed(e: MouseEvent?) {
                requireNotNull(e)
                if (e.button == 3) {
                    popupMenu.show(textField, e.x, e.y)
                }
            }
        })
    }

    fun run() {
        setup()
        isVisible = true
        inputField.requestFocus()
    }
}
