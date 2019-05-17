import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.*

class SpringLayoutForm : JFrame() {
    val spring = SpringLayout()
    val pane = JPanel(spring)

    init {
//        pane.add(JButton("click"), springContraint(10, 10, 100, 100))
//        pane.add(JButton("click"), springContraint(0, height = 100))

        val b1 = JTextField("HELLO")
        val b2 = JButton("put 2")

        spring.putConstraint(SpringLayout.NORTH, b1, 200, SpringLayout.NORTH, pane)
        spring.putConstraint(SpringLayout.SOUTH, b1, -200, SpringLayout.SOUTH, pane)

        spring.putConstraint(SpringLayout.SOUTH, b2, 200, SpringLayout.EAST, b1)
        spring.putConstraint(SpringLayout.NORTH, b2, 100, SpringLayout.EAST, b1)

        pane.add(b1)
        pane.add(b2)
        add(pane)
    }
}