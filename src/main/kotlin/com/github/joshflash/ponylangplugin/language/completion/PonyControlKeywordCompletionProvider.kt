package com.github.joshflash.ponylangplugin.language.completion

import com.github.joshflash.ponylangplugin.language.PonyLanguage
import com.github.joshflash.ponylangplugin.language.psi.PonyTokenSets
import com.github.joshflash.ponylangplugin.language.psi.PonyTypes
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.ElementPattern
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.PsiElement
import com.intellij.util.ProcessingContext

object PonyControlKeywordCompletionProvider : PonyCompletionProviderBase() {
    override val context: ElementPattern<out PsiElement> =
        PlatformPatterns.psiElement()
            .withLanguage(PonyLanguage)
            .insideSequence(true,
                PlatformPatterns.psiElement(PonyTypes.TERM),
                PlatformPatterns.or(
                    PlatformPatterns.psiElement(PonyTypes.CONTROLBLOCK),
                    PlatformPatterns.psiElement(PonyTypes.RESOURCEBLOCK),
                )
            )

    override fun addCompletions(
        parameters: CompletionParameters,
        processingContext: ProcessingContext,
        results: CompletionResultSet
    ) {
        PonyTokenSets.KW_CONTROL.types.forEach { tokenType ->
            val tokenName = tokenType.toString()
            results.addElement(LookupElementBuilder.create(tokenName))
        }
    }
}