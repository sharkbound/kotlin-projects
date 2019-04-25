@file:JvmName("RunForm")

package colornote

import colornote.frames.MainFrame
import colornote.util.useSystemLookAndFeel

@JvmName("main")
fun main() {
    val frame = MainFrame()
    useSystemLookAndFeel()
    frame.run()
}
