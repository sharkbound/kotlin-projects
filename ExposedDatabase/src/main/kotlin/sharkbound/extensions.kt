package sharkbound

import sharkbound.util.parseArguments

fun String.toArguments() = parseArguments(this)