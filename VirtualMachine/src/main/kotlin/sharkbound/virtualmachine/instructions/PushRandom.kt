package sharkbound.virtualmachine.instructions

import sharkbound.virtualmachine.VirtualMachine

class PushRandom(val options: List<Any>) : Instruction {
    override val name = "PUSH_RANDOM"

    override fun execute(vm: VirtualMachine) {
        vm.push(options.random())
    }
}