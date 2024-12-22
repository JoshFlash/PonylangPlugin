package com.github.joshflash.ponylangplugin.language.completion

import com.github.joshflash.ponylangplugin.language.PonyLanguage
import com.github.joshflash.ponylangplugin.language.PonyUtil
import com.github.joshflash.ponylangplugin.language.psi.BuiltInTypes
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
            .inside(PlatformPatterns.psiElement(PonyTypes.NOMINAL))

    override fun addCompletions(
        parameters: CompletionParameters,
        processingContext: ProcessingContext,
        results: CompletionResultSet
    ) {
        val psiFile = parameters.originalFile
        val classDefs = PonyUtil.findClassDefsInProject(psiFile.project)
        classDefs.forEach { classDef ->
            val className = classDef.typeRef.typeId.text
            val lookupElement = LookupElementBuilder.create(className)
                .withPresentableText(className)
                .withTailText(" from " + classDef.containingFile.name, true)
            results.addElement(lookupElement)
        }
        BuiltInTypes.INSTRINSIC.forEach { tokenType ->
            results.addElement(LookupElementBuilder.create(tokenType))
        }
    }

}