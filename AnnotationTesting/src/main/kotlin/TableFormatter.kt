fun main() {
    val data = listOf(
        Row("jimmy"),
        Row("james", "scientist"),
        Row("lamb", "baa", "baa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
    )

    val headers = listOf<String>()

    println(format(listOf("name", "age", "interests", "What?"), data))
}

const val SPACER = "  "

fun format(headers: List<String>, rows: List<Row>): String = buildString {
    val maxDataLength = maxOf(
        rows.flatMap { it.data.asIterable() }.map { it.length }.max() ?: return@buildString,
        headers.map { it.length }.max() ?: 0
    )

    val maxRowLengths = mutableMapOf<Int, Int>()
    val maxRowCount = rows.asSequence().map { it.data.size }.max() ?: 0
    val joinedHeaders = buildString {
        //        headers.joinToString("  ") { it.padEnd(maxDataLength) }.trim()
        for ((i, header) in headers.withIndex()) {
            val maxValueLength = rows.asSequence().map { it.data.getOrElse(i) { "" }.length }.max() ?: 0
            val maxRowLength = maxOf(header.length, maxValueLength)
            maxRowLengths[i] = maxRowLength
            append(header.padEnd(maxRowLength))
            append(SPACER)
        }
    }

    appendln(joinedHeaders)
    for (row in rows) {
        append(buildString {
            for (i in 0 until maxRowCount) {
                append(row.data.getOrElse(i) { "" }.padEnd(maxRowLengths.getValue(i)))
                append(SPACER)
            }
        }.trim())
        appendln()
    }
}

fun String.center(len: Int, padChar: Char = ' '): String {
    if (length >= len) {
        return this
    }
    val width = len - length
    val strLen = length
    val finalLength = strLen + width
    return buildString(finalLength) {
        repeat(width / 2) { append(padChar) }
        append(this@center)
        while (length < finalLength) {
            append(padChar)
        }
    }
}

operator fun Char.times(repeatCount: Int): String = buildString {
    repeat(repeatCount) {
        append(this@times)
    }
}


class Row(vararg val data: String)
