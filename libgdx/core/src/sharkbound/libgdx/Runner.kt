package sharkbound.libgdx

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.graphics.*
import com.badlogic.gdx.graphics.g2d.*
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.EarClippingTriangulator
import sharkbound.libgdx.util.clearColor


class Runner : ApplicationAdapter() {
    lateinit var shape: ShapeRenderer
    lateinit var polyBatch: PolygonSpriteBatch
    lateinit var polySpr: PolygonSprite
    lateinit var sprBatch: SpriteBatch

    override fun create() {
        shape = ShapeRenderer()
        shape.setAutoShapeType(true)
        polyBatch = PolygonSpriteBatch()
        sprBatch = SpriteBatch()
        polySpr = PolygonSprite(
                PolygonRegion(
                        TextureRegion(
                                Texture(
                                        Pixmap(1, 1, Pixmap.Format.RGBA8888).apply { setColor(Color.BLUE); fill() })),
                        floatArrayOf(100f, 100f, 200f, 200f, 300f, 100f),
                        EarClippingTriangulator().computeTriangles(floatArrayOf(100f, 100f, 200f, 200f, 300f, 100f)).toArray()
                )
        )
    }

    override fun render() {
        clearColor()

        polyBatch.apply {
            begin()
            polySpr.draw(polyBatch)
            end()
        }
    }

    override fun dispose() {
        shape.dispose()
    }
}
