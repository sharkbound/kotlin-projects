package sharkbound.swingdsl.util

import javax.swing.AbstractButton
import javax.swing.ButtonGroup

val buttonGroups = mutableMapOf<Any, ButtonGroup>()

val allButtonGroups: Sequence<ButtonGroup>
    get() = buttonGroups.values.asSequence()

private fun ensureButtonGroupExists(id: Any) {
    if (id !in buttonGroups) {
        buttonGroups[id] = ButtonGroup()
    }
}

fun findButtonGroup(id: Any): ButtonGroup? = buttonGroups[id]
fun getButtonGroup(id: Any): ButtonGroup = buttonGroups.getValue(id)


fun <B : AbstractButton> addToButtonGroup(groupId: Any, button: B, selected: Boolean = false): B =
    button.also {
        it.isSelected = selected
        ensureButtonGroupExists(groupId)
        getButtonGroup(groupId).apply {
            add(it)
            if (selected) {
                setSelected(it.model, selected)
            }
        }
    }

fun <B : AbstractButton> removeFromButtonGroup(groupId: Any, button: B): B =
    button.also {
        getButtonGroup(groupId).remove(it)
    }

fun deselectAllButtonsInGroup(groupId: Any) {
    for (button in getButtonGroup(groupId).elements) {
        button.isSelected = false
    }
}