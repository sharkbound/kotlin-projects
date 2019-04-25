@file:JvmName("Main")

package colornote

import colornote.frames.MainFrame
import colornote.util.useSystemLookAndFeel


fun main() {
    val frame = MainFrame()
    useSystemLookAndFeel()
    frame.run()
}
