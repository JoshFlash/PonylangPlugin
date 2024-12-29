package com.github.joshflash.ponylangplugin.services

import com.intellij.openapi.components.Service
import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.openapi.project.Project
import com.github.joshflash.ponylangplugin.PonylangPluginBundle

@Service(Service.Level.PROJECT)
class PonylangProjectService(project: Project) {

    init {
        thisLogger().info(PonylangPluginBundle.message("projectService", project.name))
    }

    fun getExpectedVersionForCorralTool() = "2.0"
}
