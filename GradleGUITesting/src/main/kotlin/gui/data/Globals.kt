package gui.data

import java.nio.file.Path

object Globals {
    val dataConfigPath = Path.of("configs/test.json")!!
    val dataConfigPathStr = dataConfigPath.toString()
}