package sharkbound.aoc.day1

import sharkbound.aoc.read

fun main() {
    println(read(1).lines().mapNotNull { it.toIntOrNull() }.map {
        var fuel = it
        var total = 0
        while (fuel / 3 - 2 > 0) {
            val newFuel = fuel / 3 - 2
            total += newFuel
            fuel = newFuel
        }
        total
    }.sum())
}