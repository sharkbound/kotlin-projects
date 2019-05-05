package sharkbound

import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import sharkbound.db.ConnectionStrings
import sharkbound.db.models.Users

fun connectToDatabase() {
    Database.connect(ConnectionStrings.connectionString, ConnectionStrings.connectionDriver)
    runBlocking {
        transaction {
            SchemaUtils.create(Users)
        }
    }
}