package org.stephennnamani.pursecheck.app.shell.compact

import androidx.compose.foundation.focusGroup
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.stephennnamani.pursecheck.app.navigation.PurseCheckDestination
import org.stephennnamani.pursecheck.app.navigation.iconResource
import org.stephennnamani.pursecheck.app.navigation.labelResources
import org.stephennnamani.pursecheck.app.navigation.primaryDestinations
import org.stephennnamani.pursecheck.app.shell.component.PurseCheckWorkspaceScaffold
import org.stephennnamani.pursecheck.app.shell.component.rememberNavigationFocusRequesters
import org.stephennnamani.pursecheck.core.designsystem.theme.PurseCheckTheme

@Composable
internal fun CompactPurseCheckShell(
    selectedDestination: PurseCheckDestination,
    onDestinationSelected: (PurseCheckDestination) -> Unit,
    content: @Composable () -> Unit
){
    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )

    val coroutineScope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            CompactPurseCheckDrawer(
                selectedDestination = selectedDestination,
                onDestinationSelected = { destination ->
                    onDestinationSelected(destination)

                    coroutineScope.launch {
                        drawerState.close()
                    }
                }
            )
        }
    ){
        PurseCheckWorkspaceScaffold(
            selectedDestination = selectedDestination,
            onMenuClick = {
                coroutineScope.launch {
                    drawerState.open()
                }
            },
            bottomBar = {
                CompactBottomNavigation(
                    selectedDestination = selectedDestination,
                    onDestinationSelected = onDestinationSelected
                )
            }
        ){
            content()
        }
    }

}

@Composable
private fun CompactBottomNavigation(
    selectedDestination: PurseCheckDestination,
    onDestinationSelected: (PurseCheckDestination) -> Unit
) {
    val focusRequesters = rememberNavigationFocusRequesters(
        primaryDestinations
    )

    val focusEntryDestination =
        if (selectedDestination in primaryDestinations) {
            selectedDestination
        } else {
            primaryDestinations.first()
        }

    NavigationBar(
        modifier = Modifier
            .focusProperties{
                onEnter = {
                    focusRequesters
                        .getValue(focusEntryDestination)
                        .requestFocus()
                }
            }
            .focusGroup(),
        containerColor = MaterialTheme.colorScheme.surface,
        tonalElevation = PurseCheckTheme.elevation.level0
    ) {
        primaryDestinations.forEach { destination ->
            NavigationBarItem(
                modifier = Modifier.focusRequester(
                    focusRequesters.getValue(destination)
                ),
                selected = selectedDestination == destination,
                onClick = { onDestinationSelected(destination) },
                icon = {
                    Icon(
                        painter = painterResource(destination.iconResource),
                        contentDescription = null
                    )
                },
                label = {
                    Text(text = stringResource(destination.labelResources))
                },
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    indicatorColor = MaterialTheme.colorScheme.primaryContainer,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
                )
            )
        }
    }
}
