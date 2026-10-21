package org.stephennnamani.pursecheck.app.shell.expanded

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TooltipAnchorPosition
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.WideNavigationRailDefaults
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextOverflow
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.stephennnamani.pursecheck.app.navigation.PurseCheckDestination
import org.stephennnamani.pursecheck.app.navigation.iconResource
import org.stephennnamani.pursecheck.app.navigation.labelResources
import org.stephennnamani.pursecheck.app.navigation.primaryDestinations
import org.stephennnamani.pursecheck.app.navigation.secondaryDestinations
import org.stephennnamani.pursecheck.app.navigation.utilityDestinations
import org.stephennnamani.pursecheck.app.shell.PurseCheckShellDimensions
import org.stephennnamani.pursecheck.core.designsystem.brand.PurseCheckLogo
import org.stephennnamani.pursecheck.core.designsystem.brand.PurseCheckLogoVariant
import org.stephennnamani.pursecheck.core.designsystem.theme.PurseCheckTheme
import org.stephennnamani.pursecheck.resources.Res
import org.stephennnamani.pursecheck.resources.ic_panel_left_open
import org.stephennnamani.pursecheck.resources.ic_panel_right_open
import org.stephennnamani.pursecheck.resources.navigation_collapse
import org.stephennnamani.pursecheck.resources.navigation_expand

@Composable
internal fun WidePurseCheckRail(
    expanded: Boolean,
    selectedDestination: PurseCheckDestination,
    onExpandedChange: (Boolean) -> Unit,
    onDestinationSelected: (PurseCheckDestination) -> Unit
){
    val railWidth by animateDpAsState(
        targetValue =
            if (expanded){
                PurseCheckShellDimensions.WideRailExpandWidth
            } else {
                PurseCheckShellDimensions.WideRailCollapseWidth
            },
        label = "PurseCheck wid navigation rail width"
    )

    Surface(
        modifier = Modifier
            .fillMaxHeight()
            .width(railWidth),
        color = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onSurface
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .windowInsetsPadding(
                    WideNavigationRailDefaults.windowInsets
                )
                .padding(
                    horizontal = PurseCheckTheme.spacing.space8,
                    vertical = PurseCheckTheme.spacing.space16
                )
        ) {
            WideRailHeader(
                expanded = expanded,
                onExpandedChange = onExpandedChange
            )

            Spacer(
                modifier = Modifier.height(
                    PurseCheckTheme.spacing.space24
                )
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(
                        rememberScrollState()
                    )
                    .selectableGroup(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(
                    PurseCheckTheme.spacing.space4
                )
            ){
                primaryDestinations.forEach { destination ->
                    WideRailDestinationItem(
                        destination = destination,
                        selected = selectedDestination == destination,
                        expanded = expanded,
                        onClick = {
                            onDestinationSelected(destination)
                        }
                    )
                }

                WideRailDivider(
                    expanded = expanded
                )

                secondaryDestinations.forEach { destination ->
                    WideRailDestinationItem(
                        destination = destination,
                        selected = selectedDestination == destination,
                        expanded = expanded,
                        onClick = {
                            onDestinationSelected(destination)
                        }
                    )
                }

                WideRailDivider(
                    expanded = expanded
                )

                Column(
                    modifier = Modifier.selectableGroup(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(
                        PurseCheckTheme.spacing.space4
                    )
                ){
                    utilityDestinations.forEach { destination ->
                        WideRailDestinationItem(
                            destination = destination,
                            selected = selectedDestination == destination,
                            expanded = expanded,
                            onClick = {
                                onDestinationSelected(destination)
                            }
                        )
                    }
                }


            }
        }
    }
}
@Composable
private fun WideRailHeader(
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit
) {
    if (expanded) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(
                    min = PurseCheckShellDimensions.NavigationItemMinSize
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            PurseCheckLogo(
                variant = PurseCheckLogoVariant.Horizontal,
                modifier = Modifier
                    .weight(1f)
                    .height(PurseCheckTheme.spacing.space32)
            )

            Spacer(
                modifier = Modifier.width(
                    PurseCheckTheme.spacing.space8
                )
            )

            WideRailToggleButton(
                expanded = true,
                onClick = {
                    onExpandedChange(false)
                }
            )
        }
    } else {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                PurseCheckTheme.spacing.space8
            )
        ){
            PurseCheckLogo(
                variant = PurseCheckLogoVariant.Mark,
                modifier = Modifier.size(PurseCheckTheme.spacing.space40)
            )

            WideRailToggleButton(
                expanded = false,
                onClick = {
                    onExpandedChange(true)
                }
            )
        }

    }
}

