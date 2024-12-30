package com.github.joshflash.ponylangplugin.listeners

import com.github.joshflash.ponylangplugin.language.indexing.PonyTypeReferenceIndex
import com.intellij.openapi.project.DumbService
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManager
import com.intellij.openapi.startup.ProjectActivity
import com.intellij.util.indexing.FileBasedIndex


class PonylangStartupActivity : ProjectActivity {

    override suspend fun execute(project: Project) {
        indexProjectSourceFiles(project)
    }

    private fun indexProjectSourceFiles(project: Project) {
        val openProjects = ProjectManager.getInstance().openProjects
        if (openProjects.isEmpty()) return

        for (proj in openProjects) {
            if (proj != project) continue
            DumbService.getInstance(proj).smartInvokeLater {
                FileBasedIndex.getInstance().requestRebuild(PonyTypeReferenceIndex.INDEX_ID)
            }
        }
    }
}
