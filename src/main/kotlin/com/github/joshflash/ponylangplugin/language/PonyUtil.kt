package com.github.joshflash.ponylangplugin.language

import com.github.joshflash.ponylangplugin.language.indexing.PonyTypeReferenceIndex
import com.github.joshflash.ponylangplugin.language.psi.*
import com.github.joshflash.ponylangplugin.services.PonylangProjectService
import com.intellij.openapi.project.Project
import com.intellij.psi.*
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.indexing.FileBasedIndex
import java.util.*

object PonyUtil {
    private val fileIndex
        get() = FileBasedIndex.getInstance()

    private val typeRefIndexId
        get() = PonyTypeReferenceIndex.INDEX_ID

    private fun Project.getStdLibIndex() =
        this.getService(PonylangProjectService::class.java).stdLibIndexStorage

    private fun Project.globalScope() =
        GlobalSearchScope.allScope(this)

    private fun getPonySourceFileForType(typeId: String, project: Project): PonyFile? {
        val vFilesWithKey = fileIndex.getContainingFiles(typeRefIndexId, typeId, project.globalScope())
        val psiManager = PsiManager.getInstance(project)
        for (vFile in vFilesWithKey) {
            val ponyFile = psiManager.findFile(vFile) as? PonyFile ?: continue
            return ponyFile
        }

        return project.getStdLibIndex().getValue(typeId)
    }

    fun resolveTypeReference(typeId: String, project: Project): PonyTypeRef? {
        val sourceFile = getPonySourceFileForType(typeId, project) ?: return null
        val classDefs = PsiTreeUtil.collectElementsOfType(sourceFile, PonyClassDef::class.java)
        for (classDef in classDefs) {
            if (classDef.typeRef.typeId.text == typeId) {
                return classDef.typeRef
            }
        }

        return null
    }

    fun findAllClassDefSource(project: Project): Map<String, String> {
        val typeIdToSourceFile = mutableMapOf<String, String>()
        val stdLibFiles = project.getStdLibIndex().getMap()
        for (file in stdLibFiles) {
            val sourceFile = file.value.value?.containingFile?.name ?: continue
            typeIdToSourceFile[file.key] = sourceFile
        }

        fileIndex.processAllKeys(typeRefIndexId, { key ->
            processIndexValuesForKey(fileIndex, project, key, typeIdToSourceFile)
            true
        }, project)

        return typeIdToSourceFile
    }

    private fun processIndexValuesForKey(
        fileBasedIndex: FileBasedIndex,
        project: Project,
        key: String,
        typeIdsToSourceFiles: MutableMap<String, String>
    ) {
        fileBasedIndex.processValues(
            typeRefIndexId, key, null,
            { _, fileName ->
                typeIdsToSourceFiles[key] = fileName
                true
            },
            project.globalScope()
        )
    }

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