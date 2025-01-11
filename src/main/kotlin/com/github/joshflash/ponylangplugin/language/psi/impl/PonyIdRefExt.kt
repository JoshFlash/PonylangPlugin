package com.github.joshflash.ponylangplugin.language.psi.impl

import com.github.joshflash.ponylangplugin.language.PonyIdReference
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.PsiReference


class PonyIdRefExt(node: ASTNode): PonyIdRefImpl(node), PsiNameIdentifierOwner  {
    override fun getReference(): PsiReference = PonyIdReference(this)

    override fun setName(name: String): PsiElement {
        val newIdNode = PonyElements.Factory.createId(project, name)?.node ?: return this
        val oldIdNode = id?.node ?: return this

        node.replaceChild(oldIdNode, newIdNode)

        return this
    }

    override fun getNameIdentifier(): PsiElement? = this.id
}
