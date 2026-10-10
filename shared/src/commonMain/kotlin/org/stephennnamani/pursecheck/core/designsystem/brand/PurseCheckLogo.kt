package org.stephennnamani.pursecheck.core.designsystem.brand

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import org.jetbrains.compose.resources.painterResource
import org.stephennnamani.pursecheck.resources.Res
import org.stephennnamani.pursecheck.resources.pursecheck_logo_horizontal
import org.stephennnamani.pursecheck.resources.pursecheck_logo_stacked
import org.stephennnamani.pursecheck.resources.pursecheck_mark

enum class PurseCheckLogoVariant {
    Mark,
    Horizontal,
    Stacked
}

@Composable
fun PurseCheckLogo (
    variant: PurseCheckLogoVariant,
    modifier: Modifier = Modifier
){
    val resource = when (variant) {
        PurseCheckLogoVariant.Mark -> Res.drawable.pursecheck_mark
        PurseCheckLogoVariant.Horizontal -> Res.drawable.pursecheck_logo_horizontal
        PurseCheckLogoVariant.Stacked -> Res.drawable.pursecheck_logo_stacked
    }

    Image(
        painter = painterResource(resource),
        contentDescription = null,
        contentScale = ContentScale.Fit,
        modifier = modifier
    )
}