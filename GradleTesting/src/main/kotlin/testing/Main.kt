package testing

import java.lang.Exception
import java.lang.NumberFormatException

fun ask(prompt: String): String {
    print(prompt)
    return readLine()!!
}

fun askNumbers(): List<Int> {
    while (true) {
        try {
            return ask("\nenter numbers separated by a space\n>>> ").split(' ').map { it.toInt() }
        } catch (e: NumberFormatException) {
            println("invalid number(s)")
        }
    }
}

fun main() {
    while (true) {
        val numbers = askNumbers()
        for (i in 2..numbers.min()!!) {
            if (!numbers.all { it % i == 0 }) {
                continue
            }

            println("$i -> ${numbers.map { "$it=${it / i}" }.joinToString(", ")}")
        }
    }
}