package com.github.joshflash.ponylangplugin.language

import com.github.joshflash.ponylangplugin.language.psi.PonyClassDef
import com.github.joshflash.ponylangplugin.language.psi.PonyField
import com.github.joshflash.ponylangplugin.language.psi.PonyFile
import com.intellij.openapi.project.Project
import com.intellij.psi.*
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import java.util.*

object PonyUtil {
    fun findFieldsInProject(project: Project): List<PonyField> {
        return findInProject<PonyField>(project)
            .filterNot { it.id.text.startsWith('_') }
    }

    fun findFieldsInDirectory(
        directory: PsiDirectory,
        includeSubdirectories: Boolean = false
    ) : List<PonyField> {
        return findInDirectory<PonyField>(directory, includeSubdirectories)
            .filterNot { it.id.text.startsWith('_') }
    }

    fun findFieldsInFile(file: PsiFile) : List<PonyField> {
        val result = findInFile<PonyField>(file)

        return result
    }

    fun findClassDefsInProject(project: Project): List<PonyClassDef> {
        return findInProject<PonyClassDef>(project)
    }

    fun findClassDefsInDirectory(
        directory: PsiDirectory,
        includeSubdirectories: Boolean = false
    ) : List<PonyClassDef> {
        return findInDirectory<PonyClassDef>(directory, includeSubdirectories)
    }

    fun findClassDefsInFile(file: PsiFile) : List<PonyClassDef> {
        return findInFile<PonyClassDef>(file)
    }

    private inline fun <reified T: PsiElement> findInFile(file: PsiFile) : List<T> {
        val result = ArrayList<T>()
        result.addAll(PsiTreeUtil.findChildrenOfType(file, T::class.java))

        return result
    }

    private inline fun <reified T : PsiElement> findInDirectory(
        directory: PsiDirectory,
        includeSubdirectories: Boolean
    ) : List<T> {
        val result = ArrayList<T>()
        directory.files
            .filterIsInstance<PsiFile>()
            .forEach { file ->
                result.addAll(PsiTreeUtil.findChildrenOfType(file, T::class.java))
            }

        if (includeSubdirectories) {
            directory.subdirectories.forEach { subDir ->
                result.addAll(findInDirectoryRecursive(subDir))
            }
        }

        return result
    }

    private inline fun <reified T : PsiElement> findInDirectoryRecursive(directory: PsiDirectory?): List<T> {
        if (directory == null) return emptyList()

        val results = ArrayList<T>()
        val stack = Stack<PsiDirectory>()
        stack.push(directory)

        while (stack.isNotEmpty()) {
            val currentDirectory = stack.pop()
            results.addAll(PsiTreeUtil.collectElementsOfType(currentDirectory, T::class.java))
            for (subdirectory in currentDirectory.subdirectories) {
                stack.push(subdirectory)
            }
        }

        return results
    }

    private inline fun <reified T : PsiElement> findInProject(project: Project): List<T> {
        val results = ArrayList<T>()
        val virtualFiles = FileTypeIndex.getFiles(PonyFileType.INSTANCE, GlobalSearchScope.allScope(project))
        for (virtualFile in virtualFiles) {
            val ponyFile: PonyFile = PsiManager.getInstance(project).findFile(virtualFile!!) as? PonyFile ?: continue
            results.addAll(PsiTreeUtil.collectElementsOfType(ponyFile, T::class.java))
        }
        return results
    }

}