package sharkbound.menu

class CallArgs(val args: List<String>) {
    val length = args.size

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
}