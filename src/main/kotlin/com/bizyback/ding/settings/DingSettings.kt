package com.bizyback.ding.settings

import com.bizyback.ding.utils.ring.*
import com.intellij.configurationStore.clearBindingCache
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
        TUTORIAL_SHOWN("tutorialShown"),
        TUTORIAL_DINGED("tutorialDinged"),
        START("start"),
        START_ENABLED("start_enabled"),
        SUCCESS("success"),
        SUCCESS_ENABLED("success_enabled"),
        FAILURE("failure"),
        CANCELLED("cancelled"), ;

        override fun toString() = key
    }

    var tutorialShown = false
    var tutorialShook = false

    var startEnabled = true
    var startTone: Tone = StartTone.Begin

    var successEnabled = true
    var successTone: Tone = SuccessTone.Victory

    init {
        clearBindingCache()
    }

    override fun getState() = Element(KEY.ROOT.toString()).apply {
        setAttribute(KEY.TUTORIAL_SHOWN.toString(), tutorialShown.toString())
        setAttribute(KEY.TUTORIAL_DINGED.toString(), tutorialShook.toString())
        // build start ding settings
        setAttribute(KEY.START_ENABLED.toString(), startEnabled.toString())
        setAttribute(KEY.START.toString(), startTone.source)
        // build success ding settings
        setAttribute(KEY.SUCCESS_ENABLED.toString(), successEnabled.toString())
        setAttribute(KEY.SUCCESS.toString(), successTone.source)
    }

    override fun loadState(element: Element) {
        element.apply {
            getAttributeValue(KEY.TUTORIAL_SHOWN.toString())?.let {
                tutorialShown = it.toBoolean()
            }
            getAttributeValue(KEY.TUTORIAL_DINGED.toString())?.let {
                tutorialShook = it.toBoolean()
            }
            getAttributeValue(KEY.START_ENABLED.toString())?.let {
                startEnabled = it.toBoolean()
            }
            getAttributeValue(KEY.START.toString())?.let {
                startTone = it.startTone
            }
            getAttributeValue(KEY.SUCCESS_ENABLED.toString())?.let {
                successEnabled = it.toBoolean()
            }
            getAttributeValue(KEY.SUCCESS.toString())?.let {
                successTone = it.successTone
            }
        }
    }

}