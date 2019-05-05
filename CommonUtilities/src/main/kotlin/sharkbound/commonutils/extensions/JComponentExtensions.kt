package sharkbound.commonutils.extensions

import sharkbound.commonutils.JComponentKeyStrokeContext
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