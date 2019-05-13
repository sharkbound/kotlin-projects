@file:JvmName("KotlinCommonUtilTestingMain")

import sharkbound.commonutils.util.suppressException
import java.lang.IllegalArgumentException

private fun main() {
    suppressException<IllegalArgumentException> {
        throw Exception()
    }
}
