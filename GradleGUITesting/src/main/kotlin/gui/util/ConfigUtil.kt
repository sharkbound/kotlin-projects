package gui.util

import gui.extensions.toJsonBytes
import java.nio.file.Files
import java.nio.file.Path

inline fun <reified T> loadConfig(path: Path, default: () -> T): T {
    if (!Files.exists(path)) {
        saveConfig(path, default() as Any)
    }
    return gson.fromJson(Files.readString(path), T::class.java)
}

fun saveConfig(path: Path, obj: Any) {
    val foldersOnlyPath = path.normalize().parent
    Files.createDirectories(foldersOnlyPath)
    Files.write(path, obj.toJsonBytes)
}