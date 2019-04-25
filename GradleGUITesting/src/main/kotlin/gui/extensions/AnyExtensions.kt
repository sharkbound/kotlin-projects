package gui.extensions

operator fun String.times(count: Int) = buildString {
    repeat(count) { append(this@times) }
}
