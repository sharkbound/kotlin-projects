package sharkbound.virtualmachine

import sharkbound.virtualmachine.instructions.*

class InstructionSet {
    val instructions = mutableListOf<Instruction>()


    fun Instruction.append() {
        instructions.add(this)
    }

    fun printLine() {
        PrintLine().append()
    }

    fun printLine(value: Any) {
        Push(value).append()
        this.printLine()
    }


    fun print() {
        Print().append()
    }

    fun print(value: Any) {
        Push(value).append()
        this.print()
    }

    fun push(value: Any) {
        Push(value).append()
    }

    fun label(name: String) {
        Label(name).append()
    }

    fun jump(label: String) {
        Jump(label).append()
    }

    fun jumpIfTrue(label: String) {
        JumpIfTrue(label).append()
    }

    fun jumpIfFalse(label: String) {
        JumpIfFalse(label).append()
    }

    fun branch(labelTrue: String, labelFalse: String) {
        Branch(labelTrue, labelFalse).append()
    }

    fun pushRandom(vararg options: Any) {
        PushRandom(options.toList()).append()
    }

    fun duplicate() {
        Duplicate().append()
    }

    fun exit() {
        Exit().append()
    }

    fun store(variableName: String) {
        Store(variableName).append()
    }

    fun store(variableName: String, value: Any) {
        Push(value).append()
        Store(variableName).append()
    }

    fun load(variableName: String) {
        Load(variableName).append()
    }

    fun sleep(millis: Long) {
        Sleep(millis).append()
    }

    companion object {
        inline infix fun build(block: InstructionSet.() -> Unit): List<Instruction> {
            with(InstructionSet()) {
                block()
                return instructions
            }
        }
    }
}