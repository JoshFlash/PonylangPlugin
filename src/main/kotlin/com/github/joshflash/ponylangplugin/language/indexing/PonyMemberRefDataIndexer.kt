package com.github.joshflash.ponylangplugin.language.indexing

import com.github.joshflash.ponylangplugin.language.psi.PonyClassDef
import com.github.joshflash.ponylangplugin.language.psi.PonyFile
import com.github.joshflash.ponylangplugin.language.psi.PonyMembers
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.indexing.DataIndexer
import com.intellij.util.indexing.FileContent

class PonyMemberRefDataIndexer: DataIndexer<String, String, FileContent> {
    override fun map(inputData: FileContent): Map<String, String> {
        val result = mutableMapOf<String, String>()
        val ponyFile = inputData.psiFile as? PonyFile ?: return emptyMap()

        val members = PsiTreeUtil.collectElementsOfType(ponyFile, PonyMembers::class.java)
        for (member in members) {
            val classDef = PsiTreeUtil.getParentOfType(member, PonyClassDef::class.java) ?: continue
//            val prefix = classDef.typeRef.typeId.text
            for (field in member.fieldList) {
                if (field.memberRef.text.startsWith('_')) continue
                result[field.memberRef.text] = ponyFile.name
            }
            for (method in member.methodList) {
                if (method.memberRef.text.startsWith('_')) continue
                result[method.memberRef.text] = ponyFile.name
            }
        }
        return result
    }
}