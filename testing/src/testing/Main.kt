package testing

import testing.chain.ChainMap

fun main() {
    val map = ChainMap(
        listOf(
            mapOf(
                "times" to 1,
                "age" to 17
            ),
            mapOf(
                "name" to 1912931028,
                "love" to -1
            )
        )
    )

    println(map["love1"])
}
