package sharkbound.swingdsl.util

import javax.swing.UIManager

fun useSystemLookAndFeel() {
    try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())
    } catch (e: Exception) {
    }
}