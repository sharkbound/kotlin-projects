import com.google.gson.JsonParser

fun main(args: Array<String>) {
    val str = """{"name": "matt", "age": 20, "weight": 150, "birthday":"01/01/1998","fav_food": "pizza", "fav_sport": "baseball", "fav_car" : "dodge viper", "likes_apples" : true}"""
    val data = JsonParser().parse(str).asJsonObject
    println(data["name"])
}