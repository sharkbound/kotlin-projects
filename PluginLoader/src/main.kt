import java.io.File
import java.net.URLClassLoader
import java.util.jar.JarFile
import kotlin.coroutines.experimental.buildSequence

fun String.toImport() = replace("/", "").replace('/', '.')


fun loadCommands(directory: String): Sequence<Command> {
    return buildSequence {
        for (file in File(directory).listFiles().filter { it.extension.toLowerCase() == "jar" }) {
            val loader = URLClassLoader(arrayOf(file.toURI().toURL()), Command::class.java.classLoader)
            val jfile = JarFile(file.path)

            for (item in jfile.stream().filter { it.name.toLowerCase().endsWith(".class") }) {
                val clazz = Class.forName(item.name.toImport(), false, loader)

                if (Command::class.java.isAssignableFrom(clazz) && clazz.constructors.all { it.parameterCount == 0 } && !clazz.isInterface) {
                    yield(clazz.newInstance() as Command)
                }
            }
        }
    }
}

fun main(args: Array<String>) {
//    val path = """C:\Users\owner\Desktop\misc_code\java\PluginLoader\CommandJars\Commands.jar"""
//    val loader = URLClassLoader(arrayOf(File(path).toURI().toURL()), Command::class.java.classLoader)
//    val clazz = Class.forName("EchoCommand", false, loader)
//
//
//    println(Command::class.java.isAssignableFrom(clazz))
//    println((clazz.newInstance() as Command).name)
    println("loading commands...")
    loadCommands("""C:\Users\owner\Desktop\misc_code\java\PluginLoader\CommandJars""").forEach { println("COMMAND: ${it.name}") }
    println("done!")
}