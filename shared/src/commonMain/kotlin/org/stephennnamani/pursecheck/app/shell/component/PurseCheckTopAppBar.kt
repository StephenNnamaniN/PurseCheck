package org.stephennnamani.pursecheck.app.shell.component

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.stephennnamani.pursecheck.app.navigation.PurseCheckDestination
import org.stephennnamani.pursecheck.app.navigation.labelResources
import org.stephennnamani.pursecheck.resources.Res
import org.stephennnamani.pursecheck.resources.ic_menu
import org.stephennnamani.pursecheck.resources.ic_notifications
import org.stephennnamani.pursecheck.resources.navigation_menu_content_description
import org.stephennnamani.pursecheck.resources.notifications_content_description

@Composable
internal fun PurseCheckTopAppBar(
    selectedDestination: PurseCheckDestination,
    onNotificationClick: () -> Unit,
    onMenuClick: (() -> Unit)? = null
){
    TopAppBar(
        title = {
            Text(
                text = stringResource(selectedDestination.labelResources),
                style = MaterialTheme.typography.titleLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            if (onMenuClick != null) {
                IconButton(
                    onClick = onMenuClick
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.ic_menu),
                        contentDescription = stringResource(
                            Res.string.navigation_menu_content_description
                        )
                    )
                }
            }
        },
        actions = {
            IconButton(onClick = onNotificationClick
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