package sharkbound.commonutils.exceptions

class ValueNotSetException : Throwable("Maybe has no value set, use <maybe>.valueOrNull to avoid this exception")