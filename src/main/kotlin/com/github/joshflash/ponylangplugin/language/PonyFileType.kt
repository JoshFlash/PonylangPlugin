package com.github.joshflash.ponylangplugin.language

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class PonyFileType : LanguageFileType(PonyLanguage) {
    companion object {
        @JvmStatic
        val INSTANCE = PonyFileType()
    }

    override fun getName(): String = "Pony"
    override fun getDescription(): String = "Pony"
    override fun getDefaultExtension(): String = "pony"
    override fun getIcon(): Icon = PonyIcons.FILE
}