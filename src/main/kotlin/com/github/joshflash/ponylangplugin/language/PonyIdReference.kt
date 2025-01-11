package com.github.joshflash.ponylangplugin.language

import com.github.joshflash.ponylangplugin.language.psi.PonyField
import com.github.joshflash.ponylangplugin.language.psi.PonyIdRef
import com.github.joshflash.ponylangplugin.language.psi.PonyMethod
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.util.PsiTreeUtil

class PonyIdReference(idRef: PonyIdRef): PsiReferenceBase<PonyIdRef>(idRef) {
    override fun resolve(): PsiElement? {
/*        val project = element.project
        val key = element.id?.text ?: return null

        // resolve an identifier's own definition
        val parentField = PsiTreeUtil.getParentOfType(element, PonyField::class.java)
        if (parentField != null) {
            if (parentField.idRef.id?.text == key) {
                return parentField.idRef
            }
        }

        val parentMethod = PsiTreeUtil.getParentOfType(element, PonyMethod::class.java)
        if (parentMethod != null) {
            if (parentMethod.idRef.id?.text == key) {
                return parentMethod.idRef
            }
        }*/
/*

        // resolve from indexes
        val indexedTypeRef = PonyUtil.resolveTypeReference(key, project)
        if (indexedTypeRef != null) {
            return indexedTypeRef
        }
*/

        return element
    }
}