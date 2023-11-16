package com.bizyback.ding.utils.ring

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
    data object Eureka : StartTone(value = "victory")
    data object Favor : StartTone(value = "triumph")

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

val String.successTone
    get() = when (SuccessToneKey.from(this)) {
        SuccessToneKey.victory -> SuccessTone.Victory
        SuccessToneKey.triumph -> SuccessTone.Triumph
        SuccessToneKey.eureka -> SuccessTone.Eureka
        SuccessToneKey.favor -> SuccessTone.Favor
    }