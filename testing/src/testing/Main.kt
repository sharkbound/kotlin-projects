package testing

import java.awt.GridBagLayout
import javax.swing.JButton
import javax.swing.JFrame


fun main() {
    val frame = JFrame()
    val form = MyForm()
    frame.layout = GridBagLayout()

    val newItemBtn = JButton("New Item")
    val removeItemBtn = JButton()

    frame.contentPane = form.panel
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.pack()
    frame.isVisible = true
}