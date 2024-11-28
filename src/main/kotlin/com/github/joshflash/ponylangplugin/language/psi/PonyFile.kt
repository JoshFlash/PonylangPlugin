package com.github.joshflash.ponylangplugin.language.psi

import com.github.joshflash.ponylangplugin.language.PonyFileType
import com.github.joshflash.ponylangplugin.language.PonyLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class PonyFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, PonyLanguage) {
    override fun getFileType(): FileType = PonyFileType.INSTANCE
    override fun toString(): String = "Pony File"
}