package sharkbound.swingdsl.dsl

import java.awt.*
import javax.swing.JDialog
import javax.swing.JPanel
import javax.swing.WindowConstants

class CustomDialog(
    var dialogOwner: Window? = null,
    title: String = "",
    layout: LayoutManager? = null,
    private val type: ModalityType = ModalityType.APPLICATION_MODAL
) : JDialog(dialogOwner, title, type) {
    val root = JPanel(layout ?: BorderLayout())

    init {
        contentPane = root
    }

    fun root(block: JPanel.() -> Unit) {
        root.block()
    }

    fun display(
        center: Boolean = true,
        position: Pair<Int, Int>? = null,
        size: Pair<Int, Int>? = null,
        pack: Boolean = false,
        undecorated: Boolean = false
    ) {
        if (position != null && center) {
            throw IllegalArgumentException("cannot use both center and position")
        }

        if (size != null && pack) {
            throw IllegalArgumentException("cannot use both size and pack")
        }


        size?.apply {
            setSize(first, second)
        }

        isUndecorated = undecorated
        if (pack) {
            pack()
        }

        position?.apply {
            location = Point(first, second)
        }

        if (center) {
            setLocationRelativeTo(null)
        }

        root.preferredSize = Dimension(this.size.width, this.size.height)
        defaultCloseOperation = WindowConstants.DISPOSE_ON_CLOSE
        isVisible = true
    }
}

inline fun <W : Window> dialog(
    owner: W? = null,
    center: Boolean = true,
    position: Pair<Int, Int>? = null,
    pack: Boolean = false,
    undecorated: Boolean = false,
    size: Pair<Int, Int>? = null,
    title: String = "",
    layout: LayoutManager? = null,
    type: Dialog.ModalityType = Dialog.ModalityType.APPLICATION_MODAL,
    show: Boolean = true,
    disposeOnClose: Boolean = true,
    block: CustomDialog.(W?) -> Unit
): CustomDialog {
    val modal = CustomDialog(owner, title, layout, type).apply {
        block(owner)
    }
    if (show) {
        modal.display(center, position, size, pack, undecorated)
    }
    return modal
}