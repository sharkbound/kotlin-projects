import javafx.application.Application
import javafx.event.EventHandler
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.input.KeyCode
import javafx.stage.Stage

class App : Application() {
    override fun start(primaryStage: Stage) {
        val root = FXMLLoader.load<Parent>(javaClass.getResource("sample.fxml"))
        primaryStage.title = "Text Adventure"
        primaryStage.scene = Scene(root, 300.0, 300.0)
        primaryStage.scene.onKeyPressed = EventHandler {
            if (it.code == KeyCode.ESCAPE) {
                primaryStage.close()
            }
        }

        primaryStage.show()

//        val textField = TextField()
//        val container = HBox(textField)
//        container.alignment = Pos.BOTTOM_CENTER
//        container.padding = Insets(10.0)
//        HBox.setHgrow(textField, Priority.ALWAYS)
//        val pane = BorderPane()
//        pane.center = container
//        val scene = Scene(pane, 150.0, 150.0)
//        primaryStage.scene = scene
//        primaryStage.show()
    }
}

fun main(args: Array<String>) {
    Application.launch(App::class.java)
}
