package sharkbound.menu

open class Menu {
    open val options = mutableMapOf<String, MenuOption>()
    open lateinit var description: String
    fun addOption(name: String, desc: String, execute: suspend Arguments.() -> Unit) {
        options[name] = MenuOption(name, desc, execute)
    }

    open operator fun invoke(block: Menu.() -> Unit): Menu = apply(block)
}

fun createMenu(block: Menu.() -> Unit): Menu = Menu().invoke(block)