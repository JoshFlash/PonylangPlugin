package com.github.joshflash.ponylangplugin.language.psi

import com.github.joshflash.ponylangplugin.language.PonyLanguage
import com.intellij.psi.tree.IElementType
import org.jetbrains.annotations.NonNls

class PonyElementType(@NonNls debugName: String) : IElementType(debugName, PonyLanguage)