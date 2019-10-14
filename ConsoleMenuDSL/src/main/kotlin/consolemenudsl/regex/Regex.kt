package consolemenudsl.regex

object RegexPatterns {
    val splitArgs = """(['"].+['"]|[^\s]+)""".toRegex()
}
