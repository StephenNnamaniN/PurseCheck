package org.stephennnamani.pursecheck.core.designsystem.theme

enum class ThemeMode {
    System,
    Light,
    Dark
}

internal fun shouldUseDarkTheme(
    themeMode: ThemeMode,
    systemInDarkTheme: Boolean
): Boolean =
    when (themeMode) {
        ThemeMode.System ->systemInDarkTheme
        ThemeMode.Light -> false
        ThemeMode.Dark -> true
    }