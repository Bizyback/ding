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
sealed class TestsPassedTone(val value: String) : Tone(source = value) {

    data object Pilot : TestsPassedTone(value = "pilot")
    data object Probe : TestsPassedTone(value = "probe")
    data object Analyse : TestsPassedTone(value = "analyse")
    data object Assess : TestsPassedTone(value = "assess")

}

enum class TestingToneKey {
    pilot, probe, analyse, assess;

    companion object {
        fun from(value: String) = TestingToneKey.valueOf(value)
    }

    val tone: Tone
        get() = when (this) {
            pilot -> TestsPassedTone.Pilot
            probe -> TestsPassedTone.Probe
            analyse -> TestsPassedTone.Analyse
            assess -> TestsPassedTone.Assess
        }

}

val String.testPassedToneKey
    get() = TestingToneKey.from(this)
