package com.github.joshflash.ponylangplugin.language

import com.github.joshflash.ponylangplugin.language.psi.BuiltInTypes
import com.github.joshflash.ponylangplugin.language.psi.PonyClassDef
import com.github.joshflash.ponylangplugin.language.psi.PonyTypeRef
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.util.PsiTreeUtil

class PonyTypeReference(typeRef: PonyTypeRef) : PsiReferenceBase<PonyTypeRef>(typeRef, TextRange(0, typeRef.textLength)) {
    override fun resolve(): PsiElement? {
        if (BuiltInTypes.INSTRINSIC.contains(element.typeId.text)) {
            return element
        }

        val startDir = element.containingFile?.containingDirectory ?: return null
        val classDefs = PonyUtil.findClassDefsInDirectory(startDir, includeSubdirectories = true)
        for (child in classDefs) {
            if (child.typeRef.text == element.text) {
                return child.typeRef
            }
        }

        return null
    }
}