package com.bizyback.ding.listeners

import com.bizyback.ding.settings.DingSettings
import com.bizyback.ding.utils.ring.ring
import com.intellij.build.BuildProgressListener
import com.intellij.build.events.BuildEvent
import com.intellij.openapi.components.service
import com.intellij.openapi.diagnostic.thisLogger
import org.apache.tools.ant.BuildListener

/**
 *
 * @project  ding
 * @author   mambo
 * @email    mambobryan@gmail.com
 * @date     Thu 16 November 2023
 * @time     10:45 am
 *
 */
internal class DingBuildListener : BuildListener, BuildProgressListener {

    private val settings = service<DingSettings>()

    override fun onEvent(buildId: Any, event: BuildEvent) {
        thisLogger().warn("Ding -> build is in progress")
    }

    override fun buildStarted(event: org.apache.tools.ant.BuildEvent?) {
        if (!settings.startEnabled) return
        ring(settings.startTone)
        thisLogger().warn("Ding -> build started")
    }

    override fun buildFinished(event: org.apache.tools.ant.BuildEvent?) {
        thisLogger().warn("Ding -> build finished")
    }

    private fun doNothing() = Unit

    override fun targetStarted(event: org.apache.tools.ant.BuildEvent?) {
        doNothing()
    }

    override fun targetFinished(event: org.apache.tools.ant.BuildEvent?) {
        doNothing()
    }

    override fun taskStarted(event: org.apache.tools.ant.BuildEvent?) {
        doNothing()
    }

    override fun taskFinished(event: org.apache.tools.ant.BuildEvent?) {
        doNothing()
    }

    override fun messageLogged(event: org.apache.tools.ant.BuildEvent?) {
        doNothing()
    }

}