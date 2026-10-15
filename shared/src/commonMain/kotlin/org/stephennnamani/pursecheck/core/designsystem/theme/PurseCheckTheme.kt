package org.stephennnamani.pursecheck.core.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

private val LocalPurseCheckExtendedColors =
    staticCompositionLocalOf<PurseCheckExtendedColors> {
        error("PurseCheck extended colors have not been provided.")
    }

private val LocalPurseCheckIsDarkTheme =
    staticCompositionLocalOf { false }

@Composable
internal fun PurseCheckTheme(
    themeMode: ThemeMode = ThemeMode.System,
    content: @Composable () -> Unit
){
    val useDarkTheme = shouldUseDarkTheme(
        themeMode = themeMode,
        systemInDarkTheme = isSystemInDarkTheme()
    )

    val colorScheme =
        if (useDarkTheme) {
            purseCheckDarkColorScheme
        } else {
            purseCheckLightColorScheme
        }

    val extendedColors =
        if (useDarkTheme) {
            purseCheckDarkExtendedColors
        } else {
            purseCheckLightExtendedColors
        }

    CompositionLocalProvider(
        LocalPurseCheckExtendedColors provides extendedColors,
        LocalPurseCheckIsDarkTheme provides useDarkTheme
    ){
        MaterialTheme(
            colorScheme = colorScheme,
            typography = purseCheckTypography(),
            shapes = purseCheckShapes,
            content = content
        )
    }
}

internal object PurseCheckTheme {

    val colors: PurseCheckExtendedColors
        @Composable
        get() = LocalPurseCheckExtendedColors.current

    val spacing: PurseCheckSpacing
        get() = PurseCheckSpacing

    val elevation: PurseCheckElevation
        get() = PurseCheckElevation

    val isDark: Boolean
        @Composable
        get() = LocalPurseCheckIsDarkTheme.current
}