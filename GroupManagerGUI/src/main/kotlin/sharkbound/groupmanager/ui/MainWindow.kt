package sharkbound.groupmanager.ui

import sharkbound.groupmanager.constants.Data
import java.awt.BorderLayout
import java.awt.CardLayout
import javax.swing.*

class MainWindow : JFrame(Data.MAIN_WINDOW_TITLE) {
    private val card = CardLayout()
    private val root = JPanel(BorderLayout())
    private val content = JPanel(card)
    private val selector = JComboBox<String>(Data.allPanelNames)

    init {
        addAllComponents()
        addHandlers()
        configure()
        display()
    }

    fun String.showCardPanel() {
        card.show(content, this)
        selector.selectedItem = this
    }

    private fun configure() {
        selector.selectedItem = Data.GROUP_INFO
        Data.ADD_MEMBER.showCardPanel()
    }

    private fun addHandlers() {
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