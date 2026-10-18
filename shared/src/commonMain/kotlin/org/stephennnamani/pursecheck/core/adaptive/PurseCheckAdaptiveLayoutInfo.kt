package org.stephennnamani.pursecheck.core.adaptive

import androidx.compose.material3.adaptive.currentWindowAdaptiveInfoV2
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowSizeClass.Companion.HEIGHT_DP_MEDIUM_LOWER_BOUND

@Immutable
data class PurseCheckAdaptiveLayoutInfo(
    val widthClass: PurseCheckWindowWidthClass,
    val isHeightCompact: Boolean
)

internal fun WindowSizeClass.toPurseCheckAdaptiveLayoutInfo():
        PurseCheckAdaptiveLayoutInfo =
    PurseCheckAdaptiveLayoutInfo(
        widthClass = toPurseCheckWindowWidthClass(),
        isHeightCompact = !isHeightAtLeastBreakpoint(
            HEIGHT_DP_MEDIUM_LOWER_BOUND
        )
    )

@Composable
internal fun currentPurseCheckAdaptiveLayoutInfo():
        PurseCheckAdaptiveLayoutInfo =
    currentWindowAdaptiveInfoV2()
        .windowSizeClass
        .toPurseCheckAdaptiveLayoutInfo()
