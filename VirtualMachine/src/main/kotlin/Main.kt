import sharkbound.virtualmachine.VirtualMachine

fun main() {
    VirtualMachine.execute {
        store("number", 1)
        label("1")
        load("number")
        printLine()
        sleep(1000)
        jump("1")
    }
}