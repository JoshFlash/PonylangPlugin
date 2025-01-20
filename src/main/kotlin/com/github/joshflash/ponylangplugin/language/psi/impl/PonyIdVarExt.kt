package com.github.joshflash.ponylangplugin.language.psi.impl

import com.github.joshflash.ponylangplugin.language.PonyVariableReference
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiReference


class PonyIdVarExt(node: ASTNode): PonyIdVarImpl(node)  {
    override fun getReference(): PsiReference = PonyVariableReference(this)
}
