package sharkbound.commonutils.exceptions

class MaybeValueNotSetException :
    Throwable("Maybe has no value set, use <maybe>.valueOrNull or <maybe>.orDefault(...) to avoid this exception")