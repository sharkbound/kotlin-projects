package sharkbound.swingdsl.extensions

import sharkbound.swingdsl.builders.TextFieldBuilder
import java.awt.*
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

inline fun Container.borderPanel(hGap: Int = 0, vGap: Int = 0, block: JPanel.() -> Unit): JPanel =
    JPanel(BorderLayout(hGap, vGap)).apply {
        block()
        this@borderPanel.add(this)
    }

inline fun Container.south(layout: LayoutManager = FlowLayout(), block: JPanel.() -> Unit): JPanel =
    JPanel(layout).apply {
        block()
        this@south.add(this, BorderLayout.SOUTH)
    }

inline fun Container.north(layout: LayoutManager = FlowLayout(), block: JPanel.() -> Unit): JPanel =
    JPanel(layout).apply {
        block()
        this@north.add(this, BorderLayout.NORTH)
    }

inline fun Container.east(layout: LayoutManager = FlowLayout(), block: JPanel.() -> Unit): JPanel =
    JPanel(layout).apply {
        block()
        this@east.add(this, BorderLayout.EAST)
    }

inline fun Container.west(layout: LayoutManager = FlowLayout(), block: JPanel.() -> Unit): JPanel =
    JPanel(layout).apply {
        block()
        this@west.add(this, BorderLayout.WEST)
    }

inline fun Container.center(layout: LayoutManager = FlowLayout(), block: JPanel.() -> Unit): JPanel =
    JPanel(layout).apply {
        block()
        this@center.add(this, BorderLayout.CENTER)
    }

fun Container.useBorderLayout(hGap: Int = 0, vGap: Int = 0) {
    layout = BorderLayout(hGap, vGap)
}

fun Container.useCenterFlowLayout(hGap: Int = 0, vGap: Int = 0) {
    layout = FlowLayout(FlowLayout.CENTER, hGap, vGap)
}

fun Container.useLeftFlowLayout(hGap: Int = 0, vGap: Int = 0) {
    layout = FlowLayout(FlowLayout.LEFT, hGap, vGap)
}

fun Container.useRightFlowLayout(hGap: Int = 0, vGap: Int = 0) {
    layout = FlowLayout(FlowLayout.RIGHT, hGap, vGap)
}

fun Container.panel(constraint: Any? = null, block: JPanel.() -> Unit): JPanel =
    JPanel().apply {
        block()
        this@panel.add(this, constraint)
    }

inline fun Container.spacer(w: Int, h: Int, constraint: Any? = null, block: JPanel.() -> Unit = {}): JPanel =
    JPanel().apply {
        size(w, h)
        minimumSize = Dimension(w, h)
        block()
        this@spacer.add(this, constraint)
    }

fun Container.useVBoxLayout() {
    layout = BoxLayout(this, BoxLayout.Y_AXIS)
}


fun Container.useHBoxLayout() {
    layout = BoxLayout(this, BoxLayout.X_AXIS)
}