@Composable
private fun WideRailToggleButton(
    expanded: Boolean,
    onClick: () -> Unit
) {
   val description = stringResource(
       if (expanded) {
           Res.string.navigation_collapse
       } else {
           Res.string.navigation_expand
       }
   )

    val iconResource: DrawableResource =
        if (expanded) {
            Res.drawable.ic_panel_right_open
        } else {
            Res.drawable.ic_panel_left_open
        }

    TooltipBox(
        positionProvider =
            TooltipDefaults.rememberTooltipPositionProvider(
                TooltipAnchorPosition.End,
            ),
        tooltip = {
            PlainTooltip {
                Text(text = description)
            }
        },
        state = rememberTooltipState()
    ){
        IconButton(onClick = onClick){
            Icon(
                painter = painterResource(iconResource),
                contentDescription = description
            )
        }
    }

}

@Composable
private fun WideRailDestinationItem(
    destination: PurseCheckDestination,
    selected: Boolean,
    expanded: Boolean,
    onClick: () -> Unit
) {
    val label = stringResource(destination.labelResources)

    if (expanded){
        WideRailDestinationSurface(
            destination = destination,
            label = label,
            selected = selected,
            expanded = true,
            onClick = onClick
        )
    } else {
        TooltipBox(
            positionProvider =
                TooltipDefaults.rememberTooltipPositionProvider(
                    TooltipAnchorPosition.End,
                ),
            tooltip = {
                PlainTooltip {
                    Text(text = label)
                }
            },
            state = rememberTooltipState()
        ){
            WideRailDestinationSurface(
                destination = destination,
                label = label,
                selected = selected,
                expanded = false,
                onClick = onClick
            )
        }
    }
}

@Composable
private fun WideRailDestinationSurface(
    destination: PurseCheckDestination,
    label: String,
    selected: Boolean,
    expanded: Boolean,
    onClick: () -> Unit
) {
    val containerColor =
        if (selected) {
            MaterialTheme.colorScheme.primaryContainer
        } else {
            Color.Transparent
        }

    val contentColor =
        if (selected) {
            MaterialTheme.colorScheme.onPrimaryContainer
        } else {
            MaterialTheme.colorScheme.onSurfaceVariant
        }

    Surface(
        modifier =
            if (expanded) {
                Modifier.fillMaxWidth()
                    .heightIn(
                        min = PurseCheckShellDimensions.NavigationItemMinSize
                    )
                    .selectable(
                        selected = selected,
                        onClick = onClick,
                        role = Role.Tab
                    )
            } else {
                Modifier.size(PurseCheckShellDimensions.NavigationItemMinSize)
                    .selectable(
                        selected = selected,
                        onClick = onClick,
                        role = Role.Tab
                    )
            },
        shape = MaterialTheme.shapes.medium,
        color = containerColor,
        contentColor = contentColor
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = PurseCheckShellDimensions.NavigationItemMinSize)
                .padding(horizontal = PurseCheckTheme.spacing.space16),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement =
                if (expanded){
                    Arrangement.Start
                } else {
                    Arrangement.Center
                }
        ){
            Icon(
                painter = painterResource(destination.iconResource),
                contentDescription =
                    if (expanded) {
                        null
                    } else {
                        label
                    }
            )
            if (expanded) {
                Spacer(
                    modifier = Modifier.width(
                        PurseCheckTheme.spacing.space12
                    )
                )

                Text(
                    text = label,
                    style = MaterialTheme.typography.labelLarge,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

    }

}



@Composable
fun WideRailDivider(expanded: Boolean) {
    Spacer(
        modifier = Modifier.height(
            PurseCheckTheme.spacing.space8
        )
    )

    HorizontalDivider(
        modifier =
            if (expanded) {
                Modifier.fillMaxWidth()
            } else {
                Modifier.width(
                    PurseCheckTheme.spacing.space32
                )
            },
        color = MaterialTheme.colorScheme.outlineVariant
    )

    Spacer(
        modifier = Modifier.height(
            PurseCheckTheme.spacing.space8
        )
    )
}

