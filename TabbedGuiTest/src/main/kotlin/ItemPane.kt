import java.awt.Color
import java.awt.Dimension
import javax.swing.JLabel
import javax.swing.JPanel

class ItemPane(text: String, val color: Color, val w: Int, val h: Int) : JPanel() {
    init {
        add(JLabel(text).apply {
            preferredSize = Dimension(w, h)
            background = color
        })
    }
}