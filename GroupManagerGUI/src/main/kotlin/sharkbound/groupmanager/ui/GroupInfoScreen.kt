package sharkbound.groupmanager.ui

import sharkbound.commonutils.util.centerFlowLayout
import java.awt.*
import javax.swing.*

class GroupInfoScreen(mainWindow: MainWindow) : JPanel() {
    val groupNameField = JTextField()
    val search = JButton("search")

    init {
        bindEvents()

        add(JPanel().apply {
            layout = BoxLayout(this, BoxLayout.Y_AXIS)

            add(centerFlowLayout {
                add(JLabel("ENTER GROUP NAME:"))
                add(groupNameField.apply {
                    preferredSize = Dimension(130, search.preferredSize.height)
                })
                add(search)
            })
        }, BorderLayout.NORTH)
    }

    private fun bindEvents() {
        groupNameField.addActionListener {
            search.doClick()
        }

        search.addActionListener {
        }
    }
}