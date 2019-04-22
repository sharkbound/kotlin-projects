package gui.frames

import java.awt.BorderLayout
import java.awt.EventQueue

import javax.swing.AbstractListModel
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JList
import javax.swing.JPanel
import javax.swing.JTextField
import javax.swing.SwingConstants
import javax.swing.border.EmptyBorder
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.Insets

class GeneratedFrame : JFrame() {

    private val contentPane: JPanel
    private val textField: JTextField
    private val textField_1: JTextField
    private val textField_2: JTextField

    /**
     * Create the frame.
     */
    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setBounds(100, 100, 443, 552)
        contentPane = JPanel()
        contentPane.border = EmptyBorder(5, 5, 5, 5)
        contentPane.layout = BorderLayout(0, 0)
        setContentPane(contentPane)

        val mainPanel = JPanel()
        contentPane.add(mainPanel, BorderLayout.CENTER)
        mainPanel.layout = BorderLayout(4, 0)

        val leftPanel = JPanel()
        mainPanel.add(leftPanel, BorderLayout.WEST)
        leftPanel.layout = BorderLayout(0, 0)

        val list = JList<String>()
        list.model = object : AbstractListModel<String>() {
            internal var values = arrayOf("test")
            override fun getSize(): Int {
                return values.size
            }

            override fun getElementAt(index: Int): String {
                return values[index]
            }
        }
        leftPanel.add(list, BorderLayout.CENTER)

        val leftButtonPanel = JPanel()
        leftPanel.add(leftButtonPanel, BorderLayout.SOUTH)

        val btnAddItem = JButton("add item")
        leftButtonPanel.add(btnAddItem)

        val btnRemoveItem = JButton("remove item")
        leftButtonPanel.add(btnRemoveItem)

        val rightPanel = JPanel()
        mainPanel.add(rightPanel, BorderLayout.CENTER)
        rightPanel.layout = BorderLayout(0, 0)

        val panel = JPanel()
        rightPanel.add(panel, BorderLayout.NORTH)
        val gblPanel = GridBagLayout()
        gblPanel.columnWidths = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0)
        gblPanel.rowHeights = intArrayOf(0, 0, 0, 0, 0, 0, 0)
        gblPanel.columnWeights = doubleArrayOf(0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, java.lang.Double.MIN_VALUE)
        gblPanel.rowWeights = doubleArrayOf(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, java.lang.Double.MIN_VALUE)
        panel.layout = gblPanel

        val lblNewLabel = JLabel("item name")
        val gbc_lblNewLabel = GridBagConstraints()
        gbc_lblNewLabel.insets = Insets(0, 0, 5, 5)
        gbc_lblNewLabel.gridx = 0
        gbc_lblNewLabel.gridy = 0
        panel.add(lblNewLabel, gbc_lblNewLabel)

        textField = JTextField()
        val gbc_textField = GridBagConstraints()
        gbc_textField.insets = Insets(0, 0, 5, 0)
        gbc_textField.gridwidth = 6
        gbc_textField.fill = GridBagConstraints.HORIZONTAL
        gbc_textField.gridx = 1
        gbc_textField.gridy = 0
        panel.add(textField, gbc_textField)
        textField.columns = 10

        val lblDescription = JLabel("description")
        val gbcLblDescription = GridBagConstraints()
        gbcLblDescription.insets = Insets(0, 0, 5, 5)
        gbcLblDescription.gridx = 0
        gbcLblDescription.gridy = 1
        panel.add(lblDescription, gbcLblDescription)

        val btnSelectImage = JButton("select image")
        val gbc_btnSelectImage = GridBagConstraints()
        gbc_btnSelectImage.anchor = GridBagConstraints.WEST
        gbc_btnSelectImage.gridwidth = 2
        gbc_btnSelectImage.insets = Insets(0, 0, 5, 5)
        gbc_btnSelectImage.gridx = 0
        gbc_btnSelectImage.gridy = 2
        panel.add(btnSelectImage, gbc_btnSelectImage)

        textField_1 = JTextField()
        val gbc_textField_1 = GridBagConstraints()
        gbc_textField_1.insets = Insets(0, 0, 5, 0)
        gbc_textField_1.gridwidth = 5
        gbc_textField_1.fill = GridBagConstraints.HORIZONTAL
        gbc_textField_1.gridx = 2
        gbc_textField_1.gridy = 2
        panel.add(textField_1, gbc_textField_1)
        textField_1.columns = 10

        val lblNewLabel_1 = JLabel("price")
        lblNewLabel_1.horizontalAlignment = SwingConstants.CENTER
        val gbc_lblNewLabel_1 = GridBagConstraints()
        gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST
        gbc_lblNewLabel_1.insets = Insets(0, 0, 5, 5)
        gbc_lblNewLabel_1.gridx = 0
        gbc_lblNewLabel_1.gridy = 3
        panel.add(lblNewLabel_1, gbc_lblNewLabel_1)

        textField_2 = JTextField()
        val gbc_textField_2 = GridBagConstraints()
        gbc_textField_2.gridwidth = 6
        gbc_textField_2.insets = Insets(0, 0, 5, 5)
        gbc_textField_2.fill = GridBagConstraints.HORIZONTAL
        gbc_textField_2.gridx = 1
        gbc_textField_2.gridy = 3
        panel.add(textField_2, gbc_textField_2)
        textField_2.columns = 10

        val panel_1 = JPanel()
        rightPanel.add(panel_1, BorderLayout.SOUTH)

        val panel_2 = JPanel()
        panel_1.add(panel_2)

        val btnAdd = JButton("add trait")
        panel_2.add(btnAdd)

        val btnRemove = JButton("remove trait")
        panel_2.add(btnRemove)
    }

    companion object {

        /**
         * Launch the application.
         */
        @JvmStatic
        fun main(args: Array<String>) {
            EventQueue.invokeLater {
                try {
                    val frame = GeneratedFrame()
                    frame.isVisible = true
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

}
