package org.stephennnamani.pursecheck.app.shell.compact

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.stephennnamani.pursecheck.app.navigation.PurseCheckDestination
import org.stephennnamani.pursecheck.app.navigation.iconResource
import org.stephennnamani.pursecheck.app.navigation.labelResources
import org.stephennnamani.pursecheck.app.navigation.secondaryDestinations
import org.stephennnamani.pursecheck.app.navigation.utilityDestinations
import org.stephennnamani.pursecheck.core.designsystem.brand.PurseCheckLogo
import org.stephennnamani.pursecheck.core.designsystem.brand.PurseCheckLogoVariant
import org.stephennnamani.pursecheck.core.designsystem.theme.PurseCheckTheme
import org.stephennnamani.pursecheck.resources.Res
import org.stephennnamani.pursecheck.resources.demo_profile_initials
import org.stephennnamani.pursecheck.resources.demo_profile_name
import org.stephennnamani.pursecheck.resources.demo_profile_subtitle

@Composable
internal fun CompactPurseCheckDrawer(
    selectedDestination: PurseCheckDestination,
    onDestinationSelected: (PurseCheckDestination) -> Unit
){
    ModalDrawerSheet {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(
                    horizontal = PurseCheckTheme.spacing.space16,
                    vertical = PurseCheckTheme.spacing.space16
                )
        ) {
            PurseCheckLogo(
                variant = PurseCheckLogoVariant.Horizontal,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(120.dp)
                    .padding(
                        end = PurseCheckTheme.spacing.space64
                    )
            )

            Spacer(
                modifier = Modifier.size(
                    PurseCheckTheme.spacing.space8
                )
            )

            DemoProfileHeader()

            Spacer(
                modifier = Modifier.size(
                    PurseCheckTheme.spacing.space8
                )
            )

            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

            Spacer(
                modifier = Modifier.size(
                    PurseCheckTheme.spacing.space8
                )
            )

            secondaryDestinations.forEach { destination ->
                DrawerDestinationItem(
                    destination = destination,
                    selected = selectedDestination == destination,
                    onClick = { onDestinationSelected(destination)}
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

            Spacer(
                modifier = Modifier.size(
                    PurseCheckTheme.spacing.space12
                )
            )

            utilityDestinations.forEach { destination ->
                DrawerDestinationItem(
                    destination = destination,
                    selected = selectedDestination == destination,
                    onClick = { onDestinationSelected(destination)}
                )
            }
        }
    }
}


@Composable
private fun DemoProfileHeader() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(
            PurseCheckTheme.spacing.space12
        )
    ) {
        Surface(
            shape = CircleShape,
            color = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        ) {
            Box(
                modifier = Modifier.size(48.dp),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = stringResource(
                        Res.string.demo_profile_initials
                    ),
                    style = MaterialTheme.typography.titleSmall
                )
            }
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(
                PurseCheckTheme.spacing.space4
            )
        ){
            Text(
                text = stringResource(Res.string.demo_profile_name),
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = stringResource(Res.string.demo_profile_subtitle),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

    }

}

@Composable
private fun DrawerDestinationItem(
    destination: PurseCheckDestination,
    selected: Boolean,
    onClick: () -> Unit
) {
    NavigationDrawerItem(
        label = { Text(text = stringResource(destination.labelResources))},
        selected = selected,
        onClick = onClick,
        icon = {
            Icon(
                painter = painterResource(destination.iconResource),
                contentDescription = null
            )
        },
        modifier = Modifier.padding(
            NavigationDrawerItemDefaults.ItemPadding
        ),
        colors = NavigationDrawerItemDefaults.colors(
            selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
            selectedIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
            selectedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
            unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
            unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
        )
    )
}