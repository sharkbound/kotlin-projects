package sharkbound.libgdx.extensions

import com.badlogic.gdx.graphics.glutils.ShapeRenderer

inline infix fun ShapeRenderer.drawAfter(block: ShapeRenderer.() -> Unit) {
    begin()
    block()
    end()
}
