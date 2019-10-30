package sharkbound

fun main() {
    val numbers = 1..10
    println(numbers.fold(0) { acc, i ->
        acc + i
    })
}

