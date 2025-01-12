package com.github.joshflash.ponylangplugin.language

import com.github.joshflash.ponylangplugin.language.psi.PonyIdVar
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase

class PonyMemberReference(idVar: PonyIdVar): PsiReferenceBase<PonyIdVar>(idVar) {
    override fun resolve(): PsiElement? {
        val project = element.project
        val key = element.id?.text ?: return null

        val indexedTypeRef = PonyUtil.resolveMemberReference(key, project)
        if (indexedTypeRef != null) {
            return indexedTypeRef
        }

        return element
    }
}