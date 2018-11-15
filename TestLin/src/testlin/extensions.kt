package testlin

fun Sequence<MatchResult>.values(vararg trimChars: Char): List<String> =
    map { it.value.trim(*trimChars) }.filter { it.isNotBlank() }.toList()