package sharkbound.groupmanager.ui

import sharkbound.commonutils.extensions.sendCloseEvent
import sharkbound.groupmanager.constants.Data
import sharkbound.groupmanager.constants.Screen
import java.awt.BorderLayout
import java.awt.CardLayout
import java.awt.event.KeyEvent
import javax.swing.*

class MainWindow : JFrame(Data.MAIN_WINDOW_TITLE) {
    private val card = CardLayout()
    private val root = JPanel(BorderLayout())
    private val content = JPanel(card)
    private val selector = JComboBox<String>(Data.allPanelNames.toTypedArray())

    var screen: Screen = Screen.GROUP_INFO
        set(value) {
            card.show(content, value.key)
            selector.selectedItem = value.key
            field = value
        }

    init {
        isResizable = false
        addAllComponents()
        addHandlers()
        configure()
        display()
    }

    private fun configure() {
        screen = Screen.GROUP_INFO
    }

    private fun addHandlers() {
        root.registerKeyboardAction(
            { sendCloseEvent() },
            KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK),
            JComponent.WHEN_IN_FOCUSED_WINDOW
        )

        selector.addActionListener {
            try {
                screen = Screen.valueOf((selector.selectedItem as String).replace(' ', '_').toUpperCase())
            } catch (e: IllegalArgumentException) {
                println("bad card screen key: ${selector.selectedItem}")
            }
        }
    }

    private fun addAllComponents() {
        content.add(Screen.GROUP_INFO.key, GroupInfoScreen(this))
        content.add(Screen.MEMBER_INFO.key, MemberInfoScreen(this))

        root.add(content, BorderLayout.CENTER)
        root.add(selector, BorderLayout.NORTH)
        add(root)
    }

    private fun display() {
        setSize(600, 600)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        setLocationRelativeTo(null)
        isVisible = true
    }
}