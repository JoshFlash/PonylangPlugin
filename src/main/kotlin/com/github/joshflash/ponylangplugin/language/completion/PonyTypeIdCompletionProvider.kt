package com.github.joshflash.ponylangplugin.language.completion

import com.github.joshflash.ponylangplugin.language.PonyLanguage
import com.github.joshflash.ponylangplugin.language.PonyUtil
import com.github.joshflash.ponylangplugin.language.psi.PonyTypes
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.ElementPattern
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.PsiElement
import com.intellij.util.ProcessingContext

object PonyTypeIdCompletionProvider : PonyCompletionProviderBase() {
    override val context: ElementPattern<out PsiElement> =
        PlatformPatterns.psiElement()
            .withLanguage(PonyLanguage)
            .inside(PlatformPatterns.psiElement(PonyTypes.TYPE_REF))
            .inside(PlatformPatterns.or(
                PlatformPatterns.psiElement(PonyTypes.NOMINAL),
                PlatformPatterns.psiElement(PonyTypes.PARTICLE)
            ))


    override fun addCompletions(
        parameters: CompletionParameters,
        processingContext: ProcessingContext,
        results: CompletionResultSet
    ) {
        val psiFile = parameters.originalFile
        val classDefSource = PonyUtil.findAllClassDefSource(psiFile.project)
        classDefSource.forEach { (typeId, sourceFile) ->
            val lookupElement = LookupElementBuilder.create(typeId)
                .withPresentableText(typeId)
                .withTailText(" from $sourceFile", true)
            results.addElement(lookupElement)
        }
    }

}