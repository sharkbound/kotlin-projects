import java.util.concurrent.ThreadLocalRandom
import kotlin.random.asKotlinRandom

const val MIN_TIME = 5
const val MAX_TIME = 30
val r = ThreadLocalRandom.current()!!.asKotlinRandom()
val randTime get() = r.nextInt(1, 31)
var tellerID = 0
var customerID = 0

data class Customer(
    val id: Int = ++customerID,
    val time: Int = -1,
    val tellerID: Int = -1,
    val served: Boolean = false
) {
    val hasTeller = tellerID != -1
}

data class State(val customers: List<Customer>, val freeTellers: List<Int>)

fun main() {
    var state = State(
        customers = (1..r.nextInt(3, 30)).map { Customer() },
        freeTellers = (1..10).toList()
    )

    while (state.customers.any { !it.served }) {
        for (customer in state.customers) {
            if (!customer.hasTeller && !customer.served && state.freeTellers.isNotEmpty()) {
                val time = randTime
                println("${state.freeTellers.first()} is now serving ${customer.id} for $time seconds")
                state = state.copy(
                    customers = state.customers.map {
                        if (it.id == customer.id) {
                            customer.copy(
                                tellerID = state.freeTellers.first(),
                                time = time
                            )
                        } else it
                    },
                    freeTellers = state.freeTellers.filter { it != state.freeTellers.first() })
            } else if (customer.hasTeller && customer.time > 0) {
                state = state.copy(
                    customers = state.customers.map {
                        if (it.id == customer.id) customer.copy(time = customer.time - 1) else it
                    })
            } else if (customer.hasTeller && customer.time <= 0 && !customer.served) {
                state = state.copy(
                    customers = state.customers.map {
                        if (it.id == customer.id) customer.copy(tellerID = -1, time = -1, served = true) else it
                    },
                    freeTellers = listOf(*state.freeTellers.toTypedArray(), customer.tellerID)
                )
                println("${customer.tellerID} finished serving ${customer.id}")
            }
        }
    }
}
