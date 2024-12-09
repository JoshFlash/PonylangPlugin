package com.github.joshflash.ponylangplugin.language

import com.github.joshflash.ponylangplugin.language.psi.BuiltInTypes
import com.github.joshflash.ponylangplugin.language.psi.PonyType
import com.github.joshflash.ponylangplugin.language.psi.PonyTypes
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil

class PonyTypeAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element.node.elementType == PonyTypes.TYPE_ID) {
            val isValidType =
                BuiltInTypes.INSTRINSIC.contains(element.text) or isUserDefinedType(element)
            if (isValidType) {
                holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(element.textRange)
                    .textAttributes(PonySyntaxHighlighter.TYPE)
                    .create()
            }
        }
    }

    private fun isUserDefinedType(element: PsiElement): Boolean {
        val reference = element.reference?.resolve()
        if (reference != null && reference.node.elementType == PonyTypes.TYPE) {
            return true
        }

        val psiFile = element.containingFile
        val typeDefinitions = PsiTreeUtil.findChildrenOfType(psiFile, PonyType::class.java)
        for (typeDef in typeDefinitions) {
            if (typeDef.text == element.text) {
                return true
            }
        }

        // TODO: extend by using indexing to find type definitions across the project
        return false
    }
}
