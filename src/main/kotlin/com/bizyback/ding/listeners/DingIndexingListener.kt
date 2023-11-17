package com.bizyback.ding.listeners

import com.bizyback.ding.settings.DingSettings
import com.bizyback.ding.utils.ring
import com.intellij.openapi.components.service
import com.intellij.util.indexing.diagnostic.ProjectIndexingHistory
import com.intellij.util.indexing.diagnostic.ProjectIndexingHistoryListener

/**
 *
 * @project  ding
 * @author   mambo
 * @email    mambobryan@gmail.com
 * @date     Fri 17 November 2023
 * @time     12:29 am
 *
 */
class DingIndexingListener : ProjectIndexingHistoryListener {

    private val settings = service<DingSettings>()

    override fun onFinishedIndexing(projectIndexingHistory: ProjectIndexingHistory) {
        if (settings.indexingEnabled) ring(settings.indexingTone)
    }

}