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
sealed class TestsFailedTone(val value: String) : Tone(source = value) {

    data object Stall : TestsFailedTone(value = "stall")
    data object Faulty : TestsFailedTone(value = "faulty")
    data object Crash : TestsFailedTone(value = "crash")
    data object Wither : TestsFailedTone(value = "wither")

}

enum class TestsFailedToneKey {
    stall, faulty, crash, wither;

    companion object {
        fun from(value: String) = TestsFailedToneKey.valueOf(value)
    }

    val tone: Tone
        get() = when (this) {
            stall -> TestsFailedTone.Stall
            faulty -> TestsFailedTone.Faulty
            crash -> TestsFailedTone.Crash
            wither -> TestsFailedTone.Wither
        }

}

val String.testFailedToneKey
    get() = TestsFailedToneKey.from(this)
