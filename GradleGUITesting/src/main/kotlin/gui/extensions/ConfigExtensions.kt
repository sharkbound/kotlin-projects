package gui.extensions

import gui.util.gson

val <T> T.toJsonBytes: ByteArray get() = gson.toJson(this).toByteArray()

