package sharkbound.swingdsl

import sharkbound.swingdsl.dsl.frame
import sharkbound.swingdsl.extensions.*
import sharkbound.swingdsl.util.*
import java.awt.Color
import java.awt.event.*
import java.util.*
import javax.swing.*
import javax.swing.border.LineBorder
import javax.swing.table.DefaultTableColumnModel
import javax.swing.table.DefaultTableModel
import javax.swing.table.JTableHeader
import javax.swing.table.TableColumn


fun main() {
    useSystemLookAndFeel()
    frame {
        root.registerKeyboardAction(
            { sendCloseEvent() },
            KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0),
            JComponent.WHEN_IN_FOCUSED_WINDOW
        )

        root {
            scrollPane {
                table {
                    model {
                        addColumns("Name", "Age", "Gender")
                        addRow(1, 2, 3)
                        addRow(1, 2, 3)
                    }
                }
            }
        }

        display(size = 600 to 600)
    }
}
