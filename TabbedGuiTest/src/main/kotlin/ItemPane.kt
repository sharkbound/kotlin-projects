import java.awt.BorderLayout
import java.awt.Color
import java.awt.Dimension
import java.awt.FlowLayout
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.border.LineBorder

class ItemPane(text: String, val color: Color, val w: Int, val h: Int) : JPanel() {
    init {
        add(JPanel().apply {
            preferredSize = Dimension(w, h)
            background = color
            layout = BorderLayout()
            add(JLabel(text, JLabel.CENTER), BorderLayout.CENTER)
        })
    }
}