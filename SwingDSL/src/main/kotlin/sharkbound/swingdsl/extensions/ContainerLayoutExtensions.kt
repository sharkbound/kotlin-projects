package sharkbound.swingdsl.extensions

import sharkbound.swingdsl.enums.SplitPaneOrientation
import sharkbound.swingdsl.enums.TabLayout
import sharkbound.swingdsl.enums.TabPlacement
import sharkbound.swingdsl.wrappers.CardLayoutWrapper
import java.awt.*
import javax.swing.*

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
    hGap: Int = 0,
    vGap: Int = 0,
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
    hGap: Int = 0,
    vGap: Int = 0,
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
    hGap: Int = 0,
    vGap: Int = 0,
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

fun createFlowLayout(align: Int, hGap: Int = 0, vGap: Int = 0): JPanel =
    JPanel(FlowLayout(align, hGap, vGap))

inline fun Container.south(layout: LayoutManager = FlowLayout(), block: JPanel.() -> Unit): JPanel {
    ensureLayout { BorderLayout() }
    return JPanel(layout).apply {
        block()
        this@south.add(this, BorderLayout.SOUTH)
    }
}

inline fun Container.north(layout: LayoutManager = FlowLayout(), block: JPanel.() -> Unit): JPanel {
    ensureLayout { BorderLayout() }
    return JPanel(layout).apply {
        block()
        this@north.add(this, BorderLayout.NORTH)
    }
}

inline fun Container.east(layout: LayoutManager = FlowLayout(), block: JPanel.() -> Unit): JPanel =
    JPanel(layout).apply {
        block()
        this@east.add(this, BorderLayout.EAST)
    }

inline fun Container.west(layout: LayoutManager = FlowLayout(), block: JPanel.() -> Unit): JPanel {
    ensureLayout { BorderLayout() }
    return JPanel(layout).apply {
        block()
        this@west.add(this, BorderLayout.WEST)
    }
}

inline fun <T : LayoutManager, C : Container> C.layout(block: C.() -> T): T =
    block().apply {
        this@layout.layout = this
    }

inline fun Container.center(layout: LayoutManager = FlowLayout(), block: JPanel.() -> Unit): JPanel {
    ensureLayout { BorderLayout() }
    return JPanel(layout).apply {
        block()
        this@center.add(this, BorderLayout.CENTER)
    }
}

inline fun <reified T : LayoutManager> Container.ensureLayout(lazyLayout: () -> T) {
    if (layout !is T) {
        layout = lazyLayout()
    }
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

fun Container.useVBoxLayout() {
    layout = BoxLayout(this, BoxLayout.Y_AXIS)
}

fun Container.useHBoxLayout() {
    layout = BoxLayout(this, BoxLayout.X_AXIS)
}

fun Container.useGridBagLayout() {
    ensureLayout { GridBagLayout() }
}

inline fun Container.gridBag(constraint: Any? = null, block: JPanel.() -> Unit): JPanel =
    JPanel(GridBagLayout()).apply {
        block()
        this@gridBag.add(this, constraint)
    }

inline fun Container.tabPane(
    tabPlacement: TabPlacement = TabPlacement.TOP,
    tabLayout: TabLayout = TabLayout.WRAP,
    constraint: Any? = null,
    block: JTabbedPane.() -> Unit
): JTabbedPane =
    JTabbedPane(tabPlacement.alignment, tabLayout.value).apply {
        block()
        this@tabPane.add(this, constraint)
    }

inline fun Container.splitPane(
    orientation: SplitPaneOrientation = SplitPaneOrientation.HORIZONTAL,
    continuousRedraw: Boolean = true,
    constraint: Any? = null,
    block: JSplitPane.() -> Unit
): JSplitPane =
    JSplitPane(orientation.value, continuousRedraw).apply {
        block()
        this@splitPane.add(this, constraint)
    }

inline fun Container.cardPane(
    constraint: Any? = null,
    hGap: Int = 0,
    vGap: Int = 0,
    block: CardLayoutWrapper.() -> Unit
): CardLayoutWrapper =
    CardLayoutWrapper(hGap, vGap).apply {
        block()
        this@cardPane.add(this, constraint)
    }
