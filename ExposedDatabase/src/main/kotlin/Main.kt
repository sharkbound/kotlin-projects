import sharkbound.db.util.connect
import sharkbound.menu.Manager
import sharkbound.menu.menus.mainMenu


suspend fun main() {
    connect()
    Manager.run(mainMenu)
}