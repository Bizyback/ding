package com.bizyback.ding.utils.tones

import com.bizyback.ding.utils.Tone

/**
 *
 * @project  ding
 * @author   mambo
 * @email    mambobryan@gmail.com
 * @date     Thu 16 November 2023
 * @time     2:26 pm
 *
 */
sealed class TestingTone(val value: String) : Tone(source = value) {

    data object Pilot : TestingTone(value = "pilot")
    data object Probe : TestingTone(value = "probe")
    data object Analyse : TestingTone(value = "analyse")
    data object Assess : TestingTone(value = "assess")

}

enum class TestingToneKey {
    pilot, probe, analyse, assess;

    companion object {
        fun from(value: String) = TestingToneKey.valueOf(value)
    }

    val tone: Tone
        get() = when (this) {
            pilot -> TestingTone.Pilot
            probe -> TestingTone.Probe
            analyse -> TestingTone.Analyse
            assess -> TestingTone.Assess
        }

}

val String.testingToneKey
    get() = TestingToneKey.from(this)
