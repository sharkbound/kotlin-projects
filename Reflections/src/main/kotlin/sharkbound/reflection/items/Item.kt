package sharkbound.reflection.items

open class Item(open val name: String, open val durability: Int) {
    override fun toString(): String {
        return "Item(name='$name', durability=$durability)"
    }
}