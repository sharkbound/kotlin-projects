package sharkbound.swingdsl.wrappers

import sharkbound.swingdsl.util.gridFillBoth
import java.awt.CardLayout
import java.awt.Component
import java.awt.GridBagLayout
import java.lang.IllegalArgumentException
import javax.swing.JComponent
import javax.swing.JPanel

class CardLayoutWrapper(hGap: Int = 0, vGap: Int = 0) : JPanel(GridBagLayout()) {
    val card = CardLayout(hGap, vGap)
    val panel = JPanel(card)
    private val map = mutableMapOf<String, Component>()

    init {
        super.add(panel, gridFillBoth())
    }

    override fun add(comp: Component?, constraints: Any?) {
        if (constraints !is String) {
            throw IllegalArgumentException("constraints must be a string that is the panel's card ID, ex: \"users\"")
        }
        panel.add(comp, constraints)
    }

    var current: String? = null
        set(value) {
            card.show(panel, value)
            field = value
        }

    operator fun get(key: String): Component = map.getValue(key)
    operator fun set(key: String, value: Component) {
        map[key] = value
        panel.add(value, key)
    }
}