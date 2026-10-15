package org.stephennnamani.pursecheck.core.designsystem.brand

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import org.jetbrains.compose.resources.painterResource
import org.stephennnamani.pursecheck.core.designsystem.theme.PurseCheckTheme
import org.stephennnamani.pursecheck.resources.Res
import org.stephennnamani.pursecheck.resources.pursecheck_logo_horizontal
import org.stephennnamani.pursecheck.resources.pursecheck_logo_horizontal_dark
import org.stephennnamani.pursecheck.resources.pursecheck_logo_stacked
import org.stephennnamani.pursecheck.resources.pursecheck_logo_stacked_dark
import org.stephennnamani.pursecheck.resources.pursecheck_mark
import org.stephennnamani.pursecheck.resources.pursecheck_mark_dark

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
    val isDark = PurseCheckTheme.isDark

    val resource = when (variant) {
        PurseCheckLogoVariant.Mark ->
            if (isDark) {
                Res.drawable.pursecheck_mark_dark
            } else {
                Res.drawable.pursecheck_mark
            }
        PurseCheckLogoVariant.Horizontal -> {
            if (isDark) {
                Res.drawable.pursecheck_logo_horizontal_dark
            } else {
                Res.drawable.pursecheck_logo_horizontal
            }
        }
        PurseCheckLogoVariant.Stacked -> {
            if (isDark) {
                Res.drawable.pursecheck_logo_stacked_dark
            } else {
                Res.drawable.pursecheck_logo_stacked
            }
        }
    }

    Image(
        painter = painterResource(resource),
        contentDescription = null,
        contentScale = ContentScale.Fit,
        modifier = modifier
    )
}