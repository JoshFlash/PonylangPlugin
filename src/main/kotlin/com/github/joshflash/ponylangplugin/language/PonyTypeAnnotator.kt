package com.github.joshflash.ponylangplugin.language

import com.github.joshflash.ponylangplugin.language.psi.*
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.psi.PsiElement

class PonyTypeAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        val resolved = when (element) {
            is PonyTypeRef -> PonyTypeReference(element).resolve()
            else -> return
        }
        if (resolved == null) {
            holder.newAnnotation(HighlightSeverity.ERROR, "Unresolved type: ${element.text}")
                .range(element.typeId.textRange)
                .create()
        }
    }
}
