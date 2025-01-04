package com.github.joshflash.ponylangplugin.language

import com.github.joshflash.ponylangplugin.language.psi.PonyClassDef
import com.github.joshflash.ponylangplugin.language.psi.PonyTypeRef
import com.github.joshflash.ponylangplugin.language.psi.PonyMethod
import com.github.joshflash.ponylangplugin.language.psi.PonyTypeparams
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.util.PsiTreeUtil

class PonyTypeReference(typeRef: PonyTypeRef) : PsiReferenceBase<PonyTypeRef>(typeRef, TextRange(0, typeRef.textLength)) {
    override fun resolve(): PsiElement? {
        val project = element.project
        val key = element.typeId.text

        // resolve a type's own definition
        val parentClassDef = PsiTreeUtil.getParentOfType(element, PonyClassDef::class.java)
        if (parentClassDef != null) {
            if (parentClassDef.typeRef.typeId.text == key) {
                return parentClassDef.typeRef
            }
        }

        // resolve from indexes
        val indexedTypeRef = PonyUtil.resolveTypeReference(key, project)
        if (indexedTypeRef != null) {
            return indexedTypeRef
        }

        // resolve generic types
        val parentMethod = PsiTreeUtil.getTopmostParentOfType(element, PonyMethod::class.java)
        val methodTypeParams = PsiTreeUtil.getChildOfType(parentMethod, PonyTypeparams::class.java)
        if (methodTypeParams != null) {
            for (typeParam in methodTypeParams.typeparamList) {
                if (typeParam.typeRef.typeId.text == key) {
                    return typeParam.typeRef
                }
            }
        }

        val classTypeParams = PsiTreeUtil.getChildOfType(parentClassDef, PonyTypeparams::class.java)
        if (classTypeParams != null) {
            for (typeParam in classTypeParams.typeparamList) {
                if (typeParam.typeRef.typeId.text == key) {
                    return typeParam.typeRef
                }
            }
        }

        return null
    }
}