package sharkbound.swingdsl.extensions

import sharkbound.swingdsl.builders.KeyEventBuilder
import sharkbound.swingdsl.enums.JComponentKeyStrokeContext
import java.awt.Color
import java.awt.Dimension
import java.awt.Font
import java.awt.Rectangle
import java.awt.event.ActionEvent
import javax.swing.*
import javax.swing.event.ListSelectionEvent
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


fun <T : JComponent> T.keyEvent(block: KeyEventBuilder<T>.() -> Unit): KeyEventBuilder<T> =
    KeyEventBuilder(this, block)


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