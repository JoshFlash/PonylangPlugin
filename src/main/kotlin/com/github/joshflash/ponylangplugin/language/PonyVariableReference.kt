package com.github.joshflash.ponylangplugin.language

import com.github.joshflash.ponylangplugin.language.psi.*
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.util.PsiTreeUtil

class PonyVariableReference(idVar: PonyIdVar): PsiReferenceBase<PonyIdVar>(idVar) {
    override fun resolve(): PsiElement? {
        val key = element.id?.text ?: return null

        val topLevelMember = resolveTopLevelMembers(key)
        if (topLevelMember != null) {
            return topLevelMember
        }

        val method = PsiTreeUtil.getTopmostParentOfType(element, PonyMethod::class.java)

        val paramRefs = PsiTreeUtil.collectElementsOfType(method, PonyParamRef::class.java)
        val paramId = paramRefs.firstOrNull { it.id?.text == key }
        if (paramId != null) {
            return paramId
        }

        val patternRefs = PsiTreeUtil.collectElementsOfType(method, PonyTermRef::class.java)
        val patternId = patternRefs.firstOrNull { it.id?.text == key }
        if (patternId != null) {
            return patternId
        }

        return null
    }

    private fun resolveTopLevelMembers(key: String): PsiElement? {
        val privateFields = PonyUtil.findAllInFile<PonyField>(element.containingFile)
        val fieldId = privateFields.firstOrNull { it.memberRef.id.text == key }?.memberRef
        if (fieldId != null && !memberCallExists()) {
            return fieldId
        }

        val privateMethods = PonyUtil.findAllInFile<PonyMethod>(element.containingFile)
        val methodId = privateMethods.firstOrNull { it.memberRef.id.text == key }?.memberRef
        if (methodId != null) {
            return methodId
        }

        val useStatements = PonyUtil.findAllInFile<PonyUsestmt>(element.containingFile)
        val useStmtId = useStatements.firstOrNull { it.id?.text == key}?.id
        if (useStmtId != null) {
            return useStmtId
        }

        return fieldId
    }

    private fun memberCallExists(): Boolean {
        val atom = PsiTreeUtil.getContextOfType(element, PonyAtom::class.java)
        return PsiTreeUtil.getNextSiblingOfType(atom, PonyPostfixelem::class.java)?.call != null
    }
}