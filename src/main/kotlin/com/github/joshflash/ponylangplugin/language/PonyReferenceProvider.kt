package com.github.joshflash.ponylangplugin.language

import com.github.joshflash.ponylangplugin.language.psi.PonyClassDef
import com.github.joshflash.ponylangplugin.language.psi.PonyElementType
import com.github.joshflash.ponylangplugin.language.psi.PonyNominal
import com.github.joshflash.ponylangplugin.language.psi.PonyTypes
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceProvider
import com.intellij.psi.util.elementType
import com.intellij.util.ProcessingContext

class PonyReferenceProvider : PsiReferenceProvider() {
    override fun getReferencesByElement(element: PsiElement, context: ProcessingContext): Array<PsiReference> {
        return when (element.elementType) {
            is PonyNominal -> arrayOf(PonyTypeReference(element))
            is PonyClassDef -> arrayOf(PonyTypeReference(element))
            else -> PsiReference.EMPTY_ARRAY
        }
    }
}