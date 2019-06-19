package sharkbound.groupmanagerdsl

import kotlinx.serialization.UnstableDefault
import sharkbound.groupmanagerdsl.menus.AddGroupMenu
import sharkbound.groupmanagerdsl.menus.GroupInfoMenu
import sharkbound.swingdsl.dsl.Frame
import sharkbound.swingdsl.dsl.frame
import sharkbound.swingdsl.extensions.*
import sharkbound.swingdsl.util.gridFillBoth
import sharkbound.swingdsl.util.useSystemLookAndFeel
import sharkbound.swingdsl.wrappers.CardLayoutWrapper
import javax.swing.JComboBox
import javax.swing.JLabel

@UnstableDefault
class MenuLauncher {

    lateinit var card: CardLayoutWrapper
    lateinit var currentMenu: JComboBox<String>
    val frame: Frame

    init {
        useSystemLookAndFeel()
        frame = frame {
            root {
                north {
                    useGridBagLayout()
                    currentMenu = comboBox(constraint = gridFillBoth()) {
                        (renderer as JLabel).hCenterAlign()
                        model {
                            addAll(Menus.all)
                        }
                        itemSelected { _, v ->
                            card.current = v
                        }
                    }
                }
                center {
                    card = cardPane {
                        add(Menus.groupInfo) { GroupInfoMenu() }
                        add(Menus.addGroup) { AddGroupMenu() }
                    }
                }
            }
        }

        currentMenu.selectedItem = Menus.groupInfo
        card.current = Menus.groupInfo
    }

    fun start() {
        frame.display(pack = true)
    }
}
