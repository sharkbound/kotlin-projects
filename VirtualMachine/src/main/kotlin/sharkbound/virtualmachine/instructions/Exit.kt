package sharkbound.virtualmachine.instructions

import sharkbound.virtualmachine.VirtualMachine
import kotlin.system.exitProcess

class Exit : Instruction {
    override val name = "EXIT"

    override fun execute(vm: VirtualMachine) {
        exitProcess(0)
    }
}