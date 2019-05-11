package sharkbound.commonutils.extensions

import sharkbound.commonutils.Maybe

val <T> T?.toMaybe get() = Maybe(this)