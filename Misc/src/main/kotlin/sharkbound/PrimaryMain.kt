package sharkbound

import org.json.JSONObject

fun main() {
    val obj = JSONObject(
        """
        {
          "name": {
              "last": "james",
              "first":"john"
          }
        }
    """.trimIndent()
    )

    println(obj.path<String>("name", "first"))

}

