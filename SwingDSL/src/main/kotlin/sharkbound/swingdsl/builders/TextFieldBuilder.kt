package sharkbound.swingdsl.builders

import java.awt.Dimension
import java.awt.event.ActionEvent
import javax.swing.JTextField

class TextFieldBuilder(val field: JTextField) {
    fun onEnterPressed(block: ActionEvent?.() -> Unit) {
        field.addActionListener(block)
    }

    fun width(width: Int) {
        field.preferredSize = Dimension(width, field.preferredSize.height)
    }

    fun height(height: Int) {
        field.preferredSize = Dimension(field.preferredSize.width, height)
    }

    fun columns(columns: Int) {
        field.columns = columns
    }

    fun keyEvent(block: KeyEventBuilder<JTextField>.() -> Unit) {
        KeyEventBuilder(field, block)
    }
}