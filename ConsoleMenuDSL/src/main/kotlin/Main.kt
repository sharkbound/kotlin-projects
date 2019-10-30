import consolemenudsl.dsl.createMenu
import sharkbound.commonutils.util.pause

fun main() {
    createMenu {
        scene {
            id = "main"
            command {
                name = "test"
                execute {
                    println("test executed")
                }
            }
            command {
                name = "echo"
                execute {
                    println("called with: ${it.args.joinToString(" ")}")
                    pause()
                }
            }
            command {
                name = "goto"
                execute {
                    it.mgr.gotoScene("other")
                }
            }
        }

        scene {
            id = "other"
            command {
                name = "other"
                execute {
                    println("this is other")
                }
            }
            command {
                name = "goback"
                execute {
                    it.mgr.gotoPrevious()
                }
            }
        }
    }.run("main")
}