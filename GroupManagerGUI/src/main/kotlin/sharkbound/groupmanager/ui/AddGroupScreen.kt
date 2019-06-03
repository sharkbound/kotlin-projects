package sharkbound.groupmanager.ui

import sharkbound.commonutils.util.centerFlowLayout
import java.awt.BorderLayout
import javax.swing.*

class AddGroupScreen(mainWindow: MainWindow) : JPanel(BorderLayout()) {
    init {
        add(JPanel().apply {
            layout = BoxLayout(this, BoxLayout.Y_AXIS)

            add(centerFlowLayout {
                add(JButton("!"))
            })
        }, BorderLayout.CENTER)

        add(centerFlowLayout {
            add(JButton("!"))
        }, BorderLayout.SOUTH)
    }
}