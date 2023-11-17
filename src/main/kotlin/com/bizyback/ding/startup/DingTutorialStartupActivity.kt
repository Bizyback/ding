package com.bizyback.ding.startup

import com.bizyback.ding.DingBundle.message
import com.bizyback.ding.dialog.showDingConfigurationDialog
import com.bizyback.ding.settings.DingSettings
import com.bizyback.ding.utils.notify
import com.bizyback.ding.utils.ring
import com.intellij.ide.plugins.newui.ListPluginComponent.ButtonAnAction
import com.intellij.notification.NotificationType
import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.StartupActivity

/**
 *
 * @project  ding
 * @author   mambo
 * @email    mambobryan@gmail.com
 * @date     Thu 16 November 2023
 * @time     11:29 am
 *
 */
class DingTutorialStartupActivity : StartupActivity {

    private val settings = service<DingSettings>()

    private fun creatAction(value: String, action: () -> Unit) = ButtonAnAction.create(message(value)) { action() }

    override fun runActivity(project: Project) {
        if (settings.notificationShown) return
        settings.notificationShown = true
        with(project) {
            notify(
                message("notification.welcome.title"),
                message("notification.welcome.description"),
                NotificationType.INFORMATION,
            ){
                addAction(creatAction("notification.action.ding") { ring(settings.startTone) })
                addAction(creatAction("notification.action.configure") { showDingConfigurationDialog() })
            }
        }
        settings.notificationShown = false
    }

}