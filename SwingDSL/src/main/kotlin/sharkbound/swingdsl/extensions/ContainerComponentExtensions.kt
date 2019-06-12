package sharkbound.swingdsl.extensions

import java.awt.BorderLayout
import java.awt.Container
import java.awt.Dimension
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


inline fun Container.textField(
    initalText: String = "",
    constraint: Any? = null,
    block: JTextField.() -> Unit
): JTextField =
    JTextField(initalText)
        .apply {
            block()
            this@textField.add(this, constraint)
        }

inline fun Container.borderPanel(hGap: Int = 0, vGap: Int = 0, block: JPanel.() -> Unit): JPanel =
    JPanel(BorderLayout(hGap, vGap)).apply {
        block()
        this@borderPanel.add(this)
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

fun Container.hSpacer(w: Int = 0, block: JPanel.() -> Unit = {}): JPanel =
    spacer(w, 0).apply(block)

fun Container.vSpacer(h: Int = 0, block: JPanel.() -> Unit = {}): JPanel =
    spacer(0, h).apply(block)

fun Container.passwordField(
    columns: Int? = null,
    constraint: Any? = null,
    block: JPasswordField.() -> Unit
): JPasswordField =
    JPasswordField().apply {
        block()
        columns?.let {
            this.columns = columns
        }
        this@passwordField.add(this, constraint)
    }

fun Container.textArea(
    rows: Int = 0,
    columns: Int = 0,
    constraint: Any? = null,
    block: JTextArea.() -> Unit
): JTextArea =
    JTextArea(rows, columns).apply {
        block()
        this@textArea.add(this, constraint)
    }

inline fun <reified T : JComponent, C : Container> C.add(constraint: Any? = null, getComponent: C.() -> T): T =
    getComponent().apply {
        this@add.add(this, constraint)
    }

inline fun Container.label(
    text: String? = null,
    constraint: Any? = null,
    block: JLabel.() -> Unit
): JLabel =
    JLabel(text).apply {
        block()
        this@label.add(this, constraint)
    }

inline fun <T> Container.list(constraint: Any? = null, block: JList<T>.() -> Unit): JList<T> =
    JList<T>().apply {
        block()
        this@list.add(this, constraint)
    }

inline fun Container.scrollPane(constraint: Any? = null, block: JScrollPane.() -> JComponent): JScrollPane =
    JScrollPane().apply {
        setViewportView(block())
        this@scrollPane.add(this, constraint)
    }

inline fun <T> Container.comboBox(constraint: Any? = null, block: JComboBox<T>.() -> Unit): JComboBox<T> =
    JComboBox<T>().apply {
        block()
        this@comboBox.add(this, constraint)
    }