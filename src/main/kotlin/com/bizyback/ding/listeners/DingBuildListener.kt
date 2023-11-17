package com.bizyback.ding.listeners

import com.android.tools.idea.gradle.project.build.BuildContext
import com.android.tools.idea.gradle.project.build.BuildStatus
import com.android.tools.idea.gradle.project.build.GradleBuildListener
import com.bizyback.ding.settings.DingSettings
import com.bizyback.ding.utils.ring
import com.intellij.openapi.components.service

/**
 *
 * @project  ding
 * @author   mambo
 * @email    mambobryan@gmail.com
 * @date     Thu 16 November 2023
 * @time     10:45 am
 *
 */
internal class DingBuildListener : GradleBuildListener {

    private val settings = service<DingSettings>()

    override fun buildStarted(context: BuildContext) {
        if (settings.startEnabled) ring(settings.startTone)
    }

    override fun buildFinished(status: BuildStatus, context: BuildContext?) {
        when (status) {
            BuildStatus.SUCCESS -> if (settings.successEnabled) ring(settings.successTone)
            BuildStatus.FAILED -> if (settings.failedEnabled) ring(settings.failedTone)
            BuildStatus.CANCELED -> if (settings.canceledEnabled) ring(settings.canceledTone)
        }
    }

}