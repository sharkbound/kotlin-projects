package sharkbound.virtualmachine.instructions

import sharkbound.virtualmachine.VirtualMachine

class JumpIfFalse(val label: String) : Instruction {
    override val name = "JUMP_IF_FALSE"

    override fun execute(vm: VirtualMachine) {
        vm.pop().let {
            if (it is Boolean && !it) {
                vm.goto(label)
            }
        }
    }
}