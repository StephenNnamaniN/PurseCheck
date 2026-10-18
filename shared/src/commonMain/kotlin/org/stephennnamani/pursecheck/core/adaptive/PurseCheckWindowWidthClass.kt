package org.stephennnamani.pursecheck.core.adaptive

import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowSizeClass.Companion.WIDTH_DP_EXPANDED_LOWER_BOUND
import androidx.window.core.layout.WindowSizeClass.Companion.WIDTH_DP_EXTRA_LARGE_LOWER_BOUND
import androidx.window.core.layout.WindowSizeClass.Companion.WIDTH_DP_LARGE_LOWER_BOUND
import androidx.window.core.layout.WindowSizeClass.Companion.WIDTH_DP_MEDIUM_LOWER_BOUND

enum class PurseCheckWindowWidthClass {
    Compact,
    Medium,
    Expanded,
    Large,
    ExtraLarge
}

internal fun WindowSizeClass.toPurseCheckWindowWidthClass():
        PurseCheckWindowWidthClass =
    when {
        isWidthAtLeastBreakpoint(
            WIDTH_DP_EXTRA_LARGE_LOWER_BOUND,
        ) -> PurseCheckWindowWidthClass.ExtraLarge

        isWidthAtLeastBreakpoint(
            WIDTH_DP_LARGE_LOWER_BOUND,
        ) -> PurseCheckWindowWidthClass.Large

        isWidthAtLeastBreakpoint(
            WIDTH_DP_EXPANDED_LOWER_BOUND,
        ) -> PurseCheckWindowWidthClass.Expanded

        isWidthAtLeastBreakpoint(
            WIDTH_DP_MEDIUM_LOWER_BOUND,
        ) -> PurseCheckWindowWidthClass.Medium

        else -> PurseCheckWindowWidthClass.Compact
    }