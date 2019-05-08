package sharkbound.ui

import javax.swing.JButton

class ChoiceButton(title: String) : JButton(title) {
    init {
        background = Colors.blue
        foreground = Colors.white
    }
}