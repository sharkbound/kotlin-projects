package sharkbound.menu.menus

import sharkbound.menu.Manager
import sharkbound.menu.createMenu

val mainMenu = createMenu {
    description = "mainmenu"

    addOption("users", "manages user accounts") {
        Manager.current = userMenu
    }
}
