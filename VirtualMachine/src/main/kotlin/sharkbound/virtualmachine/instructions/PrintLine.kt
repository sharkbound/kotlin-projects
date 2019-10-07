package sharkbound.virtualmachine.instructions

import sharkbound.virtualmachine.VirtualMachine

class PrintLine : Instruction {
    override val name = "PRINT"

    override fun execute(vm: VirtualMachine) {
        println(vm.pop())
    }
}