package com.bizyback.ding.listeners

import com.bizyback.ding.settings.DingSettings
import com.bizyback.ding.utils.ring
import com.intellij.openapi.components.service
import com.intellij.util.indexing.diagnostic.ProjectDumbIndexingHistory
import com.intellij.util.indexing.diagnostic.ProjectIndexingActivityHistoryListener

/**
 *
 * @project  ding
 * @author   mambo
 * @email    mambobryan@gmail.com
 * @date     Fri 17 November 2023
 * @time     12:29 am
 *
 */
class DingIndexingListener : ProjectIndexingActivityHistoryListener {

    private val settings = service<DingSettings>()

    override fun onFinishedDumbIndexing(history: ProjectDumbIndexingHistory) {
        if (settings.indexingEnabled) ring(settings.indexingTone)
    }

}
