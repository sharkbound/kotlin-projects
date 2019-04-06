package gui

import java.awt.Point
import java.awt.Toolkit
import javax.swing.JFrame

fun buildMainFrame(title: String, width: Int = 600, height: Int = 600): JFrame {
    val frame = JFrame(title)
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.setSize(width, height)
    frame.isVisible = true

    val screenSize = Toolkit.getDefaultToolkit().screenSize
    frame.location = Point(screenCenter.x - width / 2, screenCenter.y - height / 2)
    return frame
}

val screenCenter = Toolkit.getDefaultToolkit().screenSize.run { Point(width / 2, height / 2) }