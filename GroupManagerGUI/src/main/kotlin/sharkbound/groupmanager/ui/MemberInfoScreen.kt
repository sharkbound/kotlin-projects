package sharkbound.groupmanager.ui

import java.awt.BorderLayout
import javax.swing.JButton
import javax.swing.JPanel

class MemberInfoScreen(mainWindow: MainWindow) : JPanel(BorderLayout()) {
    init {
        add(JButton("member info"), BorderLayout.CENTER)
    }
}