import sharkbound.commonutils.enums.JFrameCloseOperation
import sharkbound.commonutils.extensions.sendCloseEvent
import sharkbound.commonutils.extensions.showFrame
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

    val exitButton = JButton("EXIT").apply {
        addActionListener { sendCloseEvent() }
        makeDark()
    }

    val minimizeButton = JButton("minimize").apply {
        addActionListener { state = Frame.ICONIFIED }
        makeDark()
    }

    val maximizeButton = JButton("maximize").apply {
        addActionListener { extendedState = extendedState or Frame.MAXIMIZED_BOTH }
        makeDark()
    }

    init {
//       remove the default OS title bar
        isUndecorated = true
        isResizable = true
        layout = BorderLayout()


        addEvents()
        addComponents()

//        bind escape to close the window
        pane.registerKeyboardAction(
            { sendCloseEvent() },
            KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
            JComponent.WHEN_IN_FOCUSED_WINDOW
        )
    }

    private fun addEvents() {
        TitleBarListener(this)
    }

    private fun addComponents() {
        titleBar.apply {
            add(minimizeButton)
            add(maximizeButton)
            add(exitButton)
        }

        add(titleBar, BorderLayout.NORTH)
        add(pane, BorderLayout.CENTER)
    }

    fun display() {
        showFrame(JFrameCloseOperation.EXIT_ON_CLOSE, size = Dimension(600, 600), center = true)
    }
}

fun JButton.makeDark() {
    background = Color.getColor("#2b2b2b")
    foreground = Color.white
}