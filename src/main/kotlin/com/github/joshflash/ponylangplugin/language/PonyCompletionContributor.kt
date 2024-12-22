package com.github.joshflash.ponylangplugin.language

import com.github.joshflash.ponylangplugin.language.completion.*
import com.intellij.codeInsight.completion.CompletionContributor

class PonyCompletionContributor : CompletionContributor() {
    private val providers = listOf(
        PonyTypeIdCompletionProvider,
        PonyKeywordCompletionProvider
    )
    init {
        providers.forEach { extend(it.type, it.context, it) }
    }
}

