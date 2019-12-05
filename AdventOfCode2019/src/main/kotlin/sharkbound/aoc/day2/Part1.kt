package sharkbound.aoc.day2

import sharkbound.aoc.read

fun main() {
    val program = read(2).split(",").map { it.trim().toInt() }.toMutableList()
    program[1] = 12
    program[2] = 2
    for (chunk in program.chunked(4)) {
        val (op, a, b, c) = chunk
        if (op == 99) {
            break
        }
        when (op) {
            1 -> program[c] = program[a] + program[b]
            2 -> program[c] = program[a] * program[b]
        }
    }
    println("${program[0]}")
}