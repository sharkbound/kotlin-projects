package gui.extensions

val Any?.isNotNull get() = this != null
val Any?.isNull get() = this == null