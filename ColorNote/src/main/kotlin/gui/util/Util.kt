package gui.util

import java.awt.Color
import java.util.concurrent.ThreadLocalRandom

val r = ThreadLocalRandom.current()!!

fun randomColor() = Color(r.nextInt(256), r.nextInt(256), r.nextInt(256))