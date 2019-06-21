package sharkbound.libgdx

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import sharkbound.commonutils.util.randInt
import sharkbound.libgdx.extensions.drawAfter
import sharkbound.libgdx.util.mouseDrawPos

class CircleDrawHistory(val x: Float, val y: Float) {
    val radius = randInt(1, 100).toFloat()

    override operator fun equals(other: Any?) =
            other is CircleDrawHistory && x == other.x && y == other.y
}

val history = mutableSetOf<CircleDrawHistory>()

class Runner : ApplicationAdapter() {
    lateinit var shape: ShapeRenderer
    var lastPos = CircleDrawHistory(0f, 0f)

    override fun create() {
        shape = ShapeRenderer()
        shape.setAutoShapeType(true)
    }

    override fun render() {
//        Gdx.gl.glClearColor(1f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        val newCircle = mouseDrawPos.run { CircleDrawHistory(x, y) }
        if (newCircle != lastPos) {
            history += newCircle
            println(newCircle)
        }

        shape drawAfter {
            history.forEach {
                circle(it.x, it.y, it.radius)
            }
        }

        lastPos = newCircle
    }

    override fun dispose() {
        shape.dispose()
    }
}
