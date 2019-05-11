@file:JvmName("KotlinCommonUtilTestingMain")

import sharkbound.commonutils.extensions.toMaybe
import sharkbound.commonutils.util.randBoolean

private fun main() {
    val s = (if (randBoolean()) null else "").toMaybe
    println(s.mapOrDefault({ -1 }, { it?.length?.plus(1)?.plus(2) }).value)
}
