package fighter

import java.util.concurrent.ThreadLocalRandom

val r = ThreadLocalRandom.current()!!

fun <T> Array<T>.choice(): T = this[r.nextInt(size)]
fun <T> List<T>.choice(): T = this[r.nextInt(size)]
fun <T> Iterable<T>.choice(): T = elementAt(r.nextInt(count()))