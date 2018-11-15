fun main(args: Array<String>) {
//    MainFrame()
    println(Fish())
}

sealed class Animal(val name: String, val species: String) {
    open val sound get() = ""

    override fun toString(): String = "[Animal name:$name species:$species]"
}

class Fish() : Animal("nemo", "fish") {
    override val sound: String
        get() = "blub"
}



