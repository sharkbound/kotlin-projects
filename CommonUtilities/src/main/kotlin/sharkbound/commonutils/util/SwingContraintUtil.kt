package sharkbound.commonutils.util

import sharkbound.commonutils.enums.GridBagFill
import java.awt.GridBagConstraints
import java.awt.Insets

/**
 * creates a new [GridBagConstraints] isntance with the passed values
 *
 * @return [GridBagConstraints] with the same values as passed to the function
 */
fun newGridBagContraint(
    x: Int = 0,
    y: Int = 0,
    weightX: Double = 1.0,
    weightY: Double = 1.0,
    height: Int = 1,
    width: Int = 1,
    anchor: Int = 0,
    insets: Insets? = null,
    padX: Int = 0,
    padY: Int = 0,
    fill: GridBagFill = GridBagFill.HORIZONTAL
): GridBagConstraints = GridBagConstraints(
    x,
    y,
    width,
    height,
    weightX,
    weightY,
    anchor,
    fill.code,
    insets,
    padX,
    padY
)