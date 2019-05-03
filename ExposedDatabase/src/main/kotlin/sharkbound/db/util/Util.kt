package sharkbound.db.util

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import sharkbound.constants.Vars
import sharkbound.db.models.User

fun connect() {
    Database.connect(Vars.connectionString, Vars.connectionDriver)
    createTables()
}

fun createTables() {
    transaction {
        SchemaUtils.create(User)
    }
}

fun printAllUsers() {
    transaction {
        User.selectAll().forEach {
            println("${it[User.name]} lives in ${it[User.state]} and has $${it[User.balance]}")
        }
    }
}