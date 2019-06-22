package sharkbound.libgdx.util

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20

data class MousePosF(val x: Float, val y: Float)

val mousePos get() = MousePosF(Gdx.input.x.toFloat(), Gdx.input.y.toFloat())
val mouseDrawPos get() = MousePosF(Gdx.input.x.toFloat(), -Gdx.input.y.toFloat() + HEIGHT)

val mouseX get() = Gdx.input.x.toFloat()
val mouseY get() = Gdx.input.y.toFloat()

fun clearColor() {
    Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT)
}

fun clearWithColor(r: Float, g: Float, b: Float, a: Float = 1f) {
    Gdx.gl20.glClearColor(r, g, b, a)
}