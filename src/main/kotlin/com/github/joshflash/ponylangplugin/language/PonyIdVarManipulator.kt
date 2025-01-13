package com.github.joshflash.ponylangplugin.language

import com.github.joshflash.ponylangplugin.language.psi.impl.PonyIdVarExt
import com.intellij.openapi.util.TextRange
import com.intellij.psi.AbstractElementManipulator

class PonyIdVarManipulator : AbstractElementManipulator<PonyIdVarExt>() {
    override fun handleContentChange(element: PonyIdVarExt, range: TextRange, newContent: String): PonyIdVarExt {
        val oldText = element.text
        val updatedText = (oldText.substring(0, range.startOffset)
                + newContent
                + oldText.substring(range.endOffset))
        element.setName(updatedText)
        return element
    }

    override fun getRangeInElement(element: PonyIdVarExt): TextRange {
        return TextRange.from(0, element.textLength)
    }
}