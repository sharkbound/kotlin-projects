package sharkbound.ui

import sharkbound.commonutils.extensions.sendCloseEvent
import java.awt.GridBagLayout
import java.awt.event.KeyEvent
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import javax.swing.*

@Suppress("LeakingThis")
open class QuestionDialog<R>(open val owner: JFrame, val cancelOnEscape: Boolean = true) : JDialog(owner) {
    protected val panel = JPanel(GridBagLayout())

    init {
        contentPane = panel
        panel.dark
//        make it block interaction with the underlying application while open
        modalityType = ModalityType.APPLICATION_MODAL
        defaultCloseOperation = WindowConstants.DO_NOTHING_ON_CLOSE

        addWindowListener(object : WindowAdapter() {
            override fun windowClosing(e: WindowEvent?) {
                onCancel(e)
            }
        })

        if (cancelOnEscape) {
            panel.registerKeyboardAction(
                {
                    onCancel(null)
                    dispose()
                },
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT
            )
        }

        add(panel)
    }

    /**
     * triggered when the dialog is closed
     */
    open fun onCancel(e: WindowEvent?) {
        sendCloseEvent()
    }

    /**
     * shows the dialog and waits for a value to be returned
     *
     * @return [R], the value that was selected
     */
    open fun getResult(): R {
        isVisible = true
    }
}