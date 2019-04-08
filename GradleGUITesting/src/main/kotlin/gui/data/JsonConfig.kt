package gui.data

import gui.util.saveConfig
import java.nio.file.Path

open class JsonConfig(private val strPath: String) {
    private val path get() = Path.of(strPath)

    fun save() {
        saveConfig(path, this)
    }
}