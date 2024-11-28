package com.github.joshflash.ponylangplugin.language

import com.intellij.lang.Language

object PonyLanguage : Language("Pony") {
    override fun getDisplayName(): String = "Pony"
    override fun getMimeTypes(): Array<String> = arrayOf("text/x-pony")
}