package sharkbound.db

import org.jetbrains.exposed.sql.Table


object User : Table("Users") {
    val id = integer("id").primaryKey().autoIncrement()
    val name = varchar("name", 50)
    val balance = integer("balance").default(100)
    val state = varchar("state", 100).nullable()
}