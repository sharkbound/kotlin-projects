import gui.frames.TestingFrame
import gui.util.centerJFrame
import gui.util.exitOnClose

fun main() {
    val frame = TestingFrame()
    frame.exitOnClose()
    frame.location = centerJFrame(frame)
    frame.isVisible = true
}
