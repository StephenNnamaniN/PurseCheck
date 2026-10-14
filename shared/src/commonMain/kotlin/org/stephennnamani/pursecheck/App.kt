package org.stephennnamani.pursecheck

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import org.stephennnamani.pursecheck.core.designsystem.theme.PurseCheckElevation
import org.stephennnamani.pursecheck.core.designsystem.theme.PurseCheckSpacing
import org.stephennnamani.pursecheck.core.designsystem.theme.purseCheckShapes
import org.stephennnamani.pursecheck.core.designsystem.theme.purseCheckTypography
import org.stephennnamani.pursecheck.resources.Res
import org.stephennnamani.pursecheck.resources.app_tagline

@Composable
@Preview
fun PurseCheckApp() {
    MaterialTheme(
        typography = purseCheckTypography(),
        shapes = purseCheckShapes
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(PurseCheckSpacing.space24),
                contentAlignment = Alignment.Center
            ){
                Surface(
                    shape = MaterialTheme.shapes.large,
                    shadowElevation = PurseCheckElevation.level2
                ) {
                    Column(
                        modifier = Modifier.padding(
                            horizontal = PurseCheckSpacing.space32,
                            vertical = PurseCheckSpacing.space24
                        ),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(
                            PurseCheckSpacing.space20
                        )
                    ){
                        PurseCheckLogo(
                            variant = PurseCheckLogoVariant.Horizontal,
                            modifier = Modifier.width(280.dp)
                        )
                        Text(
                            text = stringResource(Res.string.app_tagline),
                            style = MaterialTheme.typography.titleMedium
                        )
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