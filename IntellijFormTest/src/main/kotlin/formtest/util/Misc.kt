package formtest.util

import java.awt.event.ActionEvent
import javax.swing.AbstractAction

inline fun createAbstractAction(crossinline handler: (ActionEvent) -> Unit): AbstractAction = object : AbstractAction() {
    override fun actionPerformed(e: ActionEvent?) {
        e?.let { handler(e) }
    }
}