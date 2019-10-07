package sharkbound.virtualmachine.instructions

import sharkbound.virtualmachine.VirtualMachine

interface Instruction {
    val name: String

    fun execute(vm: VirtualMachine) {

    }
}