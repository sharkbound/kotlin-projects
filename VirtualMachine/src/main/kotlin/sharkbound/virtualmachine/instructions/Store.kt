package sharkbound.virtualmachine.instructions

import sharkbound.virtualmachine.VirtualMachine

class Store(val variableName: String) : Instruction {
    override val name = "STORE"

    override fun execute(vm: VirtualMachine) {
        vm.store(variableName, vm.pop())
    }
}