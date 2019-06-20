package sharkbound.groupmanagerdsl.dialogs

import kotlinx.serialization.UnstableDefault
import sharkbound.groupmanagerdsl.data.Member
import sharkbound.groupmanagerdsl.data.UserGroup
import sharkbound.groupmanagerdsl.saveAfter
import sharkbound.swingdsl.dsl.dialog
import sharkbound.swingdsl.extensions.*
import java.awt.Color
import java.awt.event.KeyEvent
import javax.swing.*

@UnstableDefault
class AddMemberDialog(val group: UserGroup) {
    lateinit var nameField: JTextField
    lateinit var ageField: JTextField

    init {
        dialog<JFrame>(pack = true) {
            root.registerKeyboardAction(
                { isVisible = false },
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_IN_FOCUSED_WINDOW
            )
            root.registerKeyboardAction(
                { tryAddMember() },
                KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
                JComponent.WHEN_IN_FOCUSED_WINDOW
            )
            root {
                vBoxLayout {
                    nameField = textField {
                        placeHolderText("enter member name")
                        keyEvent {
                            keyReleased {
                                fg(if (text.trim() in group) Color.red else Color(0x008E15))
                            }
                        }
                    }
                    ageField = textField { placeHolderText("enter member age") }
                    centerFlowLayout {
                        button("add member") {
                            action {
                                tryAddMember()
                            }
                        }
                    }
                }
            }
        }
    }

    private fun tryAddMember() {
        val name = nameField.text.trim()
        if (name in group) {
            JOptionPane.showMessageDialog(null, "member $name is already in this group")
        } else if (ageField.text.toIntOrNull() == null || ageField.text.toInt() < 1 || ageField.text.isBlank()) {
            JOptionPane.showMessageDialog(
                null,
                "age ${ageField.text} is not a valid age, must be >= 1, and be a valid integer"
            )
        } else {
            saveAfter {
                group.add(Member(name, ageField.text.toInt()))
                JOptionPane.showMessageDialog(null, "added member $name")
            }
        }
    }
}