package formtest.impl

import formtest.data.Sizes
import formtest.panels.ColorPanel
import formtest.panels.SizedColorPanel
import java.awt.Component
import javax.swing.JComponent
import javax.swing.JLabel
import javax.swing.JList
import javax.swing.ListCellRenderer
import javax.swing.border.EmptyBorder
import javax.swing.plaf.basic.BasicBorders

class ColorListCellRenderer(val i: Int) : ListCellRenderer<Any> {
    override fun getListCellRendererComponent(
        list: JList<out Any>?,
        value: Any?,
        index: Int,
        isSelected: Boolean,
        cellHasFocus: Boolean
    ): Component {
        if (value !is ColorPanel) {
            return value as? JComponent ?: JLabel("invalid item")
        }

        return when {
            i != -1 && i == index -> SizedColorPanel(
                color = value.color,
                w = Sizes.selectedColorBoxWidth,
                h = Sizes.selectedColorBoxHeight
            ).apply { border = BasicBorders.MarginBorder() }
            else -> SizedColorPanel(
                color = value.color,
                w = Sizes.colorBoxWidth,
                h = Sizes.colorBoxHeight
            )
        }
    }
}