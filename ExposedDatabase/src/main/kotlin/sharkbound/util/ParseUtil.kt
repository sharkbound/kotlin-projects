package sharkbound.util

import sharkbound.menu.Arguments

private val reParseArguments = """(".+?"|[^ ]+)""".toRegex()

fun parseArguments(string: String): Arguments {
    return Arguments(reParseArguments.findAll(string).asSequence().map { it.value.trim('"', ' ') }.toList())
}