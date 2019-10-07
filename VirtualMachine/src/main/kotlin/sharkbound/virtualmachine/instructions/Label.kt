package sharkbound.virtualmachine.instructions

class Label(val labelName: String) : Instruction {
    override val name = "LABEL"
}