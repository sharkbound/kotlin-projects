package sharkbound.commonutils

import javax.swing.JFrame

enum class JFrameCloseOperation(val code: Int) {
    DISPOSE_ON_CLOSE(JFrame.DISPOSE_ON_CLOSE),
    EXIT_ON_CLOSE(JFrame.EXIT_ON_CLOSE),
    NOTHING(JFrame.DO_NOTHING_ON_CLOSE),
    HIDE_ON_CLOSE(JFrame.HIDE_ON_CLOSE)
}