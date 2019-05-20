package sharkbound.reflection.items

fun main() {
    val items = findSubClasses<Item>()
    println(items)
}