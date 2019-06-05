package sharkbound.swingdsl.dsl

import java.awt.Dimension
import java.awt.FlowLayout
import java.awt.LayoutManager
import java.awt.Point
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.WindowConstants

class Frame(title: String = "", layout: LayoutManager? = null) : JFrame(title) {
    val root = JPanel(FlowLayout())

    init {
        contentPane = root
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
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        isVisible = true
    }
}

fun frame(title: String = "", block: Frame.() -> Unit): Frame =
    Frame(title).apply(block)