package sharkbound.swingdsl.extensions

import java.awt.event.ActionEvent
import javax.swing.Icon
import javax.swing.JComponent
import javax.swing.JMenuItem
import javax.swing.JPopupMenu

val idToPopupMenu = mutableMapOf<Any, JPopupMenu>()
val componentToPopupMenuID = mutableMapOf<JComponent, Any>()

fun getPopupMenu(id: Any): JPopupMenu = findPopupMenu(id)!!
fun findPopupMenu(id: Any): JPopupMenu? {
    if (id is JComponent) {
        return idToPopupMenu[componentToPopupMenuID[id] ?: return null]
    }
    return idToPopupMenu[id]
}


val JComponent.popupMenu: JPopupMenu
    get() = getPopupMenu(this)

val JComponent.hasPopupMenu: Boolean
    get() = this in componentToPopupMenuID


inline fun JPopupMenu.item(
    label: String,
    icon: Icon? = null,
    mnemonic: Int? = null,
    hideMenuAfterClick: Boolean = true,
    noinline action: (JMenuItem.(ActionEvent?) -> Unit)? = null,
    block: JMenuItem.() -> Unit = {}
): JMenuItem =
    JMenuItem(label, icon).apply {
        if (mnemonic != null) {
            this.mnemonic = mnemonic
        }
        action?.let {
            this.action(it)
        }
        if (hideMenuAfterClick) {
            mouseEvent {
                released {
                    this@item.isVisible = false
                }
            }
        }
        block()
        this@item.add(this)
    }

fun JPopupMenu.separator() {
    addSeparator()
}