inline fun parseSize(string: String, onSuccess: (Int, Int) -> Unit, onFailure: (String) -> Unit) {
    val match = reSize.find(string)
    if (match == null) {
        onFailure(string)
        return
    }
    val (w, h) = match.destructured.toList().map(String::toInt)
    onSuccess(w, h)
}

val reSize = """(\d+)x(\d+)""".toRegex()