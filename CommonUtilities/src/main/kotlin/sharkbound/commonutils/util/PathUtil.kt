package sharkbound.commonutils.util

import java.nio.file.Path

fun toPath(path: String) = Path.of(path)

val String.asPath get() = toPath(this)