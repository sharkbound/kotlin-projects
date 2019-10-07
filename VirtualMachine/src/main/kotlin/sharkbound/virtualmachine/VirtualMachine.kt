package sharkbound.virtualmachine

import sharkbound.commonutils.collections.NonNullableMutableMap
import sharkbound.commonutils.extensions.len
import sharkbound.virtualmachine.instructions.Instruction
import sharkbound.virtualmachine.instructions.Jump
import sharkbound.virtualmachine.instructions.Label
import java.util.*

class VirtualMachine {
    val stack = ArrayDeque<Any>()
    val labels = NonNullableMutableMap<String, Int>()
    var ptr = 0

    fun pop() =
        stack.pop()

    fun push(value: Any) =
        stack.push(value)

    fun goto(labelName: String) {
        ptr = labels[labelName]
    }

    fun goto(addr: Int) {
        ptr = addr
    }

    companion object {
        fun run(instructions: List<Instruction>) {
            with(VirtualMachine()) {
                instructions.forEachIndexed { i, op ->
                    if (op is Label) {
                        labels[op.labelName] = i
                    }
                }

                while (ptr >= 0 && ptr < instructions.len) {
                    val op = instructions[ptr]
                    op.execute(this)

                    if (op !is Jump) {
                        ptr += 1
                    }
                }
            }
        }
    }
}