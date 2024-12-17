package com.github.joshflash.ponylangplugin.language.psi.impl

import com.github.joshflash.ponylangplugin.language.PonyTypeReference
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiReference

class PonyClassDefExt (node: ASTNode) : PonyClassDefImpl(node) {
    override fun getReference(): PsiReference {
        return PonyTypeReference(this.typeId);
    }
}