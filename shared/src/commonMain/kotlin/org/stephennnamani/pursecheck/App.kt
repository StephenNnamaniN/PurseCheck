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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import org.stephennnamani.pursecheck.core.adaptive.PurseCheckAdaptiveLayoutInfo
import org.stephennnamani.pursecheck.core.adaptive.currentPurseCheckAdaptiveLayoutInfo
import org.stephennnamani.pursecheck.core.designsystem.brand.PurseCheckLogo
import org.stephennnamani.pursecheck.core.designsystem.brand.PurseCheckLogoVariant
import org.stephennnamani.pursecheck.core.designsystem.component.AppearanceSelector
import org.stephennnamani.pursecheck.core.designsystem.theme.PurseCheckTheme
import org.stephennnamani.pursecheck.core.designsystem.theme.ThemeMode
import org.stephennnamani.pursecheck.resources.Res
import org.stephennnamani.pursecheck.resources.app_tagline

@Composable
@Preview
fun PurseCheckApp() {
    var themeMode by remember {
        mutableStateOf(ThemeMode.System)
    }

    val adaptiveLayoutInfo = currentPurseCheckAdaptiveLayoutInfo()

    PurseCheckTheme(
        themeMode = themeMode
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(PurseCheckTheme.spacing.space24),
                contentAlignment = Alignment.Center
            ){
                val scrollState = rememberScrollState()
                Surface(
                    modifier = Modifier
                        .widthIn(max = 420.dp)
                        .fillMaxWidth()
                        .verticalScroll(
                            state = scrollState
                        ),
                    shape = MaterialTheme.shapes.large,
                    color = MaterialTheme.colorScheme.surface,
                    contentColor = MaterialTheme.colorScheme.onSurface,
                    shadowElevation = PurseCheckTheme.elevation.level2
                ) {
                    Column(
                        modifier = Modifier.padding(
                            horizontal = PurseCheckTheme.spacing.space32,
                            vertical = PurseCheckTheme.spacing.space24
                        ),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(
                            PurseCheckTheme.spacing.space20
                        )
                    ){
                        PurseCheckLogo(
                            variant = PurseCheckLogoVariant.Horizontal,
                            modifier = Modifier
                                .width(280.dp)
                                .fillMaxWidth()
                        )
                        Text(
                            text = stringResource(Res.string.app_tagline),
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(
                                PurseCheckTheme.spacing.space16
                            )
                        ) {
                            Text(
                                text = "Income",
                                style = MaterialTheme.typography.labelLarge,
                                color = PurseCheckTheme.colors.income
                            )
                            Text(
                                text = "Expense",
                                style = MaterialTheme.typography.labelLarge,
                                color = PurseCheckTheme.colors.expense
                            )
                            Text(
                                text = "Savings",
                                style = MaterialTheme.typography.labelLarge,
                                color = PurseCheckTheme.colors.savings
                            )
                        }

                        AppearanceSelector(
                            selectedMode = themeMode,
                            onModeSelected = { selectedMode ->
                                themeMode = selectedMode
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    top = PurseCheckTheme.spacing.space8
                                )
                        )

                        AdaptiveLayoutDiagnostics(
                            layoutInfo = adaptiveLayoutInfo,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun AdaptiveLayoutDiagnostics(
    layoutInfo: PurseCheckAdaptiveLayoutInfo,
    modifier: Modifier = Modifier
){
    Surface(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surfaceContainer,
        contentColor = MaterialTheme.colorScheme.onSurface
    ) {
        Column(
            modifier = Modifier.padding(
                PurseCheckTheme.spacing.space16
            ),
            verticalArrangement = Arrangement.spacedBy(
                PurseCheckTheme.spacing.space8
            )
        ){
            Text(
                text = "Adaptive layout",
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.semantics { heading() }
            )
            Text(
                text = "Width class: ${layoutInfo.widthClass.name}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Text(
                text = if (layoutInfo.isHeightCompact){
                    "Heigh: Compact"
                } else {
                    "Height: Medium or greater"
                },
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