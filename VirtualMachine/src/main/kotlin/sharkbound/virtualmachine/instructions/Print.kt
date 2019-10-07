package sharkbound.virtualmachine.instructions

import sharkbound.virtualmachine.VirtualMachine

class Print : Instruction {
    override val name = "PRINT"

    override fun execute(vm: VirtualMachine) {
        print(vm.pop())
    }
}