package com.bizyback.ding.utils.ring

import com.intellij.util.ui.UIUtil

/**
 *
 * @project  ding
 * @author   mambo
 * @email    mambobryan@gmail.com
 * @date     Thu 16 November 2023
 * @time     12:54 pm
 *
 */

abstract class Tone(val source: String)

/**
 * plays tone.
 */
fun ring(tone: Tone) {
    UIUtil.playSoundFromResource("/sound/${tone.source}.wav")
}

