package sharkbound.commonutils.extensions

import sharkbound.commonutils.Maybe

val <T> T.asMaybe get() = Maybe(this)