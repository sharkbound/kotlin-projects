package sharkbound.menu

class Arguments(val args: List<String>) {
    val length = args.size
    val first = args.getOrElse(0) { "" }
    val hasFirst = !first.isBlank()

    inline fun ifArgExist(index: Int, block: (String) -> Unit) {
        if (index < length) {
            block(args[index])
        }
    }

    inline fun ifArgNotExist(index: Int, block: (String) -> Unit) {
        if (length <= index) {
            block(args[index])
        }
    }

    inline fun safeArg(index: Int, default: () -> String): String = args.getOrElse(index) { default() }

    fun safeArg(index: Int, default: String): String = args.getOrElse(index) { default }
    override fun toString(): String {
        return "Arguments $args"
    }
}