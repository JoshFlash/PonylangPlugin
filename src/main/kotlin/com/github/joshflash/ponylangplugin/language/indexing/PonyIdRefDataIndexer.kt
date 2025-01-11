package com.github.joshflash.ponylangplugin.language.indexing

import com.github.joshflash.ponylangplugin.language.psi.PonyClassDef
import com.github.joshflash.ponylangplugin.language.psi.PonyFile
import com.github.joshflash.ponylangplugin.language.psi.PonyMembers
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.indexing.DataIndexer
import com.intellij.util.indexing.FileContent

// maps field and method identifiers to their defining classes
class PonyIdRefDataIndexer: DataIndexer<String, String, FileContent> {
    override fun map(inputData: FileContent): Map<String, String> {
        val result = mutableMapOf<String, String>()
        val ponyFile = inputData.psiFile as? PonyFile ?: return emptyMap()

        val members = PsiTreeUtil.collectElementsOfType(ponyFile, PonyMembers::class.java)
        for (member in members) {
            val classDef = PsiTreeUtil.getParentOfType(member, PonyClassDef::class.java) ?: continue
            for (field in member.fieldList) {
                result[field.idRef.text] = classDef.typeRef.typeId.text
            }
            for (method in member.methodList) {
                result[method.idRef.text] = classDef.typeRef.typeId.text
            }
        }
        return result
    }
}