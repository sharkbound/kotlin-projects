import com.almasb.fxgl.app.GameApplication
import com.almasb.fxgl.app.GameApplication.launch
import com.almasb.fxgl.app.GameSettings

class BasicGameApp : GameApplication() {
    override fun initSettings(settings: GameSettings) {
        settings.width = 800
        settings.height = 600
        settings.title = "Basic Game App"
    }
}

fun main() {
    launch(BasicGameApp::class.java, emptyArray())
}