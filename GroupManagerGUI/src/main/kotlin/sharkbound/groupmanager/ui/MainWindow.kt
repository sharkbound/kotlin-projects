package sharkbound.groupmanager.ui

import sharkbound.groupmanager.constants.*
import java.awt.BorderLayout
import java.awt.CardLayout
import javax.swing.*

class MainWindow : JFrame(MAIN_WINDOW_TITLE) {
    private val card = CardLayout()
    private val root = JPanel(BorderLayout())
    private val content = JPanel(card)
    private val selector = JComboBox<String>(
        arrayOf(
            GROUP_INFO,
            MEMBER_INFO,
            EDIT_GROUP,
            EDIT_MEMBER,
            ADD_GROUP,
            ADD_MEMBER,
            REMOVE_GROUP,
            REMOVE_MEMBER
        )
    )

    init {
        selector.addActionListener {}

        addAllComponents()
        display()
    }

    private fun addHanders() {
    }

    private fun addAllComponents() {

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