package sharkbound.swing.gridgame

import sharkbound.commonutils.rand
import sharkbound.swingdsl.extensions.withColor
import java.awt.*

class GameBoard(val rows: Int, val cellsPerRow: Int, val gridColor: Color, var debugMode: Boolean = true) : Canvas() {
    private var initialized = false
    val cells = mutableListOf<Cell>()
    val cellWidth get() = width / cellsPerRow
    val cellHeight get() = height / rows


    data class Cell(val ratioX: Double, val ratioY: Double) {
        var x: Int = 0
        var y: Int = 0

        fun recalculateXY(board: GameBoard): Cell = apply {
            x = (board.width * ratioX / board.cellWidth).toInt()
            y = (board.height * ratioY / board.cellHeight).toInt()
        }
    }

    fun xyToCell(x: Int, y: Int) =
        Cell(x.toDouble() / width, y.toDouble() / height).recalculateXY(this@GameBoard)

    override fun paint(graphicsIn: Graphics?) {
        initializeCellsDebug()

        background = Color.black
        (graphicsIn as? Graphics2D)?.run {
            drawCell(Cell(.5, .5).recalculateXY(this@GameBoard), Color.red, this)
            drawGrid(this)
            cells.forEach { cell ->
                cell.recalculateXY(this@GameBoard)
                drawCell(cell, Color.red, this)
            }
        }
    }

    private fun initializeCellsDebug() {
        if (!initialized) {
            repeat(10) {
                cells.add(Cell(rand.nextDouble(), rand.nextDouble()))
            }
            initialized = true
            println(cells)
        }
    }

    private fun drawCell(cell: Cell, color: Color, graphics: Graphics2D) {
        graphics.color = color
        graphics.stroke = BasicStroke(.01f)
        graphics.fillRect(cell.x * cellWidth, cell.y * cellHeight, cellWidth, cellHeight)
    }

    private fun drawGrid(graphics: Graphics2D) {
        if (!debugMode) return

        val prevStroke = graphics.stroke
        graphics.withColor(gridColor) {
            graphics.stroke = BasicStroke(1f)
            for (x in 0..width step cellWidth) {
                for (y in 0..height step cellHeight) {
                    graphics.drawRect(x, y, cellWidth, cellHeight)
                }
            }
        }
        graphics.stroke = prevStroke
    }
}