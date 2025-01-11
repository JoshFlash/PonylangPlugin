package com.github.joshflash.ponylangplugin.language

import com.github.joshflash.ponylangplugin.language.psi.*
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.psi.PsiElement

class PonyAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        when (element) {
            is PonyTypeRef -> annotateTypeRef(element, holder)
            is PonyIdRef -> annotateIdRef(element, holder)
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

    private fun annotateIdRef(element: PonyIdRef, holder: AnnotationHolder) {
        val resolved = PonyIdReference(element).resolve()
        if (resolved == null && element.id != null) {
            holder.newAnnotation(HighlightSeverity.ERROR, "Cannot resolve reference to ${element.text}")
                .range(element.id!!.textRange)
                .create()
        }
    }
}
