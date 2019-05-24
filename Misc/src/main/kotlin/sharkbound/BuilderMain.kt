package sharkbound

fun main() {
    println(InfoBuilder {
        name = "timmy"
        age = 99
        email = "1337@l33t.com"
    }.built)
}

class InfoBuilder(init: InfoBuilder.() -> Unit) {
    var name = ""
    var age = -1
    var email = ""

    init {
        init()
    }

    val built get() = Info(name, age, email)
}

data class Info(val name: String, val age: Int, val email: String)
