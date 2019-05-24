package sharkbound.groupmanager

import com.intellij.uiDesigner.core.GridConstraints
import com.intellij.uiDesigner.core.GridConstraints.*
import java.awt.Dimension

fun gridConstraint(
    x: Int = 0,
    y: Int = 0,
    xSpan: Int = 1,
    ySpan: Int = 1,
    anchor: Int = ALIGN_CENTER,
    fill: Int = FILL_BOTH,
    hSizePolicy: Int = SIZEPOLICY_CAN_GROW,
    vSizePolicy: Int = SIZEPOLICY_CAN_GROW,
    minSize: Dimension? = null,
    prefSize: Dimension? = null,
    maxSize: Dimension? = null
) = GridConstraints(y, x, ySpan, xSpan, anchor, fill, hSizePolicy, vSizePolicy, minSize, prefSize, maxSize)