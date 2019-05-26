package sharkbound.groupmanager.ui

import javax.swing.*

class GroupInfoScreen(mainWindow: MainWindow) : JPanel() {
    init {
        val spring = SpringLayout()
        layout = spring
        val nameField = JTextField()
        add(nameField)
    }
}