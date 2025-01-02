package com.github.joshflash.ponylangplugin.toolWindow

import com.intellij.openapi.components.service
import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBPanel
import com.intellij.ui.content.ContentFactory
import com.github.joshflash.ponylangplugin.PonylangPluginBundle
import com.github.joshflash.ponylangplugin.services.PonylangProjectService
import javax.swing.JButton


class CorralToolWindowFactory : ToolWindowFactory {

    init {
        thisLogger().info("PonylangToolFactory initialized")
    }

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val myToolWindow = CorralToolWindow(toolWindow)
        val content = ContentFactory.getInstance().createContent(myToolWindow.getContent(), null, false)
        toolWindow.contentManager.addContent(content)
    }

    override fun shouldBeAvailable(project: Project) = true

    class CorralToolWindow(private val toolWindow: ToolWindow) {

        fun getContent() = JBPanel<JBPanel<*>>().apply {
            val label = JBLabel(PonylangPluginBundle.message("corralTodoLabel", "?"))
            val service = toolWindow.project.getService(PonylangProjectService::class.java)

            add(label)
            add(JButton(PonylangPluginBundle.message("TODO")).apply {
                addActionListener {
                    label.text = PonylangPluginBundle.message("corralTodoLabel", service.getExpectedVersionForCorralTool())
                }
            })
        }
    }
}
