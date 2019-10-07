package sharkbound.virtualmachine.instructions

import sharkbound.virtualmachine.VirtualMachine

class Jump(val label: String) : Instruction {
    override val name = "JUMP"

    override fun execute(vm: VirtualMachine) {
        vm.goto(label)
    }
}