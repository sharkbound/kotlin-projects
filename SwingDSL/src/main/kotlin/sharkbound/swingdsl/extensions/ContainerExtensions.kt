package sharkbound.swingdsl.extensions

import java.awt.Container
import java.awt.event.ActionEvent
import javax.swing.JButton

fun Container.button(text: String, constraint: Any? = null, action: ActionEvent?.() -> Unit): JButton =
    JButton(text).apply {
        addActionListener(action)
        this@button.add(this, constraint)
    }