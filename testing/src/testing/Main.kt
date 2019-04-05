package testing

fun main() {
    val itChain = Chain(listOf(1..10, 11..20)) + (1..10) + listOf("LOL", -1, .4)
    println(itChain)
}
