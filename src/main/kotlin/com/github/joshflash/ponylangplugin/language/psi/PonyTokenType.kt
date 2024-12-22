package com.github.joshflash.ponylangplugin.language.psi

import com.github.joshflash.ponylangplugin.language.PonyLanguage
import com.intellij.psi.tree.IElementType

class PonyTokenType(debugName: String) : IElementType(debugName, PonyLanguage) {
    override fun toString(): String = "${super.toString()}"
}