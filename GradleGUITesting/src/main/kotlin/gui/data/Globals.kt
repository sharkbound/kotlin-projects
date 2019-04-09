package gui.data

import java.awt.Color
import java.nio.file.Path

object Globals {
    val dataConfigPath = Path.of("configs/test.json")!!
    val dataConfigPathStr = dataConfigPath.toString()
}

object Colors {
    val black = Color(0, 0, 0)
    val white = Color(255, 255, 255)
}