package com.github.joshflash.ponylangplugin.language

import com.github.joshflash.ponylangplugin.language.indexing.PonyMemberReferenceIndex
import com.github.joshflash.ponylangplugin.language.indexing.PonyTypeReferenceIndex
import com.github.joshflash.ponylangplugin.language.psi.*
import com.github.joshflash.ponylangplugin.services.PonylangProjectService
import com.intellij.openapi.project.Project
import com.intellij.psi.*
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.indexing.FileBasedIndex
import com.intellij.util.indexing.ID
import java.util.*

object PonyUtil {
    private val fileIndex
        get() = FileBasedIndex.getInstance()

    private val typeRefIndexId
        get() = PonyTypeReferenceIndex.INDEX_ID

    private val memberRefIndexId
        get() = PonyMemberReferenceIndex.INDEX_ID

    private fun Project.getStdLibIndex() =
        this.getService(PonylangProjectService::class.java).stdLibIndexStorage

    private fun Project.globalScope() =
        GlobalSearchScope.allScope(this)

    private fun getPonySourceFileForType(typeId: String, project: Project): PonyFile? {
        return getPonySourceFileFromIndex(typeRefIndexId, typeId, project)
    }

    private fun ponySourceFileForMember(memberId: String, project: Project): PonyFile? {
        return getPonySourceFileFromIndex(memberRefIndexId, memberId, project)
    }

    private fun getPonySourceFileFromIndex(index: ID<String, String>, id: String, project: Project): PonyFile? {
        val vFilesWithKey = fileIndex.getContainingFiles(index, id, project.globalScope())
        val psiManager = PsiManager.getInstance(project)
        for (vFile in vFilesWithKey) {
            val ponyFile = psiManager.findFile(vFile) as? PonyFile ?: continue
            return ponyFile
        }

        return project.getStdLibIndex().getValue(id)
    }

    fun resolveTypeReference(typeId: String, project: Project): PonyTypeRef? {
        val sourceFile = getPonySourceFileForType(typeId + PonyTypeReferenceIndex.TYPE_SUFFIX, project) ?: return null
        val classDefs = PsiTreeUtil.collectElementsOfType(sourceFile, PonyClassDef::class.java)
        for (classDef in classDefs) {
            if (classDef.typeRef.typeId.text == typeId) {
                return classDef.typeRef
            }
        }

        return null
    }

    fun resolveMethodReference(refId: String, project: Project): PonyMemberRef? {
        val sourceFile = ponySourceFileForMember(refId + PonyMemberReferenceIndex.METHOD_SUFFIX, project) ?: return null
        val methods = PsiTreeUtil.collectElementsOfType(sourceFile, PonyMethod::class.java)

        return methods.firstOrNull { it.memberRef.id.text == refId }?.memberRef
    }

    fun resolveFieldReference(refId: String, project: Project): PonyMemberRef? {
        val sourceFile = ponySourceFileForMember(refId + PonyMemberReferenceIndex.FIELD_SUFFIX, project) ?: return null
        val fields = PsiTreeUtil.collectElementsOfType(sourceFile, PonyField::class.java)

        return fields.firstOrNull { it.memberRef.id.text == refId }?.memberRef
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

    fun resolveMembersInFile(element: PsiElement, key: String): PsiElement? {
        val privateFields = findAllInFile<PonyField>(element.containingFile)
        val fieldId = privateFields.firstOrNull { it.memberRef.id.text == key }?.memberRef
        if (fieldId != null && !memberCallExists(element)) {
            return fieldId
        }

        val privateMethods = findAllInFile<PonyMethod>(element.containingFile)
        val methodId = privateMethods.firstOrNull { it.memberRef.id.text == key }?.memberRef
        if (methodId != null) {
            return methodId
        }

        val useStatements = findAllInFile<PonyUsestmt>(element.containingFile)
        val useStmtId = useStatements.firstOrNull { it.id?.text == key}?.id
        if (useStmtId != null) {
            return useStmtId
        }

        return fieldId
    }

    private fun memberCallExists(element: PsiElement): Boolean {
        val atom = PsiTreeUtil.getContextOfType(element, PonyAtom::class.java)
        return PsiTreeUtil.getNextSiblingOfType(atom, PonyPostfixelem::class.java)?.call != null
    }

    inline fun <reified T: PsiElement> findAllInFile(file: PsiFile) : List<T> {
        val result = ArrayList<T>()
        result.addAll(PsiTreeUtil.findChildrenOfType(file, T::class.java))

        return result
    }

    private inline fun <reified T : PsiElement> findAllInDirectory(
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

    private inline fun <reified T : PsiElement> findAllElementsOfTypeInProject(project: Project): List<T> {
        val results = ArrayList<T>()
        val virtualFiles = FileTypeIndex.getFiles(PonyFileType.INSTANCE, GlobalSearchScope.allScope(project))
        for (virtualFile in virtualFiles) {
            val ponyFile: PonyFile = PsiManager.getInstance(project).findFile(virtualFile!!) as? PonyFile ?: continue
            results.addAll(PsiTreeUtil.collectElementsOfType(ponyFile, T::class.java))
        }
        return results
    }

}