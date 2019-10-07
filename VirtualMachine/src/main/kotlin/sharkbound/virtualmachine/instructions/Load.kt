package sharkbound.virtualmachine.instructions

import sharkbound.virtualmachine.VirtualMachine

class Load(val variableName: String) : Instruction {
    override val name = "LOAD"

    override fun execute(vm: VirtualMachine) {
        vm.load(variableName)
    }
}