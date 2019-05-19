import sharkbound.commonutils.enums.JFrameCloseOperation
import sharkbound.commonutils.extensions.sendCloseEvent
import sharkbound.commonutils.extensions.showFrame
import sharkbound.commonutils.util.createGridBagContraint
import java.awt.*
import java.awt.event.KeyEvent
import javax.swing.*
import javax.swing.border.EmptyBorder

class MainWindow : JFrame("Main Window - SwingCustomTitleBar") {
    val pane = JPanel(GridBagLayout())
    val titleBar = JPanel(FlowLayout(FlowLayout.RIGHT)).apply {
        border = EmptyBorder(0, 0, 0, 0)
        background = Color.black
    }
    val exit = JButton("EXIT").apply {
        //        addActionListener { sendCloseEvent() }
        background = Color.gray
        foreground = Color.white
    }

    init {
        isUndecorated = true
//        setDefaultLookAndFeelDecorated(true)
        layout = BorderLayout()
        add(titleBar, BorderLayout.NORTH)

        addEvents()
        addComponents()
        add(pane, BorderLayout.CENTER)

        pane.registerKeyboardAction(
            { sendCloseEvent() },
            KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
            JComponent.WHEN_IN_FOCUSED_WINDOW
        )
    }

    private fun addEvents() {
        WindowDragListener(this)
    }

    private fun addComponents() {
        titleBar.apply {
            add(JButton("QUIT").apply {
                addActionListener {
                    sendCloseEvent()
                }
            }, createGridBagContraint(0, 0, width = Int.MAX_VALUE))
        }
    }

    fun display() {
        showFrame(JFrameCloseOperation.EXIT_ON_CLOSE, size = Dimension(600, 600), center = true)
    }
}