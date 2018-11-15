import java.time.LocalDate
import java.util.*

fun main() {
    val now = LocalDate.now()
    val localDate = LocalDate.of(now.year, now.month, now.dayOfMonth + 1)
    println(localDate.)

    val cal = Calendar.getInstance()
    cal.add(Calendar.DAY_OF_MONTH, 1)
}