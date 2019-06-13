package sharkbound.swingdsl.extensions

import sharkbound.swingdsl.enums.JComponentKeyStrokeContext
import sharkbound.swingdsl.wrappers.*
import java.awt.*
import java.awt.event.ActionEvent
import javax.swing.*
import javax.swing.event.ListSelectionEvent
import javax.swing.event.TableModelEvent
import javax.swing.table.DefaultTableModel
import javax.swing.table.TableModel
import javax.swing.text.JTextComponent

inline fun JComponent.registerKeyStroke(
    key: String,
    keyStroke: KeyStroke,
    context: JComponentKeyStrokeContext = JComponentKeyStrokeContext.WHEN_IN_FOCUSED_WINDOW,
    crossinline action: (ActionEvent?) -> Unit
) {
    getInputMap(context.code).put(keyStroke, key)
    actionMap.put(key, object : AbstractAction() {
        override fun actionPerformed(e: ActionEvent?) {
            action(e)
        }
    })
}

/**
 * places a JComponent at a absolute position, layout must be null to work
 */
fun <T : JComponent> T.place(
    x: Int,
    y: Int,
    width: Int = this.preferredSize.width,
    height: Int = this.preferredSize.height,
    preferredSize: Dimension = this.preferredSize
): T = apply {
    bounds = Rectangle(x, y, width, height)
    this.preferredSize = preferredSize
}

/**
 * makes the [JComponent] as small as possible, sets maxsize/prefsize to minsize
 */
fun JComponent.compact() {
    preferredSize = minimumSize
    maximumSize = minimumSize
}

fun JComponent.size(width: Int, height: Int) {
    preferredSize = Dimension(width, height)
}

fun JComponent.size(size: Dimension) {
    preferredSize = Dimension(size)
}

fun JComponent.width(w: Int) {
    size(w, preferredSize.height)
}

fun JComponent.height(h: Int) {
    size(preferredSize.width, h)
}


fun <T : JComponent> T.keyEvent(block: KeyEventWrapper<T>.() -> Unit): KeyEventWrapper<T> =
    KeyEventWrapper(this).apply(block)


fun JComponent.bg(color: Color) {
    background = color
}

fun JComponent.fg(color: Color) {
    foreground = color
}

inline fun <T : AbstractButton> T.action(crossinline action: T.(ActionEvent?) -> Unit) {
    addActionListener {
        action(it)
    }
}

inline fun <T : JTextField> T.action(crossinline action: T.(ActionEvent?) -> Unit) {
    addActionListener {
        action(it)
    }
}

fun JTextField.columns(columns: Int) {
    this.columns = columns
}

fun JTextArea.lineWrap(wrap: Boolean) {
    lineWrap = wrap
}

fun JTextArea.text(text: String) {
    this.text = text
}

fun JTextArea.columns(columns: Int) {
    this.columns = columns
}

fun JTextArea.rows(rows: Int) {
    this.rows = rows
}

fun JTextArea.tabSize(size: Int) {
    tabSize = size
}

fun JComponent.maxSize(w: Int, h: Int) {
    maximumSize = Dimension(w, h)
}

fun JComponent.maxWidth(w: Int) {
    maximumSize = Dimension(w, maximumSize.height)
}

fun JComponent.maxHeight(h: Int) {
    maximumSize = Dimension(maximumSize.width, h)
}

fun JComponent.minSize(w: Int, h: Int) {
    minimumSize = Dimension(w, h)
}

fun JComponent.minWidth(w: Int) {
    minimumSize = Dimension(w, minimumSize.height)
}

fun JComponent.minHeight(h: Int) {
    minimumSize = Dimension(minimumSize.width, h)
}

fun <T> JList<T>.itemSelected(block: JList<T>.(ListSelectionEvent, T) -> Unit) {
    addListSelectionListener {
        if (it != null && !it.valueIsAdjusting) {
            block(it, selectedValue)
        }
    }
}

fun JLabel.text(text: String) {
    this.text = text
}

fun JLabel.hLeftAlign() {
    horizontalAlignment = JLabel.LEFT
}

fun JLabel.hRightAlign() {
    horizontalAlignment = JLabel.RIGHT
}

fun JLabel.hCenterAlign() {
    horizontalAlignment = JLabel.CENTER
}

fun JLabel.vTopAlign() {
    verticalAlignment = JLabel.TOP
}

fun JLabel.vBottomAlign() {
    verticalAlignment = JLabel.BOTTOM
}

fun JLabel.vCenterAlign() {
    verticalAlignment = JLabel.CENTER
}

fun JLabel.center() {
    hCenterAlign()
    vCenterAlign()
}

