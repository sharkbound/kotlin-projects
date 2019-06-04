package sharkbound.commonutils.util

import javax.swing.BoxLayout
import javax.swing.JPanel

/**
 * creates a Y_AXIS aligned JPanel with BoxLayout
 */
fun vBoxLayout(block: JPanel.() -> Unit): JPanel =
    JPanel().apply {
        layout = BoxLayout(this, BoxLayout.Y_AXIS)
        apply(block)
    }

/**
 * creates a X_AXIS aligned JPanel with BoxLayout
 */
fun hBoxLayout(block: JPanel.() -> Unit): JPanel =
    JPanel().apply {
        layout = BoxLayout(this, BoxLayout.X_AXIS)
        apply(block)
    }