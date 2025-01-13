package com.github.joshflash.ponylangplugin.language.psi.impl

import com.github.joshflash.ponylangplugin.language.PonyLanguage
import com.github.joshflash.ponylangplugin.language.psi.PonyFile
import com.github.joshflash.ponylangplugin.language.psi.PonyMemberRef
import com.github.joshflash.ponylangplugin.language.psi.PonyTypes
import com.github.joshflash.ponylangplugin.language.psi.PonyTypes.*
import com.intellij.lang.ASTNode
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory

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

                return file.findChildByClass(PonyMemberRef::class.java)
            }
        }
    }
}
