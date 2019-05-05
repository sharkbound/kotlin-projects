package sharkbound.menu

open class MenuOption(
    open val name: String,
    open val desc: String,
    open val onExecute: suspend Arguments.() -> Unit
)