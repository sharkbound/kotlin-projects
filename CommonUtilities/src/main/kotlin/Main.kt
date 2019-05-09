@file:JvmName("KotlinCommonUtilTestingMain")

import sharkbound.commonutils.Maybe

private fun main() {
    val m = Maybe(1).map { it * 2 }.map { it * 2 }.valueOrNull
    println(m)
}




