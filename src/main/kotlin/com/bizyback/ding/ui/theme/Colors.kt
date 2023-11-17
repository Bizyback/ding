package com.bizyback.ding.ui.theme

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.graphics.Color

/**
 *
 * @project  ding
 * @author   mambo
 * @email    mambobryan@gmail.com
 * @date     Thu 16 November 2023
 * @time     5:28 pm
 *
 */

/**
 * APP THEME COLORS
 */
internal val white = Color(0xFFFFFFFF)
internal val black = Color(0xFF000000)

internal val gray50 = Color(0xFFFAFAFA)
internal val gray100 = Color(0xFFF5F5F5)
internal val gray200 = Color(0xFFEEEEEE)
internal val gray300 = Color(0xFFE0E0E0)
internal val gray400 = Color(0xFFBDBDBD)
internal val gray500 = Color(0xFF9E9E9E)
internal val gray600 = Color(0xFF757575)
internal val gray700 = Color(0xFF616161)
internal val gray800 = Color(0xFF424242)
internal val gray900 = Color(0xFF212121)

internal val primary50 = Color(0xFFe6ecfd)
internal val primary100 = Color(0xFFb5c6fa)
internal val primary200 = Color(0xFF84a1f7)
internal val primary300 = Color(0xFF527bf3)
internal val primary400 = Color(0xFF2155f0)
internal val primary500 = Color(0xFF073bd6)
internal val primary600 = Color(0xFF062ea7)
internal val primary700 = Color(0xFF042177)
internal val primary800 = Color(0xFF021447)
internal val primary900 = Color(0xFF010718)

internal val secondary50 = Color(0xFFfeefe6)
internal val secondary100 = Color(0xFFfdceb3)
internal val secondary200 = Color(0xFFfbae81)
internal val secondary300 = Color(0xFFf98d4f)
internal val secondary400 = Color(0xFFf86c1c)
internal val secondary500 = Color(0xFFde5303)
internal val secondary600 = Color(0xFFad4002)
internal val secondary700 = Color(0xFF7c2e02)
internal val secondary800 = Color(0xFF4a1c01)
internal val secondary900 = Color(0xFF190900)

/**
 * MATERIAL THEME COLORS
 */

internal val Primary = primary500
internal val PrimaryDark = secondary300
internal val OnPrimary = white
internal val OnPrimaryDark = black

internal val Secondary = primary500
internal val SecondaryDark = secondary300
internal val OnSecondary = white
internal val OnSecondaryDark = black

internal val Background = gray200
internal val BackgroundDark = Color(0xFF2B2A2B)
internal val OnBackground = gray900
internal val OnBackgroundDark = white

internal val Surface = Color(0xFFF2F2F2)
internal val SurfaceDark = Color(0xFF3C3F41)
internal val OnSurface = black
internal val OnSurfaceDark = white

internal val Error = Color(0xFFd91a1a)
internal val ErrorDark = Color(0xFFe66666)
internal val OnError = white
internal val OnErrorDark = black

internal val Success = Color(0xFF23CE6B)
internal val SuccessDark = Color(0xFF3FDE82)
internal val OnSuccess = black
internal val OnSuccessDark = black

val Colors.success
    get() = if (isLight) Success else SuccessDark

val Colors.onSuccess
    get() = if (isLight) OnSuccess else OnSuccessDark