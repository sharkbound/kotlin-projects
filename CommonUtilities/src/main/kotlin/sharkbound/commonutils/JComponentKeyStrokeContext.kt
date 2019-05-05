package sharkbound.commonutils

import javax.swing.JComponent

enum class JComponentKeyStrokeContext(val code: Int) {
    WHEN_IN_FOCUSED_WINDOW(JComponent.WHEN_IN_FOCUSED_WINDOW),
    WHEN_ANCESTOR_OF_FOCUSED_COMPONENT(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT),
    WHEN_FOCUSED(JComponent.WHEN_FOCUSED)
}