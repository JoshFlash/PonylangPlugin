package com.github.joshflash.ponylangplugin.language

import com.github.joshflash.ponylangplugin.language.psi.PonyClassDef
import com.github.joshflash.ponylangplugin.language.psi.PonyNominal
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.PsiReferenceContributor

class PonyReferenceContributor : PsiReferenceContributor() {
    override fun registerReferenceProviders(registrar: com.intellij.psi.PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(PonyClassDef::class.java),
            PonyReferenceProvider()
        )
        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(PonyNominal::class.java),
            PonyReferenceProvider()
        )
    }
}