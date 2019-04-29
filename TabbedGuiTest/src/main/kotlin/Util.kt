class ParseSizeSucess(val width: Int, val height: Int)

inline fun parseSize(string: String, onSuccess: ParseSizeSucess.() -> Unit, onFailure: (String) -> Unit) {
    val match = reSize.find(string)
    if (match == null) {
        onFailure(string)
        return
    }
    val (width, height) = match.destructured.toList().map(String::toInt)
    ParseSizeSucess(width, height).onSuccess()
}

val reSize = """(\d+)x(\d+)""".toRegex()