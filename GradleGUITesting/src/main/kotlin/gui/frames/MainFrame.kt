package gui.frames

import gui.listeners.KeyBoardQuitListener
import gui.util.centerJFrame
import gui.util.exitOnClose
import java.awt.GridLayout
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JTextField
import javax.swing.border.EmptyBorder

class MainFrame(w: Int = 600, h: Int = 600, title: String = "Hello World!") : JFrame(title) {
    private val clickMe = JButton("click me")
    private val text = JTextField()

    init {
        exitOnClose()
        setSize(w, h)
        layout = GridLayout(10, 10)
        location = centerJFrame(this, w, h)
    }

    private fun setup() {
        addAllComponents()
        configureComponents()
        addAllComponentListeners()
        pack()
    }

    private fun configureComponents() {
        text.border = EmptyBorder(0, 10, 0, 10)
    }

    private fun addAllComponentListeners() {
        text.addKeyListener(object : KeyListener {
            override fun keyTyped(e: KeyEvent?) {
                print(e?.keyChar)
            }

            override fun keyPressed(e: KeyEvent?) {

            }

            override fun keyReleased(e: KeyEvent?) {
            }
        })

        addKeyListener(KeyBoardQuitListener(this))
        text.addActionListener {
            println("text action listener")
        }
    }

    private fun addAllComponents() {
        add(clickMe)
        add(text)
    }

    fun run() {
        setup()
        isVisible = true
    }
}
