package org.stephennnamani.pursecheck.app.shell.compact

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.stephennnamani.pursecheck.app.navigation.PurseCheckDestination
import org.stephennnamani.pursecheck.app.navigation.iconResource
import org.stephennnamani.pursecheck.app.navigation.labelResources
import org.stephennnamani.pursecheck.app.navigation.primaryDestinations
import org.stephennnamani.pursecheck.core.designsystem.theme.PurseCheckTheme
import org.stephennnamani.pursecheck.resources.Res
import org.stephennnamani.pursecheck.resources.ic_menu
import org.stephennnamani.pursecheck.resources.ic_notifications
import org.stephennnamani.pursecheck.resources.navigation_menu_content_description
import org.stephennnamani.pursecheck.resources.notifications_content_description
import org.stephennnamani.pursecheck.resources.notifications_none

@Composable
internal fun CompactPurseCheckShell(
    selectedDestination: PurseCheckDestination,
    onDestinationSelected: (PurseCheckDestination) -> Unit,
    content: @Composable () -> Unit
){
    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )

    val snackbarHostState = remember { SnackbarHostState() }

    val coroutineScope = rememberCoroutineScope()

    val onNotificationMessage = stringResource(Res.string.notifications_none)

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
        Scaffold(
            topBar = {
                CompactTopAppBar(
                    selectedDesition = selectedDestination,
                    onMenuClick = {
                        coroutineScope.launch {
                            drawerState.open()
                        }
                    },
                    onNotificationsClick = {
                        coroutineScope.launch {
                            snackbarHostState.showSnackbar(
                                message = onNotificationMessage
                            )
                        }
                    }
                )
            },
            bottomBar = {
                CompactBottomNavigation(
                    selectedDesition = selectedDestination,
                    onDestinationSelected = onDestinationSelected
                )
            },
            snackbarHost = {
                SnackbarHost(hostState = snackbarHostState)
            },
            contentColor = MaterialTheme.colorScheme.background
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .consumeWindowInsets(innerPadding)
            ){
                content()
            }

        }
    }

}


@Composable
private fun CompactTopAppBar(
    selectedDesition: PurseCheckDestination,
    onMenuClick: () -> Unit,
    onNotificationsClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(selectedDesition.labelResources),
                style = MaterialTheme.typography.titleLarge
                )
        },
        navigationIcon = {
            IconButton(onClick = onMenuClick
            ){
                Icon(
                    painter = painterResource(Res.drawable.ic_menu),
                    contentDescription = stringResource(
                        Res.string.navigation_menu_content_description
                    )
                )
            }
        },
        actions = {
            IconButton(onClick = onNotificationsClick
            ){
                Icon(
                    painter = painterResource(Res.drawable.ic_notifications),
                    contentDescription = stringResource(Res.string.notifications_content_description)
                )
            }

        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            titleContentColor = MaterialTheme.colorScheme.onBackground,
            navigationIconContentColor = MaterialTheme.colorScheme.onBackground,
            actionIconContentColor = MaterialTheme.colorScheme.onBackground
        )
    )
}

@Composable
private fun CompactBottomNavigation(
    selectedDesition: PurseCheckDestination,
    onDestinationSelected: (PurseCheckDestination) -> Unit
) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        tonalElevation = PurseCheckTheme.elevation.level0
    ) {
        primaryDestinations.forEach { destination ->
            NavigationBarItem(
                selected = selectedDesition == destination,
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
