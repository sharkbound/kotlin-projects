package consolemenudsl.utils

import consolemenudsl.data.Args
import consolemenudsl.data.Manager
import consolemenudsl.regex.RegexPatterns
import sharkbound.commonutils.extensions.len

fun String.parseArgs(mgr: Manager) =
    RegexPatterns.splitArgs.findAll(this).run {
        map { it.value.trim('\'', '"', ' ') }
            .toList().let {
                Args(
                    mgr,
                    if (it.isNotEmpty()) it[0].toLowerCase() else "",
                    if (it.isNotEmpty() && it.len > 1) it.slice(1 until it.len) else emptyList()
                )
            }
    }