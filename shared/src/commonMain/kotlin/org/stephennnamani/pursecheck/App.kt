package org.stephennnamani.pursecheck

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import org.stephennnamani.pursecheck.core.designsystem.brand.PurseCheckLogo
import org.stephennnamani.pursecheck.core.designsystem.brand.PurseCheckLogoVariant
import org.stephennnamani.pursecheck.core.designsystem.theme.PurseCheckTheme
import org.stephennnamani.pursecheck.resources.Res
import org.stephennnamani.pursecheck.resources.app_tagline

@Composable
@Preview
fun PurseCheckApp() {
    PurseCheckTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(PurseCheckTheme.spacing.space24),
                contentAlignment = Alignment.Center
            ){
                Surface(
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
                            modifier = Modifier.width(280.dp)
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
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun PurseCheckAppPreview(){
    PurseCheckApp()
}