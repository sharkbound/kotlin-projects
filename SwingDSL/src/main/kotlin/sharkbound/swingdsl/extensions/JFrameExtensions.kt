package sharkbound.swingdsl.extensions

import sharkbound.swingdsl.enums.JFrameCloseOperation
import java.awt.*
import java.awt.event.WindowEvent
import java.lang.IllegalArgumentException
import javax.swing.JFrame
import javax.swing.JMenuBar

/**
 * makes the frame visible
 *
 * @param closeOperation the operation to do when the window is closed
 * @param size the size of the window, cannot be used with [pack]
 * @param pack if true, the windows is packed to be as small as possible [size]
 * @param location location to show the window at, cannot be used with [center]
 * @param center if true, the window will be shown, cannot be used with [location]
 * @param content the contentPane of the JFrame
 */
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

    content?.let {
        contentPane = content
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

    isVisible = true
}

/**
 * dispatches WindowEvent(source, WindowEvent.WINDOW_CLOSING) to the receiving frame
 *
 * @param source the source of the close event
 */
fun JFrame.sendCloseEvent(source: Window = this) {
    dispatchEvent(WindowEvent(source, WindowEvent.WINDOW_CLOSING))
}

/**s
 * dispatches WindowEvent(source, WindowEvent.WINDOW_CLOSING) to the receiving dialog
 *
 * @param source the source of the close event
 */
fun Dialog.sendCloseEvent(source: Window = this) {
    dispatchEvent(WindowEvent(source, WindowEvent.WINDOW_CLOSING))
}

fun JFrame.menuBar(block: JMenuBar.() -> Unit): JMenuBar =
    JMenuBar().apply {
        block()
        this@menuBar.jMenuBar = this
    }

inline fun <T : JFrame> T.repaintLoop(getDelay: T.() -> Long) {
    while (true) {
        repaint()
        Thread.sleep(getDelay())
    }
}