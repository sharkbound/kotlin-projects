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
    val frame: Frame

    init {
        useSystemLookAndFeel()
        frame = frame {
            root {
                tabPane {
                    tab("group info") {
                        add { GroupInfoMenu() }
                    }
                    tab("add group") {
                        useGridBagLayout()
                        add(gridFillBoth()) { AddGroupMenu() }
                    }
                }
            }
        }
    }

    fun start() {
        frame.display(pack = true)
    }
}