inline fun <T> JList<T>.model(block: DefaultListModel<T>.() -> Unit): DefaultListModel<T> =
    DefaultListModel<T>().apply {
        block()
        this@model.model = this
    }

fun <T> DefaultListModel<T>.addItem(item: T): T {
    add(this.size(), item)
    return item
}

fun <T> DefaultListModel<T>.addAllItems(vararg items: T): List<T> {
    items.forEach { addItem(it) }
    return items.toList()
}


fun JTextField.text(text: String) {
    this.text = text
}

fun JTextField.leftAlign() {
    horizontalAlignment = JTextField.LEFT
}

fun JTextField.rightAlign() {
    horizontalAlignment = JTextField.RIGHT
}

fun JTextField.centerAlign() {
    horizontalAlignment = JTextField.CENTER
}

fun JTextField.center() {
    centerAlign()
}

fun JTextComponent.font(name: String, style: Int, size: Int): Font =
    Font(name, style, size).apply {
        this@font.font = this
    }

fun JLabel.font(name: String, style: Int, size: Int): Font =
    Font(name, style, size).apply {
        this@font.font = this
    }

inline fun JTabbedPane.tab(
    title: String,
    tip: String = "",
    icon: Icon? = null,
    layout: LayoutManager = FlowLayout(),
    block: JPanel.() -> Unit
): JPanel =
    JPanel(layout).apply {
        block()
        addTab(title, icon, this, tip)
    }

inline fun <T : JComponent> JTabbedPane.tabFrom(
    title: String,
    tip: String = "",
    icon: Icon? = null,
    block: () -> T
): T =
    block().apply {
        block()
        addTab(title, icon, this, tip)
    }


inline fun JSplitPane.left(layout: LayoutManager? = null, block: JPanel.() -> Unit): JPanel =
    JPanel(layout ?: FlowLayout()).apply {
        block()
        leftComponent = this
    }

inline fun JSplitPane.right(layout: LayoutManager? = null, block: JPanel.() -> Unit): JPanel =
    JPanel(layout ?: FlowLayout()).apply {
        block()
        rightComponent = this
    }


inline fun <T> JComboBox<T>.model(block: DefaultComboBoxModel<T>.() -> Unit): DefaultComboBoxModel<T> =
    DefaultComboBoxModel<T>().apply {
        block()
        this@model.model = this
    }

fun <T> DefaultComboBoxModel<T>.addItem(item: T): T {
    addElement(item)
    return item
}

fun <T> DefaultComboBoxModel<T>.addAllItems(vararg items: T): List<T> {
    items.forEach { addElement(it) }
    return items.toList()
}

inline fun <reified T> JComboBox<T>.itemSelected(crossinline block: JComboBox<T>.(ActionEvent, T?) -> Unit) {
    addActionListener {
        block(it, selectedItem as? T)
    }
}

val JComboBox<*>.textLabel: JLabel
    get() = renderer as JLabel

inline fun <T : JComponent> T.componentListener(block: ComponentEventWrapper<T>.() -> Unit): ComponentEventWrapper<T> =
    ComponentEventWrapper(this).apply(block)


inline fun <T : JComponent> T.mouseListener(block: MouseEventWrapper<T>.() -> Unit): MouseEventWrapper<T> =
    MouseEventWrapper(this).apply(block)

inline fun <T : JComponent> T.mouseMotionListener(block: MouseMotionEventWrapper<T>.() -> Unit): MouseMotionEventWrapper<T> =
    MouseMotionEventWrapper(this).apply(block)

inline fun <T : JComponent> T.focusListener(block: FocusEventWrapper<T>.() -> Unit): FocusEventWrapper<T> =
    FocusEventWrapper(this).apply(block)

fun <T : JTextComponent> T.placeHolderText(placeholder: String) {
    focusListener {
        gained {
            if (text == placeholder) {
                text = ""
            }
        }

        lost {
            if (text.isNullOrEmpty()) {
                text = placeholder
            }
        }
    }
    text = placeholder
}

fun <T : JTable> T.model(block: DefaultTableModel.() -> Unit): DefaultTableModel =
    DefaultTableModel().apply {
        block()
        this@model.model = this
    }

fun DefaultTableModel.addColumns(vararg columns: Any): List<Any> {
    columns.forEach { addColumn(it) }
    return columns.toList()
}

fun DefaultTableModel.addRow(vararg values: Any): List<Any> {
    addRow(values)
    return values.toList()
}

inline fun DefaultTableModel.dataChanged(crossinline block: DefaultTableModel.(TableModelEvent) -> Unit) {
    addTableModelListener {
        block(it)
    }
}