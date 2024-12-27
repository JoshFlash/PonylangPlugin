package com.github.joshflash.ponylangplugin.language

import com.github.joshflash.ponylangplugin.language.psi.PonyTypeRef
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*

class PonyTypeReference(typeRef: PonyTypeRef) : PsiReferenceBase<PonyTypeRef>(typeRef, TextRange(0, typeRef.textLength)) {
    override fun resolve(): PsiElement? {
        val startDir = element.containingFile?.containingDirectory ?: return null
        val classDefs = PonyUtil.findClassDefsInDirectory(startDir, includeSubdirectories = true)
        for (child in classDefs) {
            if (child.typeRef.text == element.text) {
                return child.typeRef
            }
        }

        val allClassDefs = PonyUtil.findClassDefsInProject(element.project)
        for (child in allClassDefs) {
            if (child.typeRef.text == element.text) {
                return child.typeRef
            }
        }

        return null
    }
}