package sharkbound.libgdx.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import sharkbound.libgdx.*
import sharkbound.libgdx.util.HEIGHT
import sharkbound.libgdx.util.WIDTH

fun main(arg: Array<String>) {
    val config = LwjglApplicationConfiguration().apply {
        width = WIDTH
        height = HEIGHT
    }
    LwjglApplication(Runner(), config)
}