import sharkbound.commonutils.enums.JFrameCloseOperation
import sharkbound.commonutils.extensions.showFrame
import java.awt.Dimension


fun main() {
    val frame = SpringLayoutForm()

    frame.showFrame(
        JFrameCloseOperation.EXIT_ON_CLOSE,
        size = Dimension(600, 600),
        center = true
    )
}