package sharkbound.swingdsl.extensions

import sharkbound.swingdsl.enums.JComponentKeyStrokeContext
import java.awt.Dimension
import java.awt.Rectangle
import java.awt.event.ActionEvent
import javax.swing.AbstractAction
import javax.swing.JComponent
import javax.swing.KeyStroke

inline fun JComponent.registerKeyStroke(
    key: String,
    keyStroke: KeyStroke,
    context: JComponentKeyStrokeContext = JComponentKeyStrokeContext.WHEN_IN_FOCUSED_WINDOW,
    crossinline action: (ActionEvent?) -> Unit
) {
    getInputMap(context.code).put(keyStroke, key)
    actionMap.put(key, object : AbstractAction() {
        override fun actionPerformed(e: ActionEvent?) {
            action(e)
        }
    })
}

/**
 * places a JComponent at a absolute position, layout must be null to work
 */
fun <T : JComponent> T.place(
    x: Int,
    y: Int,
    width: Int = this.preferredSize.width,
    height: Int = this.preferredSize.height,
    preferredSize: Dimension = this.preferredSize
): T = apply {
    bounds = Rectangle(x, y, width, height)
    this.preferredSize = preferredSize
}