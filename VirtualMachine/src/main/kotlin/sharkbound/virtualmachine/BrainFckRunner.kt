package sharkbound.virtualmachine

import java.util.*

class BrainFckRunner {
    val stack = ArrayDeque<Any>()
    val labels = mutableMapOf<String, Int>()
}