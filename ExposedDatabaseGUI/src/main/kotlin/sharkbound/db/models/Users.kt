package sharkbound.db.models

import org.jetbrains.exposed.sql.Table

object Users : Table("Users") {
    val id = integer("id").autoIncrement().primaryKey()
    val name = varchar("name", 50)
    val balance = integer("balance")
}