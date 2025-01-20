package com.github.joshflash.ponylangplugin.language

import com.github.joshflash.ponylangplugin.language.psi.*
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil

class PonyAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        when (element) {
            is PonyTypeRef -> annotateTypeRef(element, holder)
            is PonyIdVar -> annotateIdVar(element, holder)
            is PonyMemberRef -> annotateMemberRef(element, holder)
            is PonyIfblock -> annotateIfBlock(element, holder)
        }
    }

    private fun annotateIfBlock(element: PonyIfblock, holder: AnnotationHolder) {
        val parentCasePattern = PsiTreeUtil.getParentOfType(element, PonyCasepattern::class.java) ?: return
        val invalidIfblock = parentCasePattern.postfix?.atom?.ifblock
        if (invalidIfblock != null) {
            holder.newAnnotation(HighlightSeverity.ERROR, "Invalid If Statement within case pattern: ${element.text}")
                .range(invalidIfblock.textRange)
                .create()
        }
    }

    private fun annotateTypeRef(element: PonyTypeRef, holder: AnnotationHolder) {
        val resolved = PonyTypeReference(element).resolve()
        if (resolved == null) {
            holder.newAnnotation(HighlightSeverity.ERROR, "Unresolved type: ${element.text}")
                .range(element.typeId.textRange)
                .create()
        }
    }

    private fun annotateIdVar(element: PonyIdVar, holder: AnnotationHolder) {
        val resolved = PonyVariableReference(element).resolve()
        if (resolved == null && element.id != null) {
            holder.newAnnotation(HighlightSeverity.ERROR, "Unresolved reference: ${element.text}")
                .range(element.id!!.textRange)
                .create()
        }
    }

    private fun annotateMemberRef(element: PonyMemberRef, holder: AnnotationHolder) {
        val resolved = PonyMemberReference(element).resolve()
        if (resolved == null) {
            holder.newAnnotation(HighlightSeverity.ERROR, "Unresolved member: ${element.text}")
                .range(element.id.textRange)
                .create()
        }
    }
}
