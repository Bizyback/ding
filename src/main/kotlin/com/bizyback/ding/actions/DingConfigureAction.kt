package com.bizyback.ding.actions

import com.bizyback.ding.dialog.showDingConfigurationDialog
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

/**
 *
 * @project  ding
 * @author   mambo
 * @email    mambobryan@gmail.com
 * @date     Fri 17 November 2023
 * @time     6:35 pm
 *
 */
class DingConfigureAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        e.project?.showDingConfigurationDialog()
    }
}