package sharkbound.aoc.day1

import sharkbound.aoc.read

fun main() {
    println(read(1).lines().mapNotNull { it.toIntOrNull() }.map { it / 3 - 2 }.sum())
}