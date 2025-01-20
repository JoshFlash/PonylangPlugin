package com.github.joshflash.ponylangplugin.language.psi.impl

import com.github.joshflash.ponylangplugin.language.psi.PonyTypes
import com.github.joshflash.ponylangplugin.language.psi.PonyTypes.*
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface PonyElements {
    class Factory {
        companion object {
            @JvmStatic
            fun createElement(node: ASTNode): PsiElement {
                when(node.elementType) {
                    TYPE_REF -> return PonyTypeRefExt(node)
                    ID_VAR -> return PonyIdVarExt(node)
                    MEMBER_REF -> return PonyMemberRefExt(node)
                }
                return PonyTypes.Factory.createElement(node)
            }
        }
    }
}
