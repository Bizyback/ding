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
sealed class CanceledTone(val value: String) : Tone(source = value) {

    data object Scrap : CanceledTone(value = "scrap")
    data object Drop : CanceledTone(value = "drop")
    data object Axe : CanceledTone(value = "axe")
    data object Nix : CanceledTone(value = "nix")

}

enum class CanceledToneKey {
    scrap, drop, axe, nix;

    companion object {
        fun from(value: String) = CanceledToneKey.valueOf(value)
    }

    val tone: Tone
        get() = when (this) {
            scrap -> CanceledTone.Scrap
            drop -> CanceledTone.Drop
            axe -> CanceledTone.Axe
            nix -> CanceledTone.Nix
        }

}

val String.canceledToneKey
    get() = CanceledToneKey.from(this)
