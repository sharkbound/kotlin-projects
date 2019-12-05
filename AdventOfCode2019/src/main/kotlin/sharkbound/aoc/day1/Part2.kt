package sharkbound.aoc.day1

import sharkbound.aoc.read

fun main() {
    println(read(1).lines().filter { it.matches("""\d+""".toRegex()) }.map { it.toInt() / 3 - 2 }.sum())
}