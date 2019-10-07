package sharkbound.virtualmachine.instructions

import sharkbound.virtualmachine.VirtualMachine

class Sleep(val millis: Long) : Instruction {
    override val name = "WAIT"

    override fun execute(vm: VirtualMachine) {
        Thread.sleep(millis)
    }
}