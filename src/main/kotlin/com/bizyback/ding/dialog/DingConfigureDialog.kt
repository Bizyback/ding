package com.bizyback.ding.dialog

import androidx.compose.ui.awt.ComposePanel
import com.bizyback.ding.DingBundle.message
import com.bizyback.ding.settings.DingSettings
import com.bizyback.ding.ui.content.DingContent
import com.bizyback.ding.ui.theme.DingTheme
import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogWrapper
import com.intellij.util.ui.JBUI
import java.awt.BorderLayout
import java.awt.Dimension
import javax.swing.JComponent
import javax.swing.JPanel

/**
 *
 * @project  ding
 * @author   mambo
 * @email    mambobryan@gmail.com
 * @date     Thu 16 November 2023
 * @time     4:22 pm
 *
 */

fun Project.showDingConfigurationDialog() {
    DingConfigureDialog(this).show()
}

class DingConfigureDialog(
    project: Project
) : DialogWrapper(project, null, true, IdeModalityType.IDE, false) {

    private val settings = service<DingSettings>()

    init {
        super.init()
        title = message("notification.project")
        setSize(500, 500)
    }

    override fun createCenterPanel(): JComponent {
        val window = JPanel(BorderLayout())
        window.size = Dimension(500, 500)
        window.border = JBUI.Borders.empty()

        // create ComposePanel
        val composePanel = ComposePanel().also {
            setSize(500, 500)
            isResizable = false
        }

        // populate composable
        composePanel.setContent {
            DingTheme {
                DingContent(
                    settings = settings,
                    onDismissDialogClicked = {
                        if (isVisible or isShowing) close(1, true)
                    }
                )
            }
        }

        // add composePanel to window
        window.add(composePanel, BorderLayout.CENTER)
        return window
    }
}