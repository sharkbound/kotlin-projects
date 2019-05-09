package sharkbound.commonutils.exceptions

class NoValueException : Throwable("Maybe has no value set, use <maybe>.valueOrNull to avoid this exception")