package com.github.joshflash.ponylangplugin.language.psi.impl

import com.github.joshflash.ponylangplugin.language.PonyTypeReference
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiReference

class PonyTypeRefExt(node: ASTNode) : PonyTypeRefImpl(node) {
    override fun getReference(): PsiReference = PonyTypeReference(this)
}