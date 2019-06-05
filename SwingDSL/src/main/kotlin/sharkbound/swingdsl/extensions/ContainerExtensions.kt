package sharkbound.swingdsl.extensions

import sharkbound.swingdsl.builders.TextFieldBuilder
import java.awt.Container
import java.awt.Dimension
import java.awt.FlowLayout
import java.awt.event.ActionEvent
import javax.swing.*

fun Container.button(
    text: String,
    size: Pair<Int, Int>? = null,
    icon: Icon? = null,
    constraint: Any? = null,
    action: ActionEvent?.() -> Unit
): JButton =
    JButton(text).apply {
        size?.apply {
            preferredSize = Dimension(first, second)
        }
        this.icon = icon
        addActionListener(action)
        this@button.add(this, constraint)
    }


/**
 * creates a Y_AXIS aligned JPanel with BoxLayout, then adds it to the [Container]
 */
inline fun Container.vBoxLayout(
    size: Pair<Int, Int>? = null,
    constraint: Any? = null,
    block: JPanel.() -> Unit
): JPanel =
    JPanel().apply {
        layout = BoxLayout(this, BoxLayout.Y_AXIS)
        size?.apply {
            preferredSize = toDimension
        }
        apply(block)
        this@vBoxLayout.add(this, constraint)
    }

/**
 * creates a X_AXIS aligned JPanel with BoxLayout, then adds it to the [Container]
 */
inline fun Container.hBoxLayout(
    size: Pair<Int, Int>? = null,
    constraint: Any? = null,
    block: JPanel.() -> Unit
): JPanel =
    JPanel().apply {
        layout = BoxLayout(this, BoxLayout.X_AXIS)
        size?.apply {
            preferredSize = toDimension
        }
        apply(block)
        this@hBoxLayout.add(this, constraint)
    }

/**
 * left aligned flow layout
 */
inline fun Container.leftFlowLayout(
    hGap: Int = 2,
    vGap: Int = 2,
    size: Pair<Int, Int>? = null,
    constraint: Any? = null,
    block: JPanel.() -> Unit
): JPanel =
    createFlowLayout(FlowLayout.LEFT, hGap, vGap).apply {
        block()
        size?.apply {
            preferredSize = toDimension
        }
        this@leftFlowLayout.add(this, constraint)
    }

inline fun Container.rightFlowLayout(
    hGap: Int = 2,
    vGap: Int = 2,
    size: Pair<Int, Int>? = null,
    constraint: Any? = null,
    block: JPanel.() -> Unit
): JPanel =
    createFlowLayout(FlowLayout.RIGHT, hGap, vGap).apply {
        block()
        size?.apply {
            preferredSize = toDimension
        }
        this@rightFlowLayout.add(this, constraint)
    }

inline fun Container.centerFlowLayout(
    hGap: Int = 2,
    vGap: Int = 2,
    size: Pair<Int, Int>? = null,
    constraint: Any? = null,
    block: JPanel.() -> Unit
): JPanel =
    createFlowLayout(FlowLayout.CENTER, hGap, vGap).apply {
        this.block()
        size?.apply {
            preferredSize = toDimension
        }
        this@centerFlowLayout.add(this, constraint)
    }

fun createFlowLayout(align: Int, hGap: Int = 2, vGap: Int = 2): JPanel =
    JPanel(FlowLayout(align, hGap, vGap))

inline fun Container.textField(
    initalText: String = "",
    constraint: Any? = null,
    block: TextFieldBuilder.() -> Unit
): JTextField =
    TextFieldBuilder(JTextField(initalText))
        .apply(block)
        .field
        .apply {
            this@textField.add(this, constraint)
        }