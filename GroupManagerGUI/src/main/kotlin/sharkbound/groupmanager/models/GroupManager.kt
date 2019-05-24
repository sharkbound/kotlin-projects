package sharkbound.groupmanager.models

import sharkbound.commonutils.extensions.closeAfter
import sharkbound.commonutils.extensions.len
import sharkbound.commonutils.toMaybe
import sharkbound.groupmanager.constants.CONFIG_FILE
import java.io.*
import java.nio.file.Files
import java.nio.file.Path

class GroupManager(val groups: MutableList<Group> = mutableListOf()) : MutableCollection<Group>, Serializable {
    companion object {
        fun load() = loadGroupManagerFromConfigFile()
    }

    val members get() = groups.asSequence().flatMap { it.members.asSequence() }

    inline infix fun findMember(block: Member.() -> Boolean) =
        members.find(block).toMaybe

    inline infix fun findGroup(block: Group.() -> Boolean) =
        groups.find(block).toMaybe

    inline fun modifyGroup(predicate: Group.() -> Boolean, onMatch: Group.() -> Unit) {
        groups.find(predicate)?.onMatch()
        save()
    }

    inline fun modifyMember(predicate: Member.() -> Boolean, onMatch: Member.() -> Unit) {
        members.firstOrNull(predicate)?.onMatch()
        save()
    }

    inline infix fun saveAfter(block: GroupManager.() -> Unit) = try {
        this.block()
        save()
    } catch (e: Throwable) {
    }

    override val size get() = groups.len

    override fun add(element: Group) = groups.add(element)
    override fun addAll(elements: Collection<Group>) = groups.addAll(elements)
    override fun remove(element: Group) = groups.remove(element)
    override fun removeAll(elements: Collection<Group>) = groups.removeAll(elements)
    override fun retainAll(elements: Collection<Group>) = groups.retainAll(elements)
    override fun containsAll(elements: Collection<Group>) = elements.all(this::contains)
    override fun isEmpty() = len == 0
    override fun iterator() = groups.iterator()

    override fun clear() {
        groups.clear()
    }

    override operator fun contains(element: Group) = element in groups
    operator fun get(index: Int) = groups[index]
    operator fun set(index: Int, group: Group) {
        groups[index] = group
    }

    override fun toString() = "<${this::class.simpleName} len=$len>"
}

fun GroupManager.save() {
    saveGroupManager(this)
}

private fun saveGroupManager(manager: GroupManager) {
    ObjectOutputStream(FileOutputStream(CONFIG_FILE)).closeAfter {
        writeObject(manager)
    }
}

private fun createConfigFileIfNotExist() {
    if (!Files.exists(Path.of(CONFIG_FILE))) {
        saveGroupManager(GroupManager())
    }
}

private fun loadGroupManagerFromConfigFile(): GroupManager {
    createConfigFileIfNotExist()
    return with(ObjectInputStream(FileInputStream(CONFIG_FILE))) {
        (readObject() as GroupManager).apply {
            close()
        }
    }
}
