package org.stephennnamani.pursecheck

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import org.stephennnamani.pursecheck.app.navigation.PurseCheckDestination
import org.stephennnamani.pursecheck.app.navigation.PurseCheckShellLayout
import org.stephennnamani.pursecheck.app.navigation.labelResources
import org.stephennnamani.pursecheck.app.navigation.toShellLayout
import org.stephennnamani.pursecheck.app.shell.compact.CompactPurseCheckShell
import org.stephennnamani.pursecheck.app.shell.expanded.ExpandedPurseCheckShell
import org.stephennnamani.pursecheck.app.shell.medium.MediumPurseCheckShell
import org.stephennnamani.pursecheck.core.adaptive.PurseCheckAdaptiveLayoutInfo
import org.stephennnamani.pursecheck.core.adaptive.currentPurseCheckAdaptiveLayoutInfo
import org.stephennnamani.pursecheck.core.designsystem.brand.PurseCheckLogo
import org.stephennnamani.pursecheck.core.designsystem.brand.PurseCheckLogoVariant
import org.stephennnamani.pursecheck.core.designsystem.component.AppearanceSelector
import org.stephennnamani.pursecheck.core.designsystem.theme.PurseCheckTheme
import org.stephennnamani.pursecheck.core.designsystem.theme.ThemeMode
import org.stephennnamani.pursecheck.resources.Res
import org.stephennnamani.pursecheck.resources.app_tagline
import org.stephennnamani.pursecheck.resources.feature_placeholder_description

@Composable
@Preview
fun PurseCheckApp() {
    var themeMode by remember {
        mutableStateOf(ThemeMode.System)
    }

    var selectedDestination by remember {
        mutableStateOf(PurseCheckDestination.Overview)
    }

    var wideRailExpanded by remember { mutableStateOf(false) }

    val adaptiveLayoutInfo = currentPurseCheckAdaptiveLayoutInfo()

    PurseCheckTheme(
        themeMode = themeMode
    ) {
        when (adaptiveLayoutInfo.toShellLayout()){
            PurseCheckShellLayout.Compact ->
                CompactPurseCheckShell(
                    selectedDestination = selectedDestination,
                    onDestinationSelected = { destination ->
                        selectedDestination = destination
                    }
                ){
                    PurseCheckDestinationPlaceholder(
                        destination = selectedDestination,
                        themeMode = themeMode,
                        onThemeModeSelected = { selectedMode ->
                            themeMode = selectedMode
                        }
                    )
                }

            PurseCheckShellLayout.Medium -> {
                MediumPurseCheckShell(
                    selectedDestination = selectedDestination,
                    onDestinationSelected = { destination ->
                        selectedDestination = destination
                    }
                ){
                    PurseCheckDestinationPlaceholder(
                        destination = selectedDestination,
                        themeMode = themeMode,
                        onThemeModeSelected = { selectedMode ->
                            themeMode = selectedMode
                        }
                    )
                }
            }

            PurseCheckShellLayout.Expanded -> {
                ExpandedPurseCheckShell(
                    selectedDestination = selectedDestination,
                    railExpanded = wideRailExpanded,
                    onDestinationSelected = { destination ->
                        selectedDestination = destination
                    },
                    onRailExpandedChange = { expanded ->
                        wideRailExpanded = expanded
                    }
                ){
                    PurseCheckDestinationPlaceholder(
                        destination = selectedDestination,
                        themeMode = themeMode,
                        onThemeModeSelected = { selectedMode ->
                            themeMode = selectedMode
                        }
                    )
                }

            }

        }

    }
}

@Composable
private fun PurseCheckDestinationPlaceholder(
    destination: PurseCheckDestination,
    themeMode: ThemeMode,
    onThemeModeSelected: (ThemeMode) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(PurseCheckTheme.spacing.space24),
        verticalArrangement = Arrangement.spacedBy(
            PurseCheckTheme.spacing.space16
        )
    ){
        Text(
            text = stringResource(destination.labelResources),
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.semantics { heading() }
        )
        if (destination == PurseCheckDestination.Settings) {
            AppearanceSelector(
                selectedMode = themeMode,
                onModeSelected = onThemeModeSelected,
                modifier = Modifier.fillMaxWidth()
            )
        } else {
            Text(
                text = stringResource(Res.string.feature_placeholder_description),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}


@Preview
@Composable
private fun PurseCheckAppPreview(){
    PurseCheckApp()
}