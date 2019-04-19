package gui.util

import gui.listeners.KeyboardQuitListener
import java.awt.*
import javax.swing.JComponent
import javax.swing.JFrame

fun buildEmptyFrame(title: String, width: Int = 600, height: Int = 600): JFrame {
    val frame = JFrame(title)
    val screenSize = Toolkit.getDefaultToolkit().screenSize
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.setSize(width, height)
    frame.location = Point(screenCenter.x - width / 2, screenCenter.y - height / 2)
    return frame
}

val screenCenter = Toolkit.getDefaultToolkit().screenSize.run { Point(width / 2, height / 2) }

fun centerJFrame(frame: Frame, w: Int, h: Int) = Point(screenCenter.x - w / 2, screenCenter.y - h / 2)
fun centerJFrame(frame: Frame) = centerJFrame(frame, frame.width, frame.height)

fun <T : Component> T.makeDark(): T {
    background = Color.BLACK
    foreground = Color.WHITE
    return this
}

fun JFrame.exitOnClose(): JFrame {
    defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    return this
}

fun GridBagConstraints.configure(
    weightX: Double = 1.0,
    weightY: Double = 1.0,
    fill: Int = GridBagConstraints.BOTH,
    x: Int = 0,
    y: Int = 0
): GridBagConstraints = apply {
    weightx = weightX
    weighty = weightY
    this.fill = fill
    gridx = x
    gridy = y
}

fun <T : JComponent> T.addKeyboardQuitListener(quitFrame: JFrame): T {
    addKeyListener(KeyboardQuitListener(quitFrame))
    return this
}