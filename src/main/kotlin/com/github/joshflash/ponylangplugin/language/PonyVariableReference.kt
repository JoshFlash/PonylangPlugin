package com.github.joshflash.ponylangplugin.language

import com.github.joshflash.ponylangplugin.language.psi.*
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.util.PsiTreeUtil

class PonyVariableReference(idVar: PonyIdVar): PsiReferenceBase<PonyIdVar>(idVar) {
    override fun resolve(): PsiElement? {
        val key = element.id?.text ?: return null

        val memberId = PonyUtil.resolveMembersInFile(element, key)
        if (memberId != null) {
            return memberId
        }

        val method = PsiTreeUtil.getTopmostParentOfType(element, PonyMethod::class.java)

        val paramRefs = PsiTreeUtil.collectElementsOfType(method, PonyParamRef::class.java)
        val paramId = paramRefs.firstOrNull { it.id?.text == key }
        if (paramId != null) {
            return paramId
        }

        val patternRefs = PsiTreeUtil.collectElementsOfType(method, PonyTermRef::class.java)
        val patternId = patternRefs.firstOrNull { it.id?.text == key }
        if (patternId != null) {
            return patternId
        }

        val ifdefblock = PsiTreeUtil.getParentOfType(element, PonyIfdefblock::class.java)
        val useinfix = PsiTreeUtil.getParentOfType(element, PonyUseinfix::class.java)
        if (ifdefblock != null || useinfix != null) {
            val indexedId =
                PonyUtil.resolveMethodReference(key, element.project)
                ?: PonyUtil.resolveFieldReference(key, element.project)

            if (indexedId != null) {
                return indexedId
            }
        }

        return null
    }
}