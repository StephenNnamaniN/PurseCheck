package org.stephennnamani.pursecheck.core.adaptive

import androidx.window.core.layout.WindowSizeClass
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PurseCheckAdaptiveLayoutInfoTest {
    @Test
    fun heightBelow480IsCompact() {
        val layoutInfo =
            WindowSizeClass(
                minWidthDp = 840,
                minHeightDp = 479
            ).toPurseCheckAdaptiveLayoutInfo()

        assertTrue(layoutInfo.isHeightCompact)
    }

    @Test
    fun height480IsNotCompact() {
        val layoutInfo =
            WindowSizeClass(
                minWidthDp = 840,
                minHeightDp = 480
            ).toPurseCheckAdaptiveLayoutInfo()

        assertFalse(layoutInfo.isHeightCompact)
    }
}