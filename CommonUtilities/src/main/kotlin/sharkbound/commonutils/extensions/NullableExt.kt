package sharkbound.commonutils.extensions

val Boolean?.isTrue
    get() = this != null && this


val Boolean?.isFalse
    get() = this != null && !this
