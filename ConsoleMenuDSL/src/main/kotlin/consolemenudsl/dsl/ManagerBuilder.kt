package consolemenudsl.dsl

import consolemenudsl.annotations.Dsl
import consolemenudsl.data.Manager

@Dsl
class ManagerBuilder {
    val mgr = Manager()

    inline fun scene(block: SceneBuilder.() -> Unit) {
        mgr.addScene(SceneBuilder().also { it.mgr = mgr }.build(block))
    }

    fun build(block: ManagerBuilder.() -> Unit) = apply(block).mgr
}