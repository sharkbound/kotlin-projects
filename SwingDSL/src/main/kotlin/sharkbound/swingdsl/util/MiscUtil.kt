package sharkbound.swingdsl.util

import javax.swing.SwingUtilities
import javax.swing.UIManager

fun useSystemLookAndFeel() {
    try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())
    } catch (e: Exception) {
    }
}

fun runLater(block: () -> Unit) {
    SwingUtilities.invokeLater(block)
}