package com.bizyback.ding.listeners

import com.bizyback.ding.settings.DingSettings
import com.intellij.openapi.components.service
import org.jetbrains.plugins.notebooks.visualization.r.inlays.components.DarkModeNotifier

/**
 *
 * @project  ding
 * @author   mambo
 * @email    mambobryan@gmail.com
 * @date     Fri 17 November 2023
 * @time     4:31 pm
 *
 */
class DingDarkModeListener : DarkModeNotifier {

    private val setting = service<DingSettings>()

    override fun onDarkModeChanged(isEnabled: Boolean) {
        setting.isDarkModeEnabled = isEnabled
    }
}