package sharkbound.commonutils.util

import java.nio.file.Paths

fun toPath(path: String) = Paths.get(path)

val String.asPath get() = toPath(this)