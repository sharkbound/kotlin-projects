package sharkbound.swingdsl.util

import sharkbound.swingdsl.enums.GridBagFill
import java.awt.GridBagConstraints
import java.awt.Insets

/**
 * creates a new [GridBagConstraints] instance with the passed values
 *
 * @return [GridBagConstraints] with the same values as passed to the function
 */
fun gridBagContraint(
    x: Int = 0,
    y: Int = 0,
    weightX: Double = 1.0,
    weightY: Double = 1.0,
    height: Int = 1,
    width: Int = 1,
    anchor: Int = GridBagConstraints.CENTER,
    insets: Insets = Insets(0, 0, 0, 0),
    padX: Int = 0,
    padY: Int = 0,
    fill: GridBagFill = GridBagFill.NONE
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

/**
 * creates a new [GridBagConstraints] instance that fills the whole pane, with the passed values
 *
 * @return [GridBagConstraints] with the same values as passed to the function
 */
fun gridFillBoth(
    x: Int = 0,
    y: Int = 0,
    weightX: Double = 1.0,
    weightY: Double = 1.0,
    height: Int = 1,
    width: Int = 1,
    anchor: Int = GridBagConstraints.CENTER,
    insets: Insets = Insets(0, 0, 0, 0),
    padX: Int = 0,
    padY: Int = 0
): GridBagConstraints = GridBagConstraints(
    x,
    y,
    width,
    height,
    weightX,
    weightY,
    anchor,
    GridBagFill.BOTH.code,
    insets,
    padX,
    padY
)

/**
 * creates a new [GridBagConstraints] instance that fills the pane horizontally, with the passed values
 *
 * @return [GridBagConstraints] with the same values as passed to the function
 */
fun gridFillHorizontal(
    x: Int = 0,
    y: Int = 0,
    weightX: Double = 1.0,
    weightY: Double = 1.0,
    height: Int = 1,
    width: Int = 1,
    anchor: Int = GridBagConstraints.CENTER,
    insets: Insets = Insets(0, 0, 0, 0),
    padX: Int = 0,
    padY: Int = 0
): GridBagConstraints = GridBagConstraints(
    x,
    y,
    width,
    height,
    weightX,
    weightY,
    anchor,
    GridBagFill.HORIZONTAL.code,
    insets,
    padX,
    padY
)

/**
 * creates a new [GridBagConstraints] instance that fills the pane vertically, with the passed values
 *
 * @return [GridBagConstraints] with the same values as passed to the function
 */
fun gridFillVertical(
    x: Int = 0,
    y: Int = 0,
    weightX: Double = 1.0,
    weightY: Double = 1.0,
    height: Int = 1,
    width: Int = 1,
    anchor: Int = GridBagConstraints.CENTER,
    insets: Insets = Insets(0, 0, 0, 0),
    padX: Int = 0,
    padY: Int = 0
): GridBagConstraints = GridBagConstraints(
    x,
    y,
    width,
    height,
    weightX,
    weightY,
    anchor,
    GridBagFill.VERTICAL.code,
    insets,
    padX,
    padY
)
