fun interface Test<T> {
    fun run(arg: T)
}

fun runTest(test: Test<String>) {
    test.run("explorer")
}

fun main() {
    runTest {
        println("greetings $it!")
    }
}