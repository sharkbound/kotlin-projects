package sharkbound.libgdx.util

import com.badlogic.gdx.Gdx
import sharkbound.libgdx.HEIGHT

data class MousePos(val x: Float, val y: Float)

val mousePos get() = MousePos(Gdx.input.x.toFloat(), Gdx.input.y.toFloat())
val mouseDrawPos get() = MousePos(Gdx.input.x.toFloat(), -Gdx.input.y.toFloat() + HEIGHT)