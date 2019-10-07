package sharkbound.virtualmachine.instructions

import sharkbound.virtualmachine.VirtualMachine

class JumpIfTrue(val label: String) : Instruction {
    override val name = "JUMP_IF_TRUE"

    override fun execute(vm: VirtualMachine) {
        vm.pop().let {
            if (it is Boolean && it) {
                vm.goto(label)
            }
        }
    }
}