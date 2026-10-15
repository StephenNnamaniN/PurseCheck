package org.stephennnamani.pursecheck.core.designsystem.theme

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ThemeModeTest {

    @Test
    fun systemModeUsesLightWhenSystemIsLight() {
        assertFalse(
            shouldUseDarkTheme(
                themeMode = ThemeMode.System,
                systemInDarkTheme =  false
            )
        )
    }
    @Test
    fun lightModeStaysLightWhenSystemIsDark() {
        assertFalse(
            shouldUseDarkTheme(
                themeMode = ThemeMode.Light,
                systemInDarkTheme =  true
            )
        )
    }

    @Test
    fun systemModeUsesDarkWhenSystemIsDark() {
        assertTrue (
            shouldUseDarkTheme(
                themeMode = ThemeMode.Dark,
                systemInDarkTheme =  true
            )
        )
    }

}