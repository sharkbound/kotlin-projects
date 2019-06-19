package sharkbound.groupmanagerdsl.menus

import kotlinx.serialization.UnstableDefault
import sharkbound.groupmanagerdsl.data.UserGroup
import sharkbound.groupmanagerdsl.mgr
import sharkbound.groupmanagerdsl.saveAfter
import sharkbound.swingdsl.dsl.Frame
import sharkbound.swingdsl.dsl.dialog
import sharkbound.swingdsl.extensions.*
import sharkbound.swingdsl.util.gridFillBoth
import javax.swing.JOptionPane
import javax.swing.JPanel
import javax.swing.JTextField

@UnstableDefault
class AddGroupMenu : JPanel() {
    lateinit var groupName: JTextField

    init {
        useGridBagLayout()
        label("name", gridFillBoth(x = 0, y = 0)) { hCenterAlign() }
        groupName = textField(constraint = gridFillBoth(x = 0, y = 1)) {
            action {
                if (text in mgr) {
                    JOptionPane.showMessageDialog(this@AddGroupMenu, "group $text already exists")
                } else if (groupName.text.trim().isNotBlank()) {
                    saveAfter {
                        add(UserGroup(groupName.text.trim()))
                        JOptionPane.showMessageDialog(this@AddGroupMenu, "added group ${groupName.text}")
                    }
                }
            }
        }
    }
}