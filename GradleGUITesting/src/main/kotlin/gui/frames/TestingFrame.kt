package gui.frames

import java.awt.*
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import javax.swing.*
import javax.swing.border.EmptyBorder

class TestingFrame : JFrame("My Frame") {
    val panel = JPanel(BorderLayout(5, 5))
    val westPanel = JPanel(BorderLayout())
    val eastPanel = JPanel(BorderLayout())
    val addItemButton = JButton("add item")
    val removeItemButton = JButton("remove item")
    val data = DefaultListModel<String>()
    val list = JList(data)
    val listScrollPane = JScrollPane(list)
    val itemNameInput = JTextField()
    val descriptionInput = JTextField()

    init {
        addItemButton.addActionListener {
            data.addElement(itemNameInput.text)
            itemNameInput.text = ""
        }

        removeItemButton.addActionListener {
            data.removeElementAt(list.selectedIndex)
        }

        list.addListSelectionListener {
            itemNameInput.text = list.selectedValue
        }

        itemNameInput.addKeyListener(object : KeyListener {
            override fun keyTyped(e: KeyEvent?) {}
            override fun keyPressed(e: KeyEvent?) {
                when {
                    e?.keyCode == KeyEvent.VK_ENTER -> {
                        addItemButton.doClick()
                    }
                }
            }

            override fun keyReleased(e: KeyEvent?) {}
        })

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())
        panel.border = EmptyBorder(3, 0, 2, 0)
        size = Dimension(600, 600)

        panel.add(westPanel, BorderLayout.WEST)
        panel.add(eastPanel, BorderLayout.CENTER)

        var tmpPanel = JPanel(FlowLayout())
        tmpPanel.add(addItemButton)
        tmpPanel.add(removeItemButton)

        westPanel.add(listScrollPane, BorderLayout.CENTER)
        westPanel.add(tmpPanel, BorderLayout.SOUTH)

        tmpPanel = JPanel(GridBagLayout())
        tmpPanel.add(Box.createHorizontalStrut(10), GridBagConstraints().apply { gridx = 1; gridy = 1 })
        tmpPanel.add(
            JLabel("item name", SwingConstants.LEFT),
            GridBagConstraints()
        )
        tmpPanel.add(
            itemNameInput,
            GridBagConstraints().apply { weightx = 1.0; gridx = 2; fill = GridBagConstraints.BOTH })
        tmpPanel.add(JLabel("description", SwingConstants.LEFT), GridBagConstraints().apply { gridy = 1; gridx = 0 })
        tmpPanel.add(JButton("select image"), GridBagConstraints().apply { gridy = 2 })
        tmpPanel.add(
            descriptionInput,
            GridBagConstraints().apply { gridy = 2; gridx = 2; fill = GridBagConstraints.HORIZONTAL })

        eastPanel.add(tmpPanel, BorderLayout.NORTH)

        tmpPanel = JPanel(FlowLayout())
        tmpPanel.add(JPanel(FlowLayout()).apply {
            add(JButton("add trait"))
            add(JButton("remove trait"))
        })
        eastPanel.add(tmpPanel, BorderLayout.SOUTH)
        add(panel)
        pack()
    }
}