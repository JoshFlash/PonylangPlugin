package com.github.joshflash.ponylangplugin.language.indexing

import com.github.joshflash.ponylangplugin.language.psi.PonyClassDef
import com.github.joshflash.ponylangplugin.language.psi.PonyFile
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.indexing.DataIndexer
import com.intellij.util.indexing.FileContent

class PonyTypeRefDataIndexer: DataIndexer<String, String, FileContent> {
    override fun map(inputData: FileContent): Map<String, String> {
        val result = mutableMapOf<String, String>()
        val ponyFile = inputData.psiFile as? PonyFile ?: return emptyMap()

        val classDefs = PsiTreeUtil.collectElementsOfType(ponyFile, PonyClassDef::class.java)
        for (classDef in classDefs) {
            result[classDef.typeRef.typeId.text] = ponyFile.name
        }
        return result
    }
}