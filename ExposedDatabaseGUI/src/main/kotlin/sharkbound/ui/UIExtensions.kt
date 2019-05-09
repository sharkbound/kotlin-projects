package sharkbound.ui

import javax.swing.JComponent


val <T : JComponent> T.dark
    get() = apply {
        background = Colors.gray
        foreground = Colors.white
    }

val <T : JComponent> T.blue
    get() = apply {
        background = Colors.blue
        foreground = Colors.white
    }