package consolemenudsl.dsl

import consolemenudsl.data.Manager

inline fun createMenu(block: (ManagerBuilder).() -> Unit): Manager {
    val managerBuilder = ManagerBuilder()
    managerBuilder.apply(block)
    return managerBuilder.mgr
}