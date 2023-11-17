package com.bizyback.ding.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

/**
 *
 * @project  ding
 * @author   mambo
 * @email    mambobryan@gmail.com
 * @date     Thu 16 November 2023
 * @time     5:24 pm
 *
 */

@Composable
fun DingTheme(
    isDarkModeEnabled: Boolean,
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colors = getColors(isDarkModeEnabled = isDarkModeEnabled),
        shapes = DingShapes,
        typography = DingTypography,
        content = content
    )
}