package com.github.joshflash.ponylangplugin.language.psi.impl

import com.github.joshflash.ponylangplugin.language.psi.PonyTypes.*
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface PonyTypesExt {
    class Factory {
        companion object {
            @JvmStatic
            fun createElement(node: ASTNode): PsiElement? {
                when(node.elementType)
                {
                    TYPE_REF -> return PonyTypeRefExt(node)
                }
                return null
            }
        }
    }
}
