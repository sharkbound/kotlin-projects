import javafx.fxml.FXML
import javafx.scene.control.TextField
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent

class Controller {
    fun textFieldKeyPress(e: KeyEvent) {
        if (e.code == KeyCode.ENTER) {
            text!!.text = ""
        }
//        text!!.widthProperty().
    }

    @FXML
    var text: TextField? = null
}
