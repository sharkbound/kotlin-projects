package sharkbound.commonutils.util

import java.awt.FlowLayout
import javax.swing.JPanel

/**
 * left aligned flow layout
 */
fun leftFlowLayout(block: JPanel.() -> Unit) =
    _createFlowLayout(FlowLayout.LEFT).apply(block)

fun rightFlowLayout(block: JPanel.() -> Unit) =
    _createFlowLayout(FlowLayout.RIGHT).apply(block)

fun centerFlowLayout(block: JPanel.() -> Unit) =
    _createFlowLayout(FlowLayout.CENTER).apply(block)

private fun _createFlowLayout(align: Int) = JPanel(FlowLayout(align))