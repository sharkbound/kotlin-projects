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
            colorBar.background = JColorChooser.showDialog(null, "Choose a color", Color.red)
        }
    })

    addButton.addActionListener {
        parseSize(itemSizeInput.text,
            onSuccess = {
                itemPane.add(ItemPane(text = itemNameInput.text, color = colorBar.background, w = width, h = height))
                itemNameInput.text = ""
                itemPane.repaint()
                itemPane.revalidate()
            },
            onFailure = {

            }
        )
    }
}

