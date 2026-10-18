package org.stephennnamani.pursecheck.app.navigation

import org.stephennnamani.pursecheck.core.adaptive.PurseCheckAdaptiveLayoutInfo
import org.stephennnamani.pursecheck.core.adaptive.PurseCheckWindowWidthClass
import kotlin.test.Test
import kotlin.test.assertEquals

class PurseCheckShellLayoutTest {
    @Test
    fun compactWindowUsesCompactShell() {
        assertEquals(
            PurseCheckShellLayout.Compact,
            layoutInfo(
                PurseCheckWindowWidthClass.Compact
            ).toShellLayout()
        )
    }

    @Test
    fun mediumWindowUsesMediumShell() {
        assertEquals(
            PurseCheckShellLayout.Medium,
            layoutInfo(
                PurseCheckWindowWidthClass.Medium
            ).toShellLayout()
        )
    }

    @Test
    fun expandedWindowUsesExpandedShell() {
        assertEquals(
            PurseCheckShellLayout.Expanded,
            layoutInfo(
                PurseCheckWindowWidthClass.Expanded
            ).toShellLayout()
        )
    }

    @Test
    fun largeWindowUsesExpandedShell() {
        assertEquals(
            PurseCheckShellLayout.Expanded,
            layoutInfo(
                PurseCheckWindowWidthClass.Large
            ).toShellLayout()
        )
    }

    @Test
    fun extraLargeWindowUsesExpandedShell() {
        assertEquals(
            PurseCheckShellLayout.Expanded,
            layoutInfo(
                PurseCheckWindowWidthClass.ExtraLarge
            ).toShellLayout()
        )
    }

    private fun layoutInfo(
        widthClass: PurseCheckWindowWidthClass
    ) = PurseCheckAdaptiveLayoutInfo(
        widthClass = widthClass,
        isHeightCompact = false
    )
}