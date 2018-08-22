package adventure.util

fun input(prompt: String, newline: Boolean = false): String {
    if (newline) {
        println(prompt)
    } else {
        print(prompt)
    }
    return readLine()!!
}