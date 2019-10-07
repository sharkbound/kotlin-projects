package sharkbound.virtualmachine.instructions

import sharkbound.commonutils.extensions.use
import sharkbound.commonutils.extensions.with
import sharkbound.virtualmachine.VirtualMachine

class Duplicate : Instruction {
    override val name = "DUPLICATE"

    override fun execute(vm: VirtualMachine) {
        vm use {
            pop() with {
                push(it)
                push(it)
            }
        }
    }
}