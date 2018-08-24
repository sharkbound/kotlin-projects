import java.awt.Dimension
import java.awt.GridLayout
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JPanel

class MainFrame(title: String = "Main Window") : JFrame(title) {
    var dim = Dimension(600, 600)
    val clickMe = JButton("0")
    val layout = GridLayout()
    val panel = JPanel(layout)
    var count = 0

    init {
        size = dim
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE

        addListeners()
        addElements()
        configureElements()

        isVisible = true
    }

    private fun configureElements() {
        clickMe.addActionListener() {
            clickMe.text = (++count).toString()
        }
        clickMe.size = Dimension(100, 1000)
    }

    private fun addElements() {
        panel.add(clickMe)
    }

    private fun addListeners() {
    }
}