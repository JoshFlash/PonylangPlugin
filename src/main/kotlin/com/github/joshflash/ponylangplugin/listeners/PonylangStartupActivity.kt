package com.github.joshflash.ponylangplugin.listeners

import com.github.joshflash.ponylangplugin.language.indexing.PonyTypeReferenceIndex
import com.github.joshflash.ponylangplugin.ponysourcelist.PonyFileList
import com.intellij.openapi.project.DumbService
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManager
import com.intellij.openapi.startup.ProjectActivity
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.util.indexing.FileBasedIndex
import java.io.File
import java.io.InputStream

class PonylangStartupActivity : ProjectActivity {
    override suspend fun execute(project: Project) {
        addPonyStdLibs(project)
        indexPonySourceFiles(project)
    }

    private fun indexPonySourceFiles(project: Project) {
        val openProjects = ProjectManager.getInstance().openProjects
        if (openProjects.isEmpty()) return

        for (proj in openProjects) {
            if (proj != project) continue
            DumbService.getInstance(proj).smartInvokeLater {
                FileBasedIndex.getInstance().requestRebuild(PonyTypeReferenceIndex.INDEX_ID)
            }
        }
    }

    private fun addPonyStdLibs(project: Project) {
        val projectBasePath = project.basePath ?: return
        val ponyLibDir = File(projectBasePath, ".pony-libs")
        ponyLibDir.mkdirs()
        copyInitialPonyFiles(ponyLibDir)
        println("Finished Copying Pony Std Lib")

        val vDir = LocalFileSystem.getInstance().refreshAndFindFileByIoFile(ponyLibDir)
        vDir?.refresh(/* asynchronous = */ false, /* recursive = */ true)
    }

    private fun copyInitialPonyFiles(destDir: File) {
        val ponyFiles = PonyFileList.files
        for (ponyFileName in ponyFiles) {
            val resourcePath = "/pony-source/$ponyFileName"
            PonylangStartupActivity::class.java.getResourceAsStream(resourcePath)?.use { inputStream ->
                val outFile = File(destDir, ponyFileName)
                outFile.parentFile.mkdirs()
                inputStream.copyTo(outFile)
            }
        }
    }
}

private fun InputStream.copyTo(file: File) {
    file.outputStream().use { output ->
        this.copyTo(output)
    }
}
