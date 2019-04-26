import java.awt.Color
import java.awt.Component
import java.awt.Dimension
import javax.swing.*


class ResizableListCellTest : JFrame() {
    private val list: JList<*>

    init {
        //setup the panels model
        val model = DefaultListModel<Any>()

        //create the list
        list = JList(model)
        //        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //set the cell renderer with a -1 selection
        list.cellRenderer = ResizableListCellRenderer(-1)

        //add the listener that will adjust the height of the selected cell.
        list.addListSelectionListener { e ->
            if (e.valueIsAdjusting) {
                list.cellRenderer = ResizableListCellRenderer(list.selectedIndex)
            }
        }


        //add panels to the model
        model.addElement("Test Item 1")
        model.addElement("Test Item 2")
        model.addElement("Test Item 3")
        model.addElement("Test Item 4")
        model.addElement("Test Item 5")

        //init the frame
        add(list)
        setSize(200, 500)
        setLocationRelativeTo(null)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        isVisible = true
    }

    inner class ResizableListCellRenderer(index: Int) : ListCellRenderer<Any> {
        private var selectedIndex = index

        init {
            println("new")
        }

        override fun getListCellRendererComponent(
            list: JList<out Any>?,
            value: Any?,
            index: Int,
            isSelected: Boolean,
            cellHasFocus: Boolean
        ): Component {
            val p = JPanel()
            p.add(JLabel(value.toString()))
            p.add(JCheckBox())
            p.isOpaque = true
            if (isSelected)
                p.background = Color.white
            else
                p.background = Color.gray
            if (selectedIndex > -1 && index == selectedIndex) {
                println("$index $selectedIndex $isSelected ")
                p.preferredSize = Dimension(100, 105)
            } else
                p.preferredSize = Dimension(100, 20)
            return p
        }


    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            ResizableListCellTest()
        }
    }
}