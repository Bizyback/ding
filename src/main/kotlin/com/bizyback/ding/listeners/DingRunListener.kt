package com.bizyback.ding.listeners

import com.bizyback.ding.settings.DingSettings
import com.bizyback.ding.utils.ring
import com.intellij.execution.ExecutionListener
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.components.service

/**
 *
 * @project  ding
 * @author   mambo
 * @email    mambobryan@gmail.com
 * @date     Thu 16 November 2023
 * @time     10:59 am
 *
 */
internal class DingRunListener : ExecutionListener {

    private val settings = service<DingSettings>()

    override fun processTerminated(
        executorId: String,
        env: ExecutionEnvironment,
        handler: ProcessHandler,
        exitCode: Int
    ) {
        ring(settings.successTone)
    }

}