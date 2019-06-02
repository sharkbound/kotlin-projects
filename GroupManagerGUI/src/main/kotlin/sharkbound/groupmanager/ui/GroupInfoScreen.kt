package sharkbound.groupmanager.ui

import sharkbound.commonutils.util.centerFlowLayout
import sharkbound.groupmanager.constants.session
import sharkbound.groupmanager.enums.UserType
import sharkbound.groupmanager.models.*
import java.awt.BorderLayout
import java.awt.Dimension
import java.beans.Customizer
import javax.swing.*

class GroupInfoScreen(mainWindow: MainWindow) : JPanel(BorderLayout()) {
    val groupNameField = JTextField()
    val search = JButton("search")
    val nameLabel = JLabel()
    val list = JList<Member>()

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

        add(JPanel().apply {
            layout = BoxLayout(this, BoxLayout.Y_AXIS)
            add(centerFlowLayout {
                add(JLabel("name:"))
                add(nameLabel)
                add(JPanel().apply { preferredSize = Dimension(0, 50) })
            })
            add(centerFlowLayout {
                add(JLabel("members"))
            })
            add(centerFlowLayout {
                add(JScrollPane(list))
            })
        }, BorderLayout.SOUTH)
    }

    private fun bindEvents() {
        groupNameField.addActionListener {
            search.doClick()
        }

        search.addActionListener {
            session {
                val group = findGroup { name == groupNameField.text.trim() }.ifAbsent {
                    JOptionPane.showMessageDialog(this@GroupInfoScreen, "that group could not be found")
                    return@session
                }.valueOrThrow

                nameLabel.text = group.name
                list.model = DefaultListModel<Member>().apply {
                    addAll(group.members)
                }
            }
        }
    }
}