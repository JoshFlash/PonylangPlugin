package com.github.joshflash.ponylangplugin.language.psi.impl

import com.github.joshflash.ponylangplugin.language.PonyLanguage
import com.github.joshflash.ponylangplugin.language.PonyParserDefinition
import com.github.joshflash.ponylangplugin.language.psi.PonyFile
import com.github.joshflash.ponylangplugin.language.psi.PonyIdRef
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
                    ID_REF -> return PonyIdRefExt(node)
                }
                return PonyTypes.Factory.createElement(node)
            }

            @JvmStatic
            fun createId(project: Project, name: String): PsiElement? {
                val dummyFile: String =
                """
                Actor _X_DUMMY_X_
                  let ${name}: String
                """.trimIndent()

                val file = PsiFileFactory.getInstance(project).createFileFromText(
                    "dummy.pony", PonyLanguage, dummyFile
                ) as PonyFile

                return file.findChildByClass(PonyIdRef::class.java)
            }
        }
    }
}
