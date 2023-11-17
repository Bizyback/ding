package com.bizyback.ding.utils.tones

import com.bizyback.ding.utils.Tone

/**
 *
 * @project  ding
 * @author   mambo
 * @email    mambobryan@gmail.com
 * @date     Thu 16 November 2023
 * @time     2:31 pm
 *
 */
sealed class SuccessTone(value: String) : Tone(source = value) {

    data object Victory : StartTone(value = "victory")
    data object Triumph : StartTone(value = "triumph")
    data object Eureka : StartTone(value = "eureka")
    data object Favor : StartTone(value = "favor")

}

enum class SuccessToneKey {
    victory, triumph, eureka, favor;

    companion object {
        fun from(value: String) = try{ SuccessToneKey.valueOf(value) } catch (e: Exception) {victory}
    }

    val tone: Tone
        get() = when (this) {
            victory -> SuccessTone.Victory
            triumph -> SuccessTone.Triumph
            eureka -> SuccessTone.Eureka
            favor -> SuccessTone.Favor
        }
}

val String.successToneKey
    get() = SuccessToneKey.from(this)