package sharkbound.groupmanager.regex

val rePhone = """^\(?(\d{3})\)? *(\d{3})[ -]*(\d{4})${'$'}""".toRegex()