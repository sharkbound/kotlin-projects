package formtest.data

import java.awt.Color
import java.awt.event.ActionEvent
import java.awt.event.KeyEvent
import java.awt.event.WindowEvent
import javax.swing.*

object Global {
    var color = Color.black
    val quitKey = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, true)
}

/** note to self:
 *
 *   when getting a input map, always use [JComponent.WHEN_IN_FOCUSED_WINDOW]
 *   when putting to the actionMap, make sure to use the same KEY as in the inputMap put,
 *      and not to try to use the quitKey like i was doing and having issues with
 * */
fun addQuitAction(frame: JFrame, panel: JComponent) {
    panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(Global.quitKey, "quit")
    panel.actionMap.put("quit", object : AbstractAction() {
        override fun actionPerformed(e: ActionEvent?) {
            frame.dispatchEvent(WindowEvent(frame, WindowEvent.WINDOW_CLOSING))
        }
    })
}