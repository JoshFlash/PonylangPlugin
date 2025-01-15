package com.github.joshflash.ponylangplugin.language

import com.github.joshflash.ponylangplugin.language.psi.*
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.util.PsiTreeUtil

class PonyVariableReference(idVar: PonyIdVar): PsiReferenceBase<PonyIdVar>(idVar) {
    override fun resolve(): PsiElement? {
        val key = element.id?.text ?: return null

        val nestingObjectDef  = PsiTreeUtil.getParentOfType(element, PonyObjectDef::class.java)
        val containingMethod = PsiTreeUtil.getContextOfType(nestingObjectDef ?: element, PonyMethod::class.java)

        val methodParams = PsiTreeUtil.getChildOfType(containingMethod, PonyParams::class.java)
        val paramId = methodParams?.paramList?.firstOrNull { it.paramRef.id.text == key }?.paramRef
        if (paramId != null) {
            return paramId
        }

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

        val patternRefs = PsiTreeUtil.collectElementsOfType(containingMethod, PonyPatternRef::class.java)
        for (patternRef in patternRefs) {
            if (patternRef.id?.text == key) {
                val commonParent = PsiTreeUtil.findCommonParent(patternRef, element)

                val nestingConstruct = PsiTreeUtil.getParentOfType(patternRef, PonyConstruct::class.java)
                val commonConstruct = PsiTreeUtil.getParentOfType(commonParent, PonyConstruct::class.java)
                if (commonConstruct == nestingConstruct) {
                    return patternRef
                }
            }
        }

        return null
    }

    private fun memberCallExists(): Boolean {
        val atom = PsiTreeUtil.getContextOfType(element, PonyAtom::class.java)
        return PsiTreeUtil.getNextSiblingOfType(atom, PonyPostfixelem::class.java)?.call != null
    }
}