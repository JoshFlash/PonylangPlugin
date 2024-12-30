package com.github.joshflash.ponylangplugin.services

import com.intellij.openapi.components.Service
import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.openapi.project.Project
import com.github.joshflash.ponylangplugin.PonylangPluginBundle
import com.github.joshflash.ponylangplugin.language.PonyLanguage
import com.github.joshflash.ponylangplugin.language.psi.PonyClassDef
import com.github.joshflash.ponylangplugin.language.psi.PonyFile
import com.github.joshflash.ponylangplugin.listeners.PonylangStartupActivity
import com.github.joshflash.ponylangplugin.ponysourcelist.PonyFileList
import com.intellij.openapi.application.ApplicationManager
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.indexing.memory.InMemoryIndexStorage
import com.intellij.util.io.EnumeratorStringDescriptor

@Service(Service.Level.PROJECT)
class PonylangProjectService(project: Project) {

    val stdLibTypeIndexStorage: InMemoryIndexStorage<String, Void>

    init {
        thisLogger().info(PonylangPluginBundle.message("projectService", project.name))
        stdLibTypeIndexStorage = InMemoryIndexStorage(
            EnumeratorStringDescriptor.INSTANCE
        )
        createPonyStdLibIndex(project)
    }

    private fun createPonyStdLibIndex(project: Project) {
        val ponyFiles = PonyFileList.files
        for (ponyFileName in ponyFiles) {
            val resourcePath = "/pony-source/$ponyFileName"
            PonylangStartupActivity::class.java.getResourceAsStream(resourcePath)?.use { inputStream ->
                val content = inputStream.bufferedReader().use { it.readText() }
                processPonyFile(content, project, ponyFileName)
            }
        }
    }

    private fun processPonyFile(content: String, project: Project, fileName: String) {
        val ponyFile = parsePonyFile(content, project, fileName) ?: return
        ApplicationManager.getApplication().runReadAction {
            val classDefs = PsiTreeUtil.collectElementsOfType(ponyFile, PonyClassDef::class.java)
            for (classDef in classDefs) {
                stdLibTypeIndexStorage.addValue(classDef.typeRef.typeId.text, ponyFile.hashCode(), null)
            }
        }
    }

    private fun parsePonyFile(content: String, project: Project, fileName: String): PonyFile? {
        val psiFile = PsiFileFactory.getInstance(project).createFileFromText(
            fileName,
            PonyLanguage,
            content
        )
        return psiFile as? PonyFile
    }

    fun getExpectedVersionForCorralTool() = "2.0"
}