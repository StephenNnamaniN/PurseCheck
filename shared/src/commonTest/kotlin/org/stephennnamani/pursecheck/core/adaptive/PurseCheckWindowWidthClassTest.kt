package org.stephennnamani.pursecheck.core.adaptive

import androidx.window.core.layout.WindowSizeClass
import kotlin.test.Test
import kotlin.test.assertEquals

class PurseCheckWindowWidthClassTest {

    @Test
    fun withBelow600IsCompact() {
        assertEquals(
            PurseCheckWindowWidthClass.Compact,
            WindowSizeClass(
                minWidthDp = 599,
                minHeightDp = 900
            ).toPurseCheckWindowWidthClass()
        )
    }

    @Test
    fun with600IsMedium() {
        assertEquals(
            PurseCheckWindowWidthClass.Medium,
            WindowSizeClass(
                minWidthDp = 600,
                minHeightDp = 900
            ).toPurseCheckWindowWidthClass()
        )
    }


    @Test
    fun with840IsExpanded() {
        assertEquals(
            PurseCheckWindowWidthClass.Expanded,
            WindowSizeClass(
                minWidthDp = 840,
                minHeightDp = 900
            ).toPurseCheckWindowWidthClass()
        )
    }

    @Test
    fun with1200IsLarge() {
        assertEquals(
            PurseCheckWindowWidthClass.Large,
            WindowSizeClass(
                minWidthDp = 1200,
                minHeightDp = 900
            ).toPurseCheckWindowWidthClass()
        )
    }

    @Test
    fun with1600IsExtraLarge() {
        assertEquals(
            PurseCheckWindowWidthClass.ExtraLarge,
            WindowSizeClass(
                minWidthDp = 1600,
                minHeightDp = 900
            ).toPurseCheckWindowWidthClass()
        )
    }
}