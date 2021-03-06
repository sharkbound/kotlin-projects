package gui.util

import com.google.gson.GsonBuilder
import java.awt.Color
import java.util.concurrent.ThreadLocalRandom

val gson = GsonBuilder().setPrettyPrinting().create()
val r = ThreadLocalRandom.current()!!

fun randomColor() = Color(r.nextInt(256), r.nextInt(256), r.nextInt(256))