import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import sharkbound.db.User
import sharkbound.db.Vars
import sharkbound.db.connect
import sharkbound.db.printAllUsers


fun main() {
    connect()

    transaction {
        if (User.select { User.name.eq(Vars.name) }.firstOrNull() == null) {
            User.insert {
                it[name] = Vars.name
                it[state] = "neverland"
            }
        }
    }

    printAllUsers()
}