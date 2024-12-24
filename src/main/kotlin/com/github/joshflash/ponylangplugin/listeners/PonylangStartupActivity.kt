package com.github.joshflash.ponylangplugin.listeners

import com.github.joshflash.ponylangplugin.ponysourcelist.PonyFileList
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.ProjectActivity
import com.intellij.openapi.vfs.LocalFileSystem
import java.io.File
import java.io.InputStream

class PonylangStartupActivity : ProjectActivity {
    override suspend fun execute(project: Project) {
        val projectBasePath = project.basePath ?: return

        val ponyLibDir = File(projectBasePath, ".pony-libs")
        ponyLibDir.mkdirs()
        copyInitialPonyFiles(ponyLibDir)
        println("Finished Copying")

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
    println("attempting to copy " + file.name)
    file.outputStream().use { output ->
        this.copyTo(output)
    }
}
