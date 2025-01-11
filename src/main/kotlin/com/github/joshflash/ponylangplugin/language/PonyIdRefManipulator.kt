package com.github.joshflash.ponylangplugin.language

import com.github.joshflash.ponylangplugin.language.psi.impl.PonyIdRefExt
import com.intellij.openapi.util.TextRange
import com.intellij.psi.AbstractElementManipulator

class PonyIdRefManipulator : AbstractElementManipulator<PonyIdRefExt>() {
    override fun handleContentChange(element: PonyIdRefExt, range: TextRange, newContent: String): PonyIdRefExt {
        val oldText = element.text
        val updatedText = (oldText.substring(0, range.getStartOffset())
                + newContent
                + oldText.substring(range.getEndOffset()))
        element.setName(updatedText)
        return element
    }

    override fun getRangeInElement(element: PonyIdRefExt): TextRange {
        return TextRange.from(0, element.textLength)
    }
}