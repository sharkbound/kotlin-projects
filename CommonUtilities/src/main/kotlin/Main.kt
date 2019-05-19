@file:JvmName("KotlinCommonUtilTestingMain")

import sharkbound.commonutils.Maybe

private fun main() {
    println(Maybe(1) / { it?.toBigDecimal() } + { it.abs() } + { it.toInt() } orDefault -1)
}
