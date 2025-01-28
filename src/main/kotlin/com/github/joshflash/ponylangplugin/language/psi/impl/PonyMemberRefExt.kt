package com.github.joshflash.ponylangplugin.language.psi.impl

import com.github.joshflash.ponylangplugin.language.PonyMemberReference
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiReference

class PonyMemberRefExt(node: ASTNode): PonyMemberRefImpl(node) {
    override fun getReference(): PsiReference = PonyMemberReference(this)
}