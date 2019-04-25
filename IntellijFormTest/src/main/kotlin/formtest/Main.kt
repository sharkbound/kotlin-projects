@file:JvmName("Main")

package formtest

import javax.swing.JFrame
import javax.swing.UIManager

fun main() {
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())
    val frame = JFrame("KotlinFormTest")
    val form = MainForm()
    frame.contentPane = form.panel
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.setLocationRelativeTo(null)
    frame.pack()
    frame.isVisible = true
}