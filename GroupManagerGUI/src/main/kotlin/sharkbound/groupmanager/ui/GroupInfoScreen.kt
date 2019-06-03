package sharkbound.groupmanager.ui

import sharkbound.commonutils.extensions.use
import sharkbound.commonutils.util.centerFlowLayout
import sharkbound.groupmanager.constants.manager
import sharkbound.groupmanager.constants.session
import sharkbound.groupmanager.models.*
import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.event.*
import javax.swing.*

class GroupInfoScreen(mainWindow: MainWindow) : JPanel(BorderLayout()) {
    private val groupModel = DefaultListModel<Group>()
    private val groupList = JList<Group>(groupModel)
    private val nameLabel = JLabel()
    private val memberList = JList<Member>()

    init {
        bindEvents()
        reloadGroupList()

        add(JPanel().apply {
            layout = BoxLayout(this, BoxLayout.Y_AXIS)
            add(centerFlowLayout {
                add(JScrollPane(groupList))
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
                add(JScrollPane(memberList))
            })
        }, BorderLayout.SOUTH)
    }

    private fun reloadGroupList() {
        groupModel.clear()
        groupModel.addAll(manager.groups)
    }

    private fun bindEvents() {
        addComponentListener(object : ComponentAdapter() {
            override fun componentShown(e: ComponentEvent?) {
                reloadGroupList()
            }
        })

        groupList.addListSelectionListener {
            session {
                groupList.selectedValue.let {
                    nameLabel.text = it.name
                    memberList.model = DefaultListModel<Member>().apply {
                        addAll(it.members)
                    }
                }
            }
        }
    }
}