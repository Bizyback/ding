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
sealed class FailedTone(val value: String) : Tone(source = value) {

    data object Sink : FailedTone(value = "sink")
    data object Wane : FailedTone(value = "wane")
    data object Fade : FailedTone(value = "fade")
    data object Dim : FailedTone(value = "dim")

}

enum class FailedToneKey {
    sink, wane, fade, dim;

    companion object {
        fun from(value: String) = FailedToneKey.valueOf(value)
    }

    val tone: Tone
        get() = when (this) {
            sink -> FailedTone.Sink
            wane -> FailedTone.Wane
            fade -> FailedTone.Fade
            dim -> FailedTone.Dim
        }

}

val String.failedToneKey
    get() = FailedToneKey.from(this)
