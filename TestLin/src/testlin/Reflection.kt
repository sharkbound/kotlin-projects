package testlin

import java.io.File
import java.net.URI

fun loadCommands(pkg: String) {
    val resources = Thread.currentThread().contextClassLoader.getResources("testlin")

    for (uri in iterAllClassFiles(resources.nextElement().path)) {
        val importPath = uri.path.substring(uri.path.indexOf(pkg)).asImportPath

        try {
            val cls = Class.forName(importPath)

            if (!cls.isInterface && cls.methods.isNotEmpty()) {
                for (method in cls.methods.filter { it.annotations.isNotEmpty() }) {
                    val cmdData = method.getAnnotation(Command::class.java) ?: continue
                    val instance = runCatching { cls.newInstance() }.getOrNull()

                    val command = RunnableCommand(cmdData) { args ->
                        method.invoke(instance, args) as ExecutionResult
                    }

                    commands[command.fullName] = command
                }
            }

        } catch (e: ClassNotFoundException) {
//            println("skipping class $importPath(${e.javaClass})")
        }
    }
}

fun iterAllClassFiles(path: String): Sequence<URI> = sequence {
    val current = File(path)
    yield(current.toURI())

    for (file in current.listFiles()) {
        when {
            file.isDirectory -> yieldAll(iterAllClassFiles(file.path + '/'))
            file.isClassFile -> yield(file.toURI())
        }
    }
}

val String.asImportPath: String
    get() = this.replace(".class", "").replace('/', '.').trim('.')

val File.isClassFile: Boolean
    get() = isFile && path.endsWith(".class")