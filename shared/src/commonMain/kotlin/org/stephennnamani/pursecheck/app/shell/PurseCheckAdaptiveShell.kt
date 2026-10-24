package org.stephennnamani.pursecheck.app.shell

import androidx.compose.runtime.Composable
import org.stephennnamani.pursecheck.app.navigation.PurseCheckDestination
import org.stephennnamani.pursecheck.app.navigation.PurseCheckShellLayout
import org.stephennnamani.pursecheck.app.navigation.toShellLayout
import org.stephennnamani.pursecheck.app.shell.compact.CompactPurseCheckShell
import org.stephennnamani.pursecheck.app.shell.expanded.ExpandedPurseCheckShell
import org.stephennnamani.pursecheck.app.shell.medium.MediumPurseCheckShell
import org.stephennnamani.pursecheck.core.adaptive.PurseCheckAdaptiveLayoutInfo

@Composable
internal fun PurseCheckAdaptiveShell(
    layoutInfo: PurseCheckAdaptiveLayoutInfo,
    selectedDestination: PurseCheckDestination,
    wideRailExpanded: Boolean,
    onDestinationSelected: (PurseCheckDestination) -> Unit,
    onWideRailExpandedChange: (Boolean) -> Unit,
    content: @Composable () -> Unit
){
    when (layoutInfo.toShellLayout()) {
        PurseCheckShellLayout.Compact -> {
            CompactPurseCheckShell(
                selectedDestination = selectedDestination,
                onDestinationSelected = onDestinationSelected,
                content = content
            )
        }

        PurseCheckShellLayout.Medium -> {
            MediumPurseCheckShell(
                selectedDestination = selectedDestination,
                onDestinationSelected = onDestinationSelected,
                content = content
            )
        }

        PurseCheckShellLayout.Expanded -> {
            ExpandedPurseCheckShell(
                selectedDestination = selectedDestination,
                railExpanded = wideRailExpanded,
                onDestinationSelected = onDestinationSelected,
                onRailExpandedChange = onWideRailExpandedChange,
                content = content
            )
        }
    }
}
