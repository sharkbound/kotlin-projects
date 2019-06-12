package sharkbound.swingdsl.extensions

import sharkbound.swingdsl.util.addToButtonGroup
import sharkbound.swingdsl.util.getButtonGroup
import sharkbound.swingdsl.util.removeFromButtonGroup
import javax.swing.AbstractButton

private val buttonGroupIds = mutableMapOf<AbstractButton, Any>()

val <B : AbstractButton> B.buttonGroupID: Any
    get() = buttonGroupIds.getValue(this)

fun <B : AbstractButton> B.addToGroup(groupId: Any, selected: Boolean = false): B =
    also {
        buttonGroupIds[it] = groupId
        addToButtonGroup(groupId, it, selected)
    }

fun <B : AbstractButton> B.removeFromGroup(groupId: Any): B =
    also {
        buttonGroupIds.remove(it)
        removeFromButtonGroup(groupId, it)
    }

fun <B : AbstractButton> B.selectInGroup(): B =
    also {
        getButtonGroup(it.buttonGroupID).setSelected(it.model, true)
    }

fun <B : AbstractButton> B.deselectInGroup(): B =
    also {
        getButtonGroup(it.buttonGroupID).setSelected(it.model, false)
    }

val <B : AbstractButton> B.isSelectedInGroup: Boolean
    get() = getButtonGroup(buttonGroupID).isSelected(model)