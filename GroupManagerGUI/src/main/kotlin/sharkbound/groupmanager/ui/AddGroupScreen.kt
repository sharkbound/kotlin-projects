package sharkbound.groupmanager.ui

import sharkbound.commonutils.util.centerFlowLayout
import sharkbound.commonutils.util.vBoxLayout
import sharkbound.groupmanager.constants.Screen
import sharkbound.groupmanager.constants.manager
import sharkbound.groupmanager.models.Member
import java.awt.BorderLayout
import java.awt.Dimension
import javax.swing.*

class AddGroupScreen(mainWindow: MainWindow) : JPanel(BorderLayout()) {
    val nameInput = JTextField().apply {
        preferredSize = Dimension(150, preferredSize.height)
        maximumSize = preferredSize
    }
    val addGroup = JButton("add").apply {
        preferredSize = Dimension(300, preferredSize.height)
        maximumSize = preferredSize
    }
    val members = DefaultListModel<Member>()

    init {
        bindEvents()
        add(vBoxLayout {
            add(centerFlowLayout {
                add(JLabel("group name: "))
                add(nameInput)
            }.apply { maximumSize = preferredSize })
            add(centerFlowLayout {
                add(JLabel("1"))
//                add(JScrollPane(JList<Member>(members)))
            }.apply { maximumSize = preferredSize })
        }, BorderLayout.CENTER)

        add(centerFlowLayout {
            add(addGroup)
        }, BorderLayout.SOUTH)
    }

    private fun bindEvents() {
        addGroup.addActionListener {
            val text = nameInput.text
            if (text.isBlank()) {
                JOptionPane.showMessageDialog(this@AddGroupScreen, "group name cannot be empty")
                return@addActionListener
            }
            if (manager.groups.any { it.name.toLowerCase() == text }) {
                JOptionPane.showMessageDialog(this@AddGroupScreen, "that group already exists")
                return@addActionListener
            }
        }
    }
}