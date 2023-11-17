package com.bizyback.ding.settings

import com.bizyback.ding.utils.Tone
import com.bizyback.ding.utils.tones.*
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import org.jdom.Element

/**
 *
 * @project  ding
 * @author   mambo
 * @email    mambobryan@gmail.com
 * @date     Thu 16 November 2023
 * @time     11:25 am
 *
 */

@State(name = "DingSettings", storages = [Storage("ding.xml")])
class DingSettings : PersistentStateComponent<Element?> {

    enum class KEY(private val key: String) {
        ROOT("IgnoreSettings"),
        NOTIFICATION_SHOWN("notificationShown"),
        TUTORIAL_DINGED("tutorialDinged"),
        DARK_MODE_ENABLED("dark_mode_enabled"),
        START("start"),
        START_ENABLED("start_enabled"),
        SUCCESS("success"),
        SUCCESS_ENABLED("success_enabled"),
        FAILURE("failure"),
        FAILURE_ENABLED("failure_enabled"),
        CANCEL("CANCEL"),
        CANCEL_ENABLED("cancel_enabled"),
        TESTS_PASSED("testing"),
        TESTS_PASSED_ENABLED("testing_enabled"),
        TESTS_FAILED("tests_failed"),
        TESTS_FAILED_ENABLED("tests_failed_enabled"),
        INDEXING("indexing"),
        INDEXING_ENABLED("indexing_enabled"),
        RUN("run"),
        RUN_ENABLED("run_enabled"),
        ;

        override fun toString() = key

    }

    var notificationShown = false

    var isDarkModeEnabled = false

    var runEnabled = true
    var runTone: Tone = RunTone.Bolt

    var indexingEnabled = true
    var indexingTone: Tone = IndexingTone.Diagnose

    var testsPassedEnabled = true
    var testsPassedTone: Tone = TestsPassedTone.Analyse

    var testsFailedEnabled = true
    var testsFailedTone: Tone = TestsFailedTone.Stall

    var startEnabled = true
    var startTone: Tone = StartTone.Begin

    var successEnabled = true
    var successTone: Tone = SuccessTone.Eureka

    var failedEnabled = true
    var failedTone: Tone = FailedTone.Dim

    var canceledEnabled = true
    var canceledTone: Tone = CanceledTone.Axe

    override fun getState() = Element(KEY.ROOT.toString()).apply {
        setAttribute(KEY.NOTIFICATION_SHOWN.toString(), notificationShown.toString())
        setAttribute(KEY.DARK_MODE_ENABLED.toString(), isDarkModeEnabled.toString())
        // run ding settings
        setAttribute(KEY.RUN_ENABLED.toString(), runEnabled.toString())
        setAttribute(KEY.RUN.toString(), runTone.source)
        // indexing ding settings
        setAttribute(KEY.INDEXING_ENABLED.toString(), indexingEnabled.toString())
        setAttribute(KEY.INDEXING.toString(), indexingTone.source)
        // tests passed ding settings
        setAttribute(KEY.TESTS_PASSED_ENABLED.toString(), testsPassedEnabled.toString())
        setAttribute(KEY.TESTS_PASSED.toString(), testsPassedTone.source)
        // tests failed ding settings
        setAttribute(KEY.TESTS_FAILED_ENABLED.toString(), testsFailedEnabled.toString())
        setAttribute(KEY.TESTS_FAILED.toString(), testsFailedTone.source)
        // build start ding settings
        setAttribute(KEY.START_ENABLED.toString(), startEnabled.toString())
        setAttribute(KEY.START.toString(), startTone.source)
        // build success ding settings
        setAttribute(KEY.SUCCESS_ENABLED.toString(), successEnabled.toString())
        setAttribute(KEY.SUCCESS.toString(), successTone.source)
        // build failure ding settings
        setAttribute(KEY.FAILURE_ENABLED.toString(), failedEnabled.toString())
        setAttribute(KEY.FAILURE.toString(), failedTone.source)
        // build canceled ding settings
        setAttribute(KEY.CANCEL_ENABLED.toString(), canceledEnabled.toString())
        setAttribute(KEY.CANCEL.toString(), canceledTone.source)
    }

    override fun loadState(element: Element) {
        element.apply {
            getAttributeValue(KEY.NOTIFICATION_SHOWN.toString())?.let { notificationShown = it.toBoolean() }
            getAttributeValue(KEY.DARK_MODE_ENABLED.toString())?.let { isDarkModeEnabled = it.toBoolean() }
            // run settings
            getAttributeValue(KEY.RUN_ENABLED.toString())?.let { runEnabled = it.toBoolean() }
            getAttributeValue(KEY.RUN.toString())?.let { runTone = it.runToneKey.tone }
            // indexing
            getAttributeValue(KEY.INDEXING_ENABLED.toString())?.let { indexingEnabled = it.toBoolean() }
            getAttributeValue(KEY.INDEXING.toString())?.let { indexingTone = it.indexingToneKey.tone }
            // tests passed
            getAttributeValue(KEY.TESTS_PASSED_ENABLED.toString())?.let { testsPassedEnabled = it.toBoolean() }
            getAttributeValue(KEY.TESTS_PASSED.toString())?.let { testsPassedTone = it.testPassedToneKey.tone }
            // tests failed
            getAttributeValue(KEY.TESTS_FAILED_ENABLED.toString())?.let { testsFailedEnabled = it.toBoolean() }
            getAttributeValue(KEY.TESTS_FAILED.toString())?.let { testsFailedTone = it.testFailedToneKey.tone }
            // build start
            getAttributeValue(KEY.START_ENABLED.toString())?.let { startEnabled = it.toBoolean() }
            getAttributeValue(KEY.START.toString())?.let { startTone = "begin".startToneKey.tone }
            // build succeeded
            getAttributeValue(KEY.SUCCESS_ENABLED.toString())?.let { successEnabled = it.toBoolean() }
            getAttributeValue(KEY.SUCCESS.toString())?.let { successTone = "eureka".successToneKey.tone }
            // build failure
            getAttributeValue(KEY.FAILURE_ENABLED.toString())?.let { failedEnabled = it.toBoolean() }
            getAttributeValue(KEY.FAILURE.toString())?.let { failedTone = it.failedToneKey.tone }
            // build cancel
            getAttributeValue(KEY.CANCEL_ENABLED.toString())?.let { canceledEnabled = it.toBoolean() }
            getAttributeValue(KEY.CANCEL.toString())?.let { canceledTone = it.canceledToneKey.tone }
        }
    }

}