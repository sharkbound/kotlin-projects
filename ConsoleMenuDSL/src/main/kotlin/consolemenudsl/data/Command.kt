package consolemenudsl.data

import java.lang.Exception

class Command(val name: String, val description: String = "no description", val onExecute: (Args) -> Unit) {
    fun execute(args: Args) {
        try {
            onExecute(args)
        } catch (e: Exception) {
            println("Error occurred executing command $name, type: ${e.javaClass.name}, stack:")
            e.printStackTrace()
        }
    }
}