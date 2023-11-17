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
sealed class StartTone(val value: String) : Tone(source = value) {

    data object Begin : StartTone(value = "begin")
    data object Dawn : StartTone(value = "dawn")
    data object Inception : StartTone(value = "inception")
    data object Genesis : StartTone(value = "genesis")

}

enum class StartToneKey {
    begin, dawn, inception, genesis;

    companion object {
        fun from(value: String) = StartToneKey.valueOf(value)
    }

    val tone: Tone
        get() = when (this) {
            begin -> StartTone.Begin
            dawn -> StartTone.Dawn
            inception -> StartTone.Inception
            genesis -> StartTone.Genesis
        }

}

val String.startToneKey
    get() = StartToneKey.from(this)

