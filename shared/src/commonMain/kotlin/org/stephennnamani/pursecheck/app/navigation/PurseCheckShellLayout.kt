package org.stephennnamani.pursecheck.app.navigation

import org.stephennnamani.pursecheck.core.adaptive.PurseCheckAdaptiveLayoutInfo
import org.stephennnamani.pursecheck.core.adaptive.PurseCheckWindowWidthClass

internal enum class PurseCheckShellLayout {
    Compact,
    Medium,
    Expanded
}

internal fun PurseCheckAdaptiveLayoutInfo.toShellLayout():
        PurseCheckShellLayout =
    when (widthClass) {
        PurseCheckWindowWidthClass.Compact ->
            PurseCheckShellLayout.Compact

        PurseCheckWindowWidthClass.Medium ->
            PurseCheckShellLayout.Medium

        PurseCheckWindowWidthClass.Expanded,
        PurseCheckWindowWidthClass.Large,
        PurseCheckWindowWidthClass.ExtraLarge,
            ->
            PurseCheckShellLayout.Expanded
    }