package com.github.joshflash.ponylangplugin.language

import com.github.joshflash.ponylangplugin.language.psi.PonyIdVar
import com.github.joshflash.ponylangplugin.language.psi.PonyMemberRef
import com.github.joshflash.ponylangplugin.language.psi.PonyTypeRef
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceProvider
import com.intellij.psi.util.elementType
import com.intellij.util.ProcessingContext

class PonyReferenceProvider : PsiReferenceProvider() {
    override fun getReferencesByElement(element: PsiElement, context: ProcessingContext): Array<PsiReference> {
        return when (element.elementType) {
            is PonyTypeRef -> arrayOf(PonyTypeReference(element as PonyTypeRef))
            is PonyMemberRef -> arrayOf(PonyMemberReference(element as PonyMemberRef))
            is PonyIdVar -> arrayOf(PonyVariableReference(element as PonyIdVar))
            else -> PsiReference.EMPTY_ARRAY
        }
    }
}