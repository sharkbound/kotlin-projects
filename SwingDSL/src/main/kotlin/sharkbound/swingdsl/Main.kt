package sharkbound.swingdsl

import sharkbound.swingdsl.dsl.frame
import sharkbound.swingdsl.enums.BoldWeight
import sharkbound.swingdsl.extensions.*
import sharkbound.swingdsl.util.*
import sharkbound.swingdsl.wrappers.CardLayoutWrapper
import java.awt.PopupMenu
import javax.swing.*
import javax.swing.tree.DefaultMutableTreeNode

private lateinit var card: CardLayoutWrapper
private lateinit var entry: JTextField

fun main() {
    useSystemLookAndFeel()
    frame {
        root {
            vBoxLayout {
                label("options") {
                    font = buildFont {
                        bold = BoldWeight.BOLD
                    }
                }
                centerFlowLayout {
                    toggleButton("add", groupID = 1, selected = true) { action { card.current = "add" } }
                    toggleButton("remove", groupID = 1) { action { card.current = "remove" } }
                }
                card = cardPane {
                    centerFlowLayout(constraint = "add") {
                        entry = textField {
                            columns(40)
                            placeHolderText("enter item name")
                        }
                        button("add item") {
                            action {

                            }
                        }
                    }
                    panel(constraint = "remove") {

                    }
                }
            }
        }

        display(size = 600 to 600)
    }
}
