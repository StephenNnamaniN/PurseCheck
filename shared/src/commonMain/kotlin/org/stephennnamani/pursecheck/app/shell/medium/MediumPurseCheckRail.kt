package org.stephennnamani.pursecheck.app.shell.medium

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.Text
import androidx.compose.material3.TooltipAnchorPosition
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.stephennnamani.pursecheck.app.navigation.PurseCheckDestination
import org.stephennnamani.pursecheck.app.navigation.iconResource
import org.stephennnamani.pursecheck.app.navigation.labelResources
import org.stephennnamani.pursecheck.app.navigation.primaryDestinations
import org.stephennnamani.pursecheck.app.navigation.secondaryDestinations
import org.stephennnamani.pursecheck.app.navigation.utilityDestinations
import org.stephennnamani.pursecheck.core.designsystem.brand.PurseCheckLogo
import org.stephennnamani.pursecheck.core.designsystem.brand.PurseCheckLogoVariant
import org.stephennnamani.pursecheck.core.designsystem.theme.PurseCheckTheme

@Composable
internal  fun MediumPurseCheckRail(
    selectedDestination: PurseCheckDestination,
    onDestinationSelected: (PurseCheckDestination) -> Unit
){
    NavigationRail(
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onSurface,
        header = {
            Spacer(modifier = Modifier.height(
                PurseCheckTheme.spacing.space8
            ))
            PurseCheckLogo(
                variant = PurseCheckLogoVariant.Mark,
                modifier = Modifier
                    .width(PurseCheckTheme.spacing.space40),
            )
            Spacer(modifier = Modifier.height(
                PurseCheckTheme.spacing.space16
            ))
        }
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                PurseCheckTheme.spacing.space4
            )
        ){
            primaryDestinations.forEach { destination ->
                MediumRailDestinationItem(
                    destination = destination,
                    selected = selectedDestination == destination,
                    onClick = {
                        onDestinationSelected(destination)
                    }
                )
            }

            RailSectionDivider()

            secondaryDestinations.forEach { destination ->
                MediumRailDestinationItem(
                    destination = destination,
                    selected = selectedDestination == destination,
                    onClick = {
                        onDestinationSelected(destination)
                    }
                )
            }

            RailSectionDivider()

            utilityDestinations.forEach { destination ->
                MediumRailDestinationItem(
                    destination = destination,
                    selected = selectedDestination == destination,
                    onClick = {
                        onDestinationSelected(destination)
                    }
                )
            }

            Spacer(modifier = Modifier.height(
                PurseCheckTheme.spacing.space8
            ))
        }
    }
}

@Composable
private fun MediumRailDestinationItem(
    destination: PurseCheckDestination,
    selected: Boolean,
    onClick: () -> Unit
) {
    val label = stringResource(destination.labelResources)

    TooltipBox(
        positionProvider =
            TooltipDefaults.rememberTooltipPositionProvider(
                TooltipAnchorPosition.End
            ),
        tooltip = {
            PlainTooltip {
                Text(text = label)
            }
        },
        state = rememberTooltipState()
    ){
        NavigationRailItem(
            selected = selected,
            onClick = onClick,
            icon = {
                Icon(
                    painter = painterResource(destination.iconResource),
                    contentDescription = label
                )
            },
            colors = NavigationRailItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                indicatorColor = MaterialTheme.colorScheme.primaryContainer,
                unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant
            )
        )
    }
}

@Composable
private fun RailSectionDivider() {
    Spacer(modifier = Modifier.height(
        PurseCheckTheme.spacing.space8
    ))

    HorizontalDivider(
        modifier = Modifier.width(
            PurseCheckTheme.spacing.space32
        ),
        color = MaterialTheme.colorScheme.outlineVariant
    )
    Spacer(modifier = Modifier.height(
        PurseCheckTheme.spacing.space8
    ))
}
