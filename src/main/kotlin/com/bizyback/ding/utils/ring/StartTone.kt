package com.bizyback.ding.utils.ring

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
    data object Inception : StartTone(value = "begin")
    data object Genesis : StartTone(value = "dawn")

}

enum class StartKey {
    begin, dawn, inception, genesis;

    companion object {
        fun from(value: String) = StartKey.valueOf(value)
    }

    val tone: Tone
        get() = when (this) {
            begin -> StartTone.Begin
            dawn -> StartTone.Dawn
            inception -> StartTone.Inception
            genesis -> StartTone.Genesis
        }

}

val String.startTone
    get() = when (StartKey.from(this)) {
        StartKey.begin -> StartTone.Begin
        StartKey.dawn -> StartTone.Dawn
        StartKey.inception -> StartTone.Inception
        StartKey.genesis -> StartTone.Genesis
    }

