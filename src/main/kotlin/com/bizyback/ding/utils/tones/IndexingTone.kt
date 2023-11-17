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
sealed class IndexingTone(val value: String) : Tone(source = value) {

    data object Classify : IndexingTone(value = "classify")
    data object Inspect : IndexingTone(value = "inspect")
    data object Catalog : IndexingTone(value = "catalog")
    data object Diagnose : IndexingTone(value = "diagnose")

}

enum class IndexingToneKey {
    classify, inspect, catalog, diagnose;

    companion object {
        fun from(value: String) = IndexingToneKey.valueOf(value)
    }

    val tone: Tone
        get() = when (this) {
            classify -> IndexingTone.Classify
            inspect -> IndexingTone.Inspect
            catalog -> IndexingTone.Catalog
            diagnose -> IndexingTone.Diagnose
        }

}

val String.indexingToneKey
    get() = IndexingToneKey.from(this)
