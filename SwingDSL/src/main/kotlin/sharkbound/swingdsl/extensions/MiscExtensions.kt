package sharkbound.swingdsl.extensions

import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics
import java.awt.Point
import java.awt.event.MouseEvent

val Pair<Int, Int>.toDimension: Dimension
    get() = Dimension(first, second)

val Pair<Int, Int>.toPoint: Point
    get() = Point(first, second)

val MouseEvent?.isRightClick: Boolean
    get() = this != null && button == MouseEvent.BUTTON3

val MouseEvent?.isMiddleClick: Boolean
    get() = this != null && button == MouseEvent.BUTTON2

val MouseEvent?.isLeftClick: Boolean
    get() = this != null && button == MouseEvent.BUTTON1

inline fun Graphics.withColor(color: Color, block: Graphics.() -> Unit) {
    val prevColor = this.color
    this.color = color
    block()
    this.color = prevColor
}
