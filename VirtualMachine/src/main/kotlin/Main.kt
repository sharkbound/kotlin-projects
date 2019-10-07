import sharkbound.virtualmachine.VirtualMachine

fun main() {
    VirtualMachine.buildAndRun {
        label("1")
        printLine("label 1")
        pushRandom(true, false)
        branch("1", "2")

        label("2")
        printLine("label 2")
        pushRandom(true, false)
        jumpIfTrue("1")
    }
}