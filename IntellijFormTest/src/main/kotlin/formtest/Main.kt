@file:JvmName("Main")

package formtest

import formtest.data.Global
import formtest.data.addQuitAction
import formtest.impl.ColorListCellRenderer
import formtest.panels.ColorPanel
import java.awt.Color
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent
import javax.swing.*
import javax.swing.event.DocumentEvent
import javax.swing.event.DocumentListener
import javax.swing.text.SimpleAttributeSet
import javax.swing.text.StyleConstants

fun main() {
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())

    val frame = JFrame("KotlinFormTest")
    val form = MainForm()

    form.setup()
    form.addCustomListeners()
    frame.contentPane = form.panel
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.setLocationRelativeTo(null)
    frame.pack()

    addQuitAction(frame, form.panel)


    frame.isVisible = true
}

fun MainForm.setup() {
    colorList.model = colors
    colors.addElement(ColorPanel(Color.red))
    colors.addElement(ColorPanel(Color.blue))
    colorList.cellRenderer = ColorListCellRenderer(0)
}


fun MainForm.addCustomListeners() {
    colorList.addListSelectionListener {
        if (it.valueIsAdjusting) {
//            the value is still changing
            colorList.cellRenderer = ColorListCellRenderer(colorList.selectedIndex)
        } else {
//            the value is set and no longer changing
            colorList.selectedValue?.let { v ->
                if (v is ColorPanel) {
                    Global.color = v.color
                }
            }
        }
    }

    addColorButton.addActionListener {
        colors.addElement(
            ColorPanel(JColorChooser.showDialog(null, "Choose a color", Color.black))
        )
    }

    removeColorButton.addActionListener {
        if (colorList.selectedIndex != -1)
            colors.remove(colorList.selectedIndex)
    }


    input.addKeyListener(object : KeyAdapter() {
        override fun keyPressed(e: KeyEvent?) {
            if (e?.keyCode == KeyEvent.VK_ENTER) {
                text.styledDocument.insertString(
                    text.document.length,
                    input.text + "\n",
                    SimpleAttributeSet().apply {
                        StyleConstants.setForeground(this, Global.color)
                        StyleConstants.setFontSize(this, 17)
                    }
                )
                input.text = ""
            }
        }
    })
}