package com.github.joshflash.ponylangplugin.language.psi.impl

import com.github.joshflash.ponylangplugin.language.PonyLanguage
import com.github.joshflash.ponylangplugin.language.PonyParserDefinition
import com.github.joshflash.ponylangplugin.language.psi.PonyFile
import com.github.joshflash.ponylangplugin.language.psi.PonyTypes
import com.github.joshflash.ponylangplugin.language.psi.PonyTypes.*
import com.github.joshflash.ponylangplugin.parser.PonyParser
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilderFactory
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.PsiManager

interface PonyElements {
    class Factory {
        companion object {
            @JvmStatic
            fun createElement(node: ASTNode): PsiElement {
                when(node.elementType) {
                    TYPE_REF -> return PonyTypeRefExt(node)
                }
                return PonyTypes.Factory.createElement(node)
            }
        }
    }
}
