package gui.frames

import gui.listeners.KeyBoardQuitListener
import gui.util.centerJFrameWindow
import gui.util.exitOnClose
import gui.util.makeDark
import java.awt.Button
import java.awt.GridLayout
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JOptionPane

class MainFrame(w: Int = 600, h: Int = 600, title: String = "Hello World!") : JFrame(title) {
    private val testButton = JButton("click me").makeDark()

    init {
        exitOnClose()
        setSize(w, h)
        layout = GridLayout(10, 10)
        location = centerJFrameWindow(this, w, h)

    }

    private fun setup() {
        addListeners()
        addComponents()
        bindActions()
    }

    private fun bindActions() {
        testButton.addActionListener {
        }
    }

    private fun addComponents() {
        contentPane.makeDark()
        contentPane.add(testButton)
    }

    private fun addListeners() {
        addKeyListener(KeyBoardQuitListener(this))
    }

    fun run() {
        setup()
        isVisible = true
    }
}