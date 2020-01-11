package sharkbound.misc

fun main() {
    val arr = Array(5) { Array(5) { -1 } }
    arr.forEach {
        println("${it.size}")
    }
}