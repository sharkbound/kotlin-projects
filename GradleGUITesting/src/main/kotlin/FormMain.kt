import gui.frames.MainFrame
import gui.util.useSystemLookAndFeel

fun main() {
    val frame = MainFrame()
    useSystemLookAndFeel()
    frame.run()
}
