package consolemenudsl.data

import sharkbound.commonutils.extensions.len

data class Args(val mgr: Manager, val command: String, val args: List<String>) {
    val hasCommand = command.isNotBlank()
    val hasArgs = args.isNotEmpty()

    fun isInBounds(index: Int) = index >= 0 && index < args.len

    operator fun get(index: Int) = args[index]

    fun getOrNull(index: Int) = if (isInBounds(index)) args[index] else null
    inline fun getOrDefault(index: Int, default: () -> String) = if (isInBounds(index)) args[index] else default()

    fun getFloat(index: Int) = get(index).toFloat()
    fun getFloatOrNull(index: Int) = getOrNull(index)?.toFloatOrNull()
    inline fun getFloatOrDefault(index: Int, default: () -> Float) = getFloatOrNull(index) ?: default()

    fun getBoolean(index: Int) = get(index).toBoolean()
    fun getBooleanOrNull(index: Int) = getOrNull(index)?.toBoolean()
    inline fun getBooleanOrDefault(index: Int, default: () -> Boolean) = getBooleanOrNull(index) ?: default()

    fun getInt(index: Int) = get(index).toInt()
    fun getIntOrNull(index: Int) = getOrNull(index)?.toIntOrNull()
    inline fun getIntOrDefault(index: Int, default: () -> Int) = getIntOrNull(index) ?: default()

    fun getLong(index: Int) = get(index).toLong()
    fun getLongOrNull(index: Int) = getOrNull(index)?.toLongOrNull()
    inline fun getLongOrDefault(index: Int, default: () -> Long) = getLongOrNull(index) ?: default()
}
