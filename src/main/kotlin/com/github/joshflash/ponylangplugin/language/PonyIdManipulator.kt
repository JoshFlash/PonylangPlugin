package com.github.joshflash.ponylangplugin.language

import com.intellij.openapi.util.TextRange
import com.intellij.psi.AbstractElementManipulator
import com.intellij.psi.PsiElement

class PonyIdManipulator : AbstractElementManipulator<PsiElement>() {
    override fun handleContentChange(element: PsiElement, range: TextRange, newContent: String): PsiElement {
        val oldText = element.text
        val updatedText = (oldText.substring(0, range.startOffset)
                + newContent
                + oldText.substring(range.endOffset))

        // TODO
        return element
    }
}