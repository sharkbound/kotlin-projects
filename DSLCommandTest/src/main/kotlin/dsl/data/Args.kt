package dsl.data

inline class Args(val args: List<String>) {
    val argCount get() = args.size
}