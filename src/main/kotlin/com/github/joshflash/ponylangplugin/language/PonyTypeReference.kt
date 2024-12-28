package com.github.joshflash.ponylangplugin.language

import com.github.joshflash.ponylangplugin.language.psi.PonyClassDef
import com.github.joshflash.ponylangplugin.language.psi.PonyFile
import com.github.joshflash.ponylangplugin.language.psi.PonyTypeRef
import com.github.joshflash.ponylangplugin.language.indexing.PonyTypeReferenceIndex
import com.intellij.openapi.project.DumbService
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiManager
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.indexing.FileBasedIndex

class PonyTypeReference(typeRef: PonyTypeRef) : PsiReferenceBase<PonyTypeRef>(typeRef, TextRange(0, typeRef.textLength)) {
    override fun resolve(): PsiElement? {
        val project = element.project
        if (DumbService.isDumb(project)) return dumbResolve()

        val parentClassDef = PsiTreeUtil.getParentOfType(element, PonyClassDef::class.java)
        if (parentClassDef != null) {
            if (parentClassDef.typeRef.typeId.text == element.typeId.text) {
                return parentClassDef.typeRef
            }
        }

        val key = element.typeId.text
        val index = FileBasedIndex.getInstance()

        val filesWithKey = index.getContainingFiles(
            PonyTypeReferenceIndex.INDEX_ID,
            key,
            GlobalSearchScope.allScope(project)
        )

        for (vFile in filesWithKey) {
            val psiFile = PsiManager.getInstance(project).findFile(vFile) as? PonyFile ?: continue
            val classDefs = PsiTreeUtil.collectElementsOfType(psiFile, PonyClassDef::class.java)
            for (classDef in classDefs) {
                if (classDef.typeRef.typeId.text == key) {
                    return classDef.typeRef
                }
            }
        }

        return null
    }

    private fun dumbResolve(): PsiElement? {
        val startDir = element.containingFile?.containingDirectory ?: return null
        val classDefs = PonyUtil.findClassDefsInDirectory(startDir, includeSubdirectories = true)
        for (child in classDefs) {
            if (child.typeRef.text == element.text) {
                return child.typeRef
            }
        }

        val allClassDefs = PonyUtil.findClassDefsInProject(element.project)
        for (child in allClassDefs) {
            if (child.typeRef.text == element.text) {
                return child.typeRef
            }
        }

        return null
    }
}