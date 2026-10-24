package org.stephennnamani.pursecheck.app.shell.medium

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.stephennnamani.pursecheck.app.navigation.PurseCheckDestination
import org.stephennnamani.pursecheck.app.shell.component.PurseCheckWorkspaceScaffold

@Composable
internal fun MediumPurseCheckShell(
    selectedDestination: PurseCheckDestination,
    onDestinationSelected: (PurseCheckDestination) -> Unit,
    content: @Composable () -> Unit
){

    Row(
        modifier = Modifier.fillMaxSize()
    ){
        MediumPurseCheckRail(
            selectedDestination = selectedDestination,
            onDestinationSelected = onDestinationSelected
        )

        PurseCheckWorkspaceScaffold(
            selectedDestination = selectedDestination,
            modifier = Modifier.weight(1f),
            content = content
        )
    }
}