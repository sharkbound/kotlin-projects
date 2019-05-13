package sharkbound.ui

import java.awt.GridBagLayout
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import javax.swing.JDialog
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.WindowConstants

@Suppress("LeakingThis")
open class QuestionDialog<R>(open val owner: JFrame) : JDialog(owner) {
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

        add(panel)
    }

    /**
     * triggered when the dialog is closed
     */
    open fun onCancel(e: WindowEvent?) {

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