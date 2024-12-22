package com.github.joshflash.ponylangplugin.language.completion

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.patterns.ElementPattern
import com.intellij.psi.PsiElement

abstract class PonyCompletionProviderBase : CompletionProvider<CompletionParameters>() {
    abstract val context: ElementPattern<out PsiElement>
    open val type: CompletionType = CompletionType.BASIC
}