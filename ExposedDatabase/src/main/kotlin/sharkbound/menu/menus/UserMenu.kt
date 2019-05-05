package sharkbound.menu.menus

import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.experimental.transaction
import sharkbound.commonutils.extensions.ifNotNull
import sharkbound.commonutils.util.ask
import sharkbound.commonutils.util.pause
import sharkbound.db.models.User
import sharkbound.menu.createMenu


val userMenu = createMenu {
    description = "user management"

    addOption("add", "adds a new user") {
        val username = ask("username: ")
        if (username.isBlank()) {
            println("username cannot be blank")
            return@addOption
        }

        transaction {
            if (User.select { User.name eq username.trim() }.limit(1).count() != 0) {
                println("that user already exists, modify them instead")
                pause()
                return@transaction
            }

            User.insert {
                it[name] = username
            }

            println("added new user \"$username\"")
            pause()
        }
    }

    addOption("list", "list all users") {
        transaction {
            User.selectAll().forEach {
                println("${it[User.name]} > balance: ${it[User.balance]} state: ${it[User.state] ?: "MISSING"}")
            }
            pause()
        }
    }
}