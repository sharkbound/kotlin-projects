import java.io.File

fun registerCommands(pkg: String, root: String) {
    for (file in iterClassFiles(File(root))) {
        try {
            val cls = Class.forName(file.path.substring(file.path.indexOf(pkg)).toImportPath)

            if (!Command::class.java.isAssignableFrom(cls) || cls == Command::class.java)
                continue

            val cmd = cls.newInstance() as Command
            commands[cmd.fullname] = cmd

        } catch (e: ClassNotFoundException) {

        }
    }
}

fun iterClassFiles(path: File): Sequence<File> = sequence {
    for (file in path.listFiles()) {
        when {
            file.isDirectory -> yieldAll(iterClassFiles(file))
            file.path.endsWith(".class") -> yield(file)
        }
    }
}

val String.toImportPath
    get() = replace('\\', '.')
        .replace('/', '.')
        .replace(".class", "")
        .trim('.')