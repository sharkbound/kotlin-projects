import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils.create
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.concurrent.ThreadLocalRandom

object Account : Table() {
    val id = integer("id").autoIncrement().primaryKey()
    val name = varchar("name", 40)
    val bal = float("bal")
}

val alpha = "abcdefghijklmnopqrstuvwxyz".toList()

fun main(args: Array<String>) {
    Database.connect("jdbc:h2:bank", "org.h2.Driver")

    transaction {
        create(Account)

        for (_i in 1..10) {
            val username = choices(20, alpha).joinToString("")

            Account.insert {
                it[name] = username
                it[bal] = 200F
            }
        }

        for (acc in Account.selectAll()) {
            println("${acc[Account.name]} -> ${acc[Account.bal]}")
        }
    }
}

val r = ThreadLocalRandom.current()!!

fun <T> choices(count: Int, items: List<T>): List<T> = (1..count).map { items[r.nextInt(items.size)] }