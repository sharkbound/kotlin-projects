fun input(str: String, newLine: Boolean = false): String {
    if (newLine) println(str) else print(str)
    return readLine()!!
}