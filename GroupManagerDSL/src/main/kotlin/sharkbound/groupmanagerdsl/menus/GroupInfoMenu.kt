package sharkbound.groupmanagerdsl.menus

import kotlinx.serialization.UnstableDefault
import sharkbound.groupmanagerdsl.data.UserGroup
import sharkbound.groupmanagerdsl.dialogs.AddMemberDialog
import sharkbound.groupmanagerdsl.mgr
import sharkbound.swingdsl.extensions.*
import sharkbound.swingdsl.util.gridFillBoth
import javax.swing.JOptionPane
import javax.swing.JPanel
import javax.swing.JTable
import javax.swing.JTextField
import javax.swing.table.DefaultTableColumnModel
import javax.swing.table.DefaultTableModel
import javax.swing.table.JTableHeader

@UnstableDefault
class GroupInfoMenu : JPanel() {
    lateinit var groupName: JTextField
    lateinit var groupMemberCount: JTextField
    lateinit var memberTable: JTable
    lateinit var memberTableModel: DefaultTableModel
    var currentGroup: UserGroup? = null

    init {
        center {
            useVBoxLayout()

            textField {
                columns(20)
                placeHolderText("enter group name")
                keyEvent {
                    keyReleased {
                        clearMembersListTable()
                        if (text !in mgr) {
                            groupName.text = ""
                            groupMemberCount.text = ""
                            currentGroup = null
                        } else {
                            mgr.findGroupByName(text).ifPresent {
                                groupName.text = it.name
                                groupMemberCount.text = it.len.toString()
                                currentGroup = it
                                populateMembersList(it)
                            }
                        }
                    }
                }
            }
            spacer()
            gridBag {
                label("name", gridFillBoth(x = 0, y = 0))
                groupName = textField(constraint = gridFillBoth(x = 0, y = 1)) { isEditable = false; centerAlign() }
                label("member count", gridFillBoth(x = 1, y = 0))
                groupMemberCount =
                    textField(constraint = gridFillBoth(x = 1, y = 1)) { isEditable = false; centerAlign() }

                scrollPane(constraint = gridFillBoth(x = 0, y = 2, width = 2)) {
                    memberTable = table() {
                        memberTableModel = model {
                            addColumns("name", "age")
                        }
                    }
                    memberTable
                }
            }
        }
        south {
            useGridBagLayout()
            button("add member", constraint = gridFillBoth(), action = {
                if (currentGroup == null) {
                    JOptionPane.showMessageDialog(rootPane, "you must have a group selected to add members to it")
                } else {
                    AddMemberDialog(currentGroup!!)
                }
            })
        }
    }

    private fun clearMembersListTable() {
        (0 until memberTableModel.rowCount).forEach {
            memberTableModel.removeRow(it)
        }
    }

    private fun populateMembersList(group: UserGroup) {
        group.members.forEach {
            memberTableModel.addRow(it.name, it.age)
        }
    }
}