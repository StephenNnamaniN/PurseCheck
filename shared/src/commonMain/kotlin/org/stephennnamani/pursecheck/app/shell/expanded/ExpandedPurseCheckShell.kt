package org.stephennnamani.pursecheck.app.shell.expanded

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.stringResource
import org.stephennnamani.pursecheck.app.navigation.PurseCheckDestination
import org.stephennnamani.pursecheck.app.shell.component.PurseCheckTopAppBar
import org.stephennnamani.pursecheck.app.shell.component.PurseCheckWorkspaceScaffold
import org.stephennnamani.pursecheck.resources.Res
import org.stephennnamani.pursecheck.resources.notifications_none

@Composable
internal fun ExpandedPurseCheckShell(
    selectedDestination: PurseCheckDestination,
    railExpanded: Boolean,
    onDestinationSelected: (PurseCheckDestination) -> Unit,
    onRailExpandedChange: (Boolean) -> Unit,
    content: @Composable () -> Unit
){
    Row(modifier = Modifier.fillMaxSize()){
        WidePurseCheckRail(
            expanded = railExpanded,
            selectedDestination = selectedDestination,
            onExpandedChange = onRailExpandedChange,
            onDestinationSelected = onDestinationSelected
        )

        PurseCheckWorkspaceScaffold(
            selectedDestination = selectedDestination,
            modifier = Modifier.weight(1f),
            content = content
        )
    }

}
