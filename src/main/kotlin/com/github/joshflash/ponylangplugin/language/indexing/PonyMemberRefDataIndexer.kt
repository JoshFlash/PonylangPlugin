package com.github.joshflash.ponylangplugin.language.indexing

import com.github.joshflash.ponylangplugin.language.psi.PonyFile
import com.github.joshflash.ponylangplugin.language.psi.PonyMembers
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.indexing.DataIndexer
import com.intellij.util.indexing.FileContent

class PonyMemberRefDataIndexer: DataIndexer<String, String, FileContent> {
    override fun map(inputData: FileContent): Map<String, String> {
        val result = mutableMapOf<String, String>()
        val ponyFile = inputData.psiFile as? PonyFile ?: return emptyMap()

        val fieldSuffix = PonyMemberReferenceIndex.FIELD_SUFFIX
        val methodSuffix = PonyMemberReferenceIndex.METHOD_SUFFIX

        val allMembers = PsiTreeUtil.collectElementsOfType(ponyFile, PonyMembers::class.java)
        for (members in allMembers) {
            for (field in members.fieldList) {
                result[field.memberRef.text + fieldSuffix] = ponyFile.name
            }
            for (method in members.methodList) {
                result[method.memberRef.text + methodSuffix] = ponyFile.name
            }
        }

        return result
    }
}