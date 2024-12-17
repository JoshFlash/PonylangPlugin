package com.github.joshflash.ponylangplugin.language

import com.github.joshflash.ponylangplugin.language.psi.BuiltInTypes
import com.github.joshflash.ponylangplugin.language.psi.PonyClassDef
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.util.PsiTreeUtil

class PonyTypeReference(typeIdElement: PsiElement) : PsiReferenceBase<PsiElement>(typeIdElement, TextRange(0, typeIdElement.textLength)) {
    override fun resolve(): PsiElement? {

        if (BuiltInTypes.INSTRINSIC.contains(element.text)) {
            return element
        }

        val startDir = element.containingFile?.containingDirectory ?: return null
        val classDefs = collectAllClassDefs(startDir)
        for (child in classDefs) {
            if (child.typeId.text == element.text) {
                return child.typeId
            }
        }

        return null
    }

    private fun collectAllClassDefs(directory: PsiDirectory) : MutableList<PonyClassDef> {

        val result = mutableListOf<PonyClassDef>()
        directory.files
            .filterIsInstance<PsiFile>()
            .forEach { file ->
                result.addAll(PsiTreeUtil.findChildrenOfType(file, PonyClassDef::class.java))
            }

        directory.subdirectories.forEach { subDir ->
            result.addAll(collectAllClassDefs(subDir))
        }

        return result
    }

}