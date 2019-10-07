package sharkbound.virtualmachine.instructions

import sharkbound.virtualmachine.VirtualMachine

class Push(val value: Any) : Instruction {
    override val name = "PUSH"

    override fun execute(vm: VirtualMachine) {
        vm.push(value)
    }
}