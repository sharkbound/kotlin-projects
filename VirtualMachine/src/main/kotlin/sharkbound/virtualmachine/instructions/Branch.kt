package sharkbound.virtualmachine.instructions

import sharkbound.virtualmachine.VirtualMachine

class Branch(val labelTrue: String, val labelFalse: String) : Instruction {
    override val name = "BRANCH"

    override fun execute(vm: VirtualMachine) {
        vm.pop().let {
            if (it is Boolean && it) {
                vm.goto(labelTrue)
            } else {
                vm.goto(labelFalse)
            }
        }
    }
}