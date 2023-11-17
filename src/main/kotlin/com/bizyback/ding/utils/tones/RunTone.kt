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
sealed class RunTone(val value: String) : Tone(source = value) {

    data object Dart : RunTone(value = "dart")
    data object Bolt : RunTone(value = "bolt")
    data object Rush : RunTone(value = "rush")
    data object Dash : RunTone(value = "dash")

}

enum class RunToneKey {
    dart, bolt, rush, dash;

    companion object {
        fun from(value: String) = RunToneKey.valueOf(value)
    }

    val tone: Tone
        get() = when (this) {
            dart -> RunTone.Dart
            bolt -> RunTone.Bolt
            rush -> RunTone.Rush
            dash -> RunTone.Dash
        }

}

val String.runToneKey
    get() = RunToneKey.from(this)
