@file:JvmName("KotlinCommonUtilTestingMain")

import sharkbound.commonutils.toMaybe
import sharkbound.commonutils.util.randBoolean

private fun main() {
    val n = if (randBoolean()) null else "17"
    val maybe = n.toMaybe.tryOrDefault({ it.toInt() }, { -1 })
    println(maybe)
}

