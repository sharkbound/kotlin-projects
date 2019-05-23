package sharkbound.commonutils.extensions

val Collection<*>.len get() = size
val Array<*>.len get() = size
val Map<*, *>.len get() = size
val Set<*>.len get() = size