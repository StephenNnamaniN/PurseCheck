package org.stephennnamani.pursecheck.app.shell.medium

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
import org.stephennnamani.pursecheck.resources.Res
import org.stephennnamani.pursecheck.resources.notifications_none

@Composable
internal fun MediumPurseCheckShell(
    selectedDestination: PurseCheckDestination,
    onDestinationSelected: (PurseCheckDestination) -> Unit,
    content: @Composable () -> Unit
){
    val snackbarHostState = remember { SnackbarHostState() }

    val coroutineScope = rememberCoroutineScope()

    val onNotificationMessage = stringResource(Res.string.notifications_none)

    Row(
        modifier = Modifier.fillMaxSize()
    ){
        MediumPurseCheckRail(
            selectedDestination = selectedDestination,
            onDestinationSelected = onDestinationSelected
        )

        Scaffold(
            modifier = Modifier.weight(1f),
            topBar = {
                PurseCheckTopAppBar(
                    selectedDestination = selectedDestination,
                    onNotificationClick = {
                        coroutineScope.launch {
                            snackbarHostState.showSnackbar(
                                message = onNotificationMessage
                            )
                        }
                    }
                )
            },
            snackbarHost = {
                SnackbarHost(hostState = snackbarHostState)
            },
            containerColor = MaterialTheme.colorScheme.background
        ) { innerPadding ->
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .consumeWindowInsets(innerPadding)
            ){
                content()
            }
        }
    }
}