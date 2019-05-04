package sharkbound.commonutils.util

/**
 * prompts the user for a string, reads from stdin, if the value passes the predicate check, the value is returned
 *
 * @param prompt the string to ask the user
 * @param predicate function that accepts the single string as a parameter, and returns a boolean indicating if the string should be returned
 * @return the string inputted by the user that passed the predicate check
 */
inline fun ask(prompt: String, predicate: (String) -> Boolean = { true }): String {
    var input = ""
    do {
        print(prompt)
        input = readLine() ?: continue
    } while (!predicate(input))
    return input
}

/**
 * prompts the user for a [Int], reads from stdin, if the value passes the predicate check, the value is returned
 *
 * @param prompt the string to ask the user
 * @param predicate function that accepts the single [Int] as a parameter, and returns a boolean indicating if the [Int] should be returned
 * @return the [Int] inputted by the user that passed the predicate check
 */
inline fun askInt(prompt: String, predicate: (Int) -> Boolean = { true }): Int {
    return ask(prompt, predicate = {
        it.toIntOrNull()?.let(predicate) ?: false
    }).toInt()
}

/**
 * prompts the user for a [Double], reads from stdin, if the value passes the predicate check, the value is returned
 *
 * @param prompt the string to ask the user
 * @param predicate function that accepts the single [Double] as a parameter, and returns a boolean indicating if the [Double] should be returned
 * @return the [Double] inputted by the user that passed the predicate check
 */
inline fun askDouble(prompt: String, predicate: (Double) -> Boolean = { true }): Double {
    return ask(prompt, predicate = {
        it.toDoubleOrNull()?.let(predicate) ?: false
    }).toDouble()
}

/**
 * prompts the user for a [Float], reads from stdin, if the value passes the predicate check, the value is returned
 *
 * @param prompt the string to ask the user
 * @param predicate function that accepts the single [Float] as a parameter, and returns a boolean indicating if the [Float] should be returned
 * @return the [Float] inputted by the user that passed the predicate check
 */
inline fun askFloat(prompt: String, predicate: (Float) -> Boolean = { true }): Float {
    return ask(prompt, predicate = {
        it.toFloatOrNull()?.let(predicate) ?: false
    }).toFloat()
}

/***
 * prompts the user for a [Long], reads from stdin, if the value passes the predicate check, the value is returned
 *
 * @param prompt the string to ask the user
 * @param predicate function that accepts the single [Long] as a parameter, and returns a boolean indicating if the [Long] should be returned
 * @return the [Long] inputted by the user that passed the predicate check
 */
inline fun askLong(prompt: String, predicate: (Long) -> Boolean = { true }): Long {
    return ask(prompt, predicate = {
        it.toLongOrNull()?.let(predicate) ?: false
    }).toLong()
}

/**
 * waits for the user to press enter in the console
 */
fun pause(putEmptyLine: Boolean = true) {
    var msg = "press enter to continue"
    if (putEmptyLine) {
        msg = "\n" + msg
    }
    ask(msg)
}