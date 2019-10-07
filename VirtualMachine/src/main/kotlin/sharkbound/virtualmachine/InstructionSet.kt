package sharkbound.virtualmachine

import sharkbound.virtualmachine.instructions.*

class InstructionSet {
    val instructions = mutableListOf<Instruction>()

    fun printLine(value: Any) {
        instructions.add(Push(value))
        instructions.add(PrintLine())
    }

    fun print(value: Any) {
        instructions.add(Push(value))
        instructions.add(Print())
    }

    fun push(value: Any) {
        instructions.add(Push(value))
    }

    fun label(name: String) {
        instructions.add(Label(name))
    }

    fun jump(label: String) {
        instructions.add(Jump(label))
    }

    fun jumpIfTrue(label: String) {
        instructions.add(JumpIfTrue(label))
    }

    fun jumpIfFalse(label: String) {
        instructions.add(JumpIfFalse(label))
    }

    fun branch(labelTrue: String, labelFalse: String) {
        instructions.add(Branch(labelTrue, labelFalse))
    }

    fun pushRandom(vararg options: Any) {
        instructions.add(PushRandom(options.toList()))
    }

    fun duplicate() {
        instructions.add(Duplicate())
    }

    fun exit() {
        instructions.add(Exit())
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