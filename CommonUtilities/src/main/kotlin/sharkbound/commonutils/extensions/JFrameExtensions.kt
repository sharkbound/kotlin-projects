package sharkbound.commonutils.extensions

import sharkbound.commonutils.JFrameCloseOperation
import java.awt.Container
import java.awt.Dimension
import java.awt.Point
import java.lang.IllegalArgumentException
import javax.swing.JComponent
import javax.swing.JFrame

fun JFrame.showFrame(
    closeOperation: JFrameCloseOperation? = null,
    size: Dimension? = null,
    pack: Boolean = false,
    location: Point? = null,
    center: Boolean = false,
    content: Container? = null
) {
    if (size != null && pack) {
        throw IllegalArgumentException("cannot do both size and pack, must do or the ether")
    }

    when {
        size != null && pack -> throw IllegalArgumentException("cannot do both size and pack, must do or the ether")
        size != null -> setSize(size)
        pack -> pack()
    }

    when {
        location != null && center -> throw IllegalArgumentException("cannot define both location and center, must use one or the other")
        location != null -> setLocation(location)
        center -> setLocationRelativeTo(null)
    }

    closeOperation?.let {
        defaultCloseOperation = it.code
    }

    content?.let {
        contentPane = content
    }

    isVisible = true
}
