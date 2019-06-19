package sharkbound.groupmanagerdsl.dialogs

import kotlinx.serialization.UnstableDefault
import sharkbound.groupmanagerdsl.data.Member
import sharkbound.groupmanagerdsl.data.UserGroup
import sharkbound.groupmanagerdsl.saveAfter
import sharkbound.swingdsl.dsl.dialog
import sharkbound.swingdsl.enums.BoldWeight
import sharkbound.swingdsl.extensions.*
import sharkbound.swingdsl.util.buildFont
import sharkbound.swingdsl.util.gridFillBoth
import java.awt.Color
import javax.swing.JFrame
import javax.swing.JOptionPane
import javax.swing.JTextField

@UnstableDefault
class AddMemberDialog(val group: UserGroup) {
    lateinit var nameField: JTextField

    init {
        dialog<JFrame>(pack = true) {
            root {
                vBoxLayout {
                    label("member name", constraint = gridFillBoth(x = 0, y = 0, width = 2)) {
                        hCenterAlign()
                        font = buildFont {
                            bold = BoldWeight.DEMI
                        }
                    }
                    nameField = textField {
                        placeHolderText("enter member name to add")
                        keyEvent {
                            keyReleased {
                                fg(if (text in group) Color.red else Color(0x008E15))
                            }
                        }
                        action {
                            if (text in group) {
                                JOptionPane.showMessageDialog(this, "member $text is already in this group")
                            } else {
                                saveAfter {
                                    group.add(Member(text, -1))
                                    JOptionPane.showMessageDialog(this@textField, "added member $text")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}