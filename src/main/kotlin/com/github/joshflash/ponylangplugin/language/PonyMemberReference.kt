package com.github.joshflash.ponylangplugin.language

import com.github.joshflash.ponylangplugin.language.psi.PonyField
import com.github.joshflash.ponylangplugin.language.psi.PonyMemberRef
import com.github.joshflash.ponylangplugin.language.psi.PonyMethod
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.util.PsiTreeUtil

class PonyMemberReference(memberRef: PonyMemberRef): PsiReferenceBase<PonyMemberRef>(memberRef) {
    override fun resolve(): PsiElement? {
        val key = element.id.text
        val project = element.project

        val parentField = PsiTreeUtil.getParentOfType(element, PonyField::class.java)
        if (parentField != null && parentField.memberRef == element) {
            return element
        }

        val parentMethod = PsiTreeUtil.getParentOfType(element, PonyMethod::class.java)
        if (parentMethod != null && parentMethod.memberRef == element) {
            return element
        }

        val memberRef = PonyUtil.resolveMembersInFile(element, key)
        if (memberRef != null) {
            return memberRef
        }

        val methodReference = PonyUtil.resolveMethodReference(key, project)
        if (methodReference != null) {
            return methodReference
        }

        val fieldReference = PonyUtil.resolveFieldReference(key, project)
        if (fieldReference != null) {
            return fieldReference
        }

        return null
    }
}