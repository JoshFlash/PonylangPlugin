package com.github.joshflash.ponylangplugin.language.psi.impl

import com.github.joshflash.ponylangplugin.language.psi.PonyTypes
import com.intellij.psi.PsiElement

class PonyPsiImplUtil {
    fun getId(element: PsiElement): String? {
        return element.node.findChildByType(PonyTypes.ID)?.text
    }

    fun getTypeId(element: PsiElement): String? {
        return element.node.findChildByType(PonyTypes.TYPE_ID)?.text
    }
}