package com.github.joshflash.ponylangplugin.language

import com.github.joshflash.ponylangplugin.language.psi.PonyClassDef
import com.github.joshflash.ponylangplugin.language.psi.PonyFile
import com.github.joshflash.ponylangplugin.language.psi.PonyTypeRef
import com.github.joshflash.ponylangplugin.language.indexing.PonyTypeReferenceIndex
import com.github.joshflash.ponylangplugin.language.psi.PonyMethod
import com.github.joshflash.ponylangplugin.language.psi.PonyTypeparams
import com.github.joshflash.ponylangplugin.services.PonylangProjectService
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

        val key = element.typeId.text

        // resolve a type's own definition
        val parentClassDef = PsiTreeUtil.getParentOfType(element, PonyClassDef::class.java)
        if (parentClassDef != null) {
            if (parentClassDef.typeRef.typeId.text == key) {
                return parentClassDef.typeRef
            }
        }

        // resolve from indexes
        val index = FileBasedIndex.getInstance()
        val indexId = PonyTypeReferenceIndex.INDEX_ID
        val vFilesWithKey = index.getContainingFiles(indexId, key, GlobalSearchScope.allScope(project))
        for (vFile in vFilesWithKey) {
            val psiFile = PsiManager.getInstance(project).findFile(vFile) as? PonyFile ?: continue
            val classDefs = PsiTreeUtil.collectElementsOfType(psiFile, PonyClassDef::class.java)
            for (classDef in classDefs) {
                if (classDef.typeRef.typeId.text == key) {
                    return classDef.typeRef
                }
            }
        }

        val stdLibIndex = project.getService(PonylangProjectService::class.java).stdLibIndexStorage
        val stdLibFilesWithKey = stdLibIndex.read(key).valueIterator
        for (ponyFile in stdLibFilesWithKey) {
            val classDefs = PsiTreeUtil.collectElementsOfType(ponyFile, PonyClassDef::class.java)
            for (classDef in classDefs) {
                if (classDef.typeRef.typeId.text == key) {
                    return classDef.typeRef
                }
            }
        }

        // resolve generic types
        val parentMethod = PsiTreeUtil.getParentOfType(element, PonyMethod::class.java)
        val methodTypeParams = PsiTreeUtil.getChildOfType(parentMethod, PonyTypeparams::class.java)
        if (methodTypeParams != null) {
            for (typeParam in methodTypeParams.typeparamList) {
                if (typeParam.typeRef.typeId.text == key) {
                    return typeParam.typeRef
                }
            }
        }

        val classTypeParams = PsiTreeUtil.getChildOfType(parentClassDef, PonyTypeparams::class.java)
        if (classTypeParams != null) {
            for (typeParam in classTypeParams.typeparamList) {
                if (typeParam.typeRef.typeId.text == key) {
                    return typeParam.typeRef
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

        return element.typeId
    }
}