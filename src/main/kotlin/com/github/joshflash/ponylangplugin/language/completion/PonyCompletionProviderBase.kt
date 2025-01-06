package com.github.joshflash.ponylangplugin.language.completion

import com.github.joshflash.ponylangplugin.language.PonyLanguage
import com.github.joshflash.ponylangplugin.language.psi.PonyRawseq
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.patterns.ElementPattern
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.PsiElement

abstract class PonyCompletionProviderBase : CompletionProvider<CompletionParameters>() {
    abstract val context: ElementPattern<out PsiElement>
    open val type: CompletionType = CompletionType.BASIC
}