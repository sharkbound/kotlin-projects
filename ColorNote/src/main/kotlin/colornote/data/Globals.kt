package colornote.data

import java.awt.Color
import java.awt.event.KeyEvent
import java.nio.file.Path
import javax.swing.KeyStroke

object Globals {
    val dataConfigPath = Path.of("configs/test.json")!!
    val dataConfigPathStr = dataConfigPath.toString()
    val escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, true)
    val escapeKeyStrokeName = "quit_frame"
}

object Colors {
    val black = Color(0, 0, 0)
    val white = Color(255, 255, 255)
}