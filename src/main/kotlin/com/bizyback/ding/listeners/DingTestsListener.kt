package com.bizyback.ding.listeners

import com.bizyback.ding.settings.DingSettings
import com.bizyback.ding.utils.ring
import com.intellij.execution.testframework.sm.runner.SMTRunnerEventsListener
import com.intellij.execution.testframework.sm.runner.SMTestProxy
import com.intellij.openapi.components.service

/**
 *
 * @project  ding
 * @author   mambo
 * @email    mambobryan@gmail.com
 * @date     Fri 17 November 2023
 * @time     12:52 am
 *
 */
class DingTestsListener : SMTRunnerEventsListener {

    private val settings = service<DingSettings>()

    private fun doNothing() = Unit

    override fun onTestingStarted(testsRoot: SMTestProxy.SMRootTestProxy) {
        doNothing()
    }

    override fun onTestingFinished(testsRoot: SMTestProxy.SMRootTestProxy) {
        doNothing()
    }

    override fun onTestsCountInSuite(count: Int) {
        doNothing()
    }

    override fun onTestStarted(test: SMTestProxy) {
        doNothing()
    }

    override fun onTestFinished(test: SMTestProxy) {
        doNothing()
    }

    override fun onTestFailed(test: SMTestProxy) {
        doNothing()
    }

    override fun onTestIgnored(test: SMTestProxy) {
        doNothing()
    }

    override fun onSuiteFinished(suite: SMTestProxy) {
        if (settings.testingEnabled) ring(settings.testingTone)
    }

    override fun onSuiteStarted(suite: SMTestProxy) {
        doNothing()
    }

    override fun onCustomProgressTestsCategory(categoryName: String?, testCount: Int) {
        doNothing()
    }

    override fun onCustomProgressTestStarted() {
        doNothing()
    }

    override fun onCustomProgressTestFailed() {
        doNothing()
    }

    override fun onCustomProgressTestFinished() {
        doNothing()
    }

    override fun onSuiteTreeNodeAdded(testProxy: SMTestProxy?) {
        doNothing()
    }

    override fun onSuiteTreeStarted(suite: SMTestProxy?) {
        doNothing()
    }
}