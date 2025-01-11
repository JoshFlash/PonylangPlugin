package com.github.joshflash.ponylangplugin.language

import com.github.joshflash.ponylangplugin.language.psi.PonyClassDef
import com.github.joshflash.ponylangplugin.language.psi.PonyField
import com.github.joshflash.ponylangplugin.language.psi.PonyIdRef
import com.github.joshflash.ponylangplugin.language.psi.PonyMethod
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
        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(PonyField::class.java),
            PonyReferenceProvider()
        )
        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(PonyMethod::class.java),
            PonyReferenceProvider()
        )
    }
}