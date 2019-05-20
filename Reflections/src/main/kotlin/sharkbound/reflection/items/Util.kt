package sharkbound.reflection.items

import org.reflections.Reflections
import org.reflections.scanners.SubTypesScanner
import kotlin.reflect.full.createInstance


inline fun <reified T : Any> findSubClasses(prefix: String = ""): List<T> =
    Reflections(prefix, SubTypesScanner(false))
        .getSubTypesOf(T::class.java)
        .asSequence()
        .filterNot { it.isInterface || it.isSynthetic }
        .map { it.kotlin }
        .filterNot { it.isInner || it.isAbstract }
        .map { it.createInstance() as T }
        .toList()


// example from https://www.twitch.tv/everx80
//object BuiltinLoader {
//    private const val prefix: String = "interp.builtin"
//
//    fun load() {
//
//        val reflections = Reflections(
//            prefix,
//            SubTypesScanner(false)
//        )
//        var count = 0
//        reflections.getSubTypesOf(Builtin::class.java).forEach {
//            val name = it.name
//            if (!name.startsWith(prefix)) return@forEach
//            val jClass = it
//            if (jClass.isInterface) return@forEach
//            if (jClass.isSynthetic) return@forEach
//            val kClass = jClass.kotlin
//            if (kClass.isInner || kClass.isAbstract) return@forEach
//            try {
//                val obj: Builtin = kClass.createInstance() as Builtin
//
//                count++
//            } catch (e: Throwable) {
//                termOut.error(e)
//            }
//        }
//        termOut.info("Loaded $count built-ins")
//    }
//}