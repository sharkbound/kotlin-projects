package sharkbound.commonutils.enums

import java.awt.GridBagConstraints

enum class GridBagFill(val code: Int) {
    HORIZONTAL(GridBagConstraints.HORIZONTAL),
    VERTICAL(GridBagConstraints.VERTICAL),
    BOTH(GridBagConstraints.BOTH),
    NONE(GridBagConstraints.NONE)
}