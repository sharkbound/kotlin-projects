import java.awt.Color
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.JColorChooser
import javax.swing.JFrame

fun main() {
    val frame = JFrame("Tabbed Form Test")
    val form = MainForm()

    form.addEventListeners()

    frame.contentPane = form.panel
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.setSize(600, 600)
    frame.setLocationRelativeTo(null)
    frame.isVisible = true
}

private fun MainForm.addEventListeners() {
    colorBar.addMouseListener(object : MouseAdapter() {
        override fun mouseClicked(e: MouseEvent?) {
            colorBar.background = JColorChooser.showDialog(colorBar, "Choose a new color", Color.red)
        }
    })

    addButton.addActionListener {

    }
}